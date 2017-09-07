#!/bin/bash

if ! [[ -z `find -name pom.xml` ]] ; then
    exit 0
fi


num=$1
srcFolder="src"
testFolder="test"
jarJUnit="../../../../junit-4.12.jar"
jarHamcrestCore="../../../../hamcrest-core-1.3.jar"

if ! [[ -z `find -name test` ]] ; then
    testClass=`find $testFolder -name *.java`
fi

if ! [[ -z $testClass ]] ; then
    mkdir testOut

    for i in $testClass
    do
        packageName=`grep "package" $i`
        packageName=${packageName#"package "}
        packageName=${packageName%";"}
        if ! [[ -z $packageName ]] ; then
            packageName="$packageName."
        fi
    
        testClassName=${i%".java"}
        testClassName=${testClassName#"$testFolder/${packageName//"."/"/"}"}

        if ! javac -classpath $jarJUnit:$jarHamcrestCore -sourcepath $srcFolder -d testOut $i >/dev/null 2>/dev/null ; then
            javac -classpath $jarJUnit:$jarHamcrestCore -sourcepath $srcFolder -d testOut $i
            echo "Task $num: Test failing!"
            exit 1
        fi

        if ! java -classpath $jarJUnit:$jarHamcrestCore:testOut org.junit.runner.JUnitCore $packageName$testClassName >/dev/null 2>/dev/null ; then
            java -classpath $jarJUnit:$jarHamcrestCore:testOut org.junit.runner.JUnitCore $packageName$testClassName
            echo "Task $num: Test failing!"
            exit 1
        fi
    done

    echo "Task $num: Test passing..."
fi

exit 0
