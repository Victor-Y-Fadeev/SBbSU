#!/bin/bash

folder=$1
buildScript=$2
testScript=$3

cd $folder
echo -e "\nCourse ${folder:6:1} (semester ${folder:11})\n"

for a in 0 1 2
do
    for i in `ls -d */`
    do
        i=${i%"/"}
        if [[ (${#i} == 3 && $a == 0) || (${#i} == 4 && $a == 1) || (${#i} == 5 && $a == 2) ]] ; then
            if [[ $a == 2 ]] ; then
                echo "Test ${i#"test"}"
            else
                echo "Homework ${i#"hw"}"
            fi
            cd $i
    
            for b in 0 1
            do
                for j in `ls -d */`
                do
                    j=${j%"/"}
                    if [[ (${#j} == 5 && $b == 0) || (${#j} == 6 && $b == 1) ]] ; then        
                        cd $j
                        
                        if ! ../../$buildScript ${j#"task"} ; then
                            exit 1
                        fi

                        if ! [[ -z $testScript ]] ; then
                            if ! ../../$testScript ${j#"task"} ; then
                                exit 1
                            fi
                        fi

                        cd ..        
                        fi
                done    
            done
    
            cd ..
            echo ""
        fi
    done
done

cd ../..

exit 0
