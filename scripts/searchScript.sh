#!/bin/bash

folder=$1
buildScript=$2
testScript=$3

cd $folder
echo -e "\nCourse ${folder:6:1} (semester ${folder:11})\n"

for i in `ls -d */ | sort -V`
do
    i=${i%"/"}

    if [[ $i == hw* ]] ; then
        echo "Homework ${i#"hw"}"
    else
        echo "Test ${i#"test"}"
    fi
    cd $i

    for j in `ls -d */ | sort -V`
    do
        j=${j%"/"}
        cd $j

        if ! ../../../../scripts/$buildScript ${j#"task"} ; then
            exit 1
        fi

        if ! [[ -z $testScript ]] ; then
            if ! ../../../../scripts/$testScript ${j#"task"} ; then
                exit 1
            fi
        fi

        cd ..
    done

    cd ..
    echo ""
done

cd ../..

exit 0
