#!/bin/bash

num=$1
srcFolder="src"
mainClass=`grep -rl "public static void main(String\[\] args)" $srcFolder`

if ! [[ -z $mainClass ]] ; then
    packageName=`grep "package" $mainClass`
    packageName=${packageName#"package "}
    packageName=${packageName%";"}
    if ! [[ -z $packageName ]] ; then
        packageName="$packageName."
    fi
    
    mainClassName=${mainClass%".java"}
    mainClassName=${mainClassName#"$srcFolder/${packageName//"."/"/"}"}

    mkdir out
    if ! javac -sourcepath $srcFolder -d out $mainClass >/dev/null 2>/dev/null ; then
        javac -sourcepath $srcFolder -d out $mainClass
        echo "Task $num: Build failing!"
        exit 1
    fi

    javaFX=`find -name *.fxml`
    if ! [[ -z $javaFX ]] ; then
        cp $javaFX out${javaFX#"./$srcFolder"}

        for i in `grep "fx:controller=" $javaFX`
        do
            temp=`expr "$i" : '\(fx:controller="[A-Za-z0-9.]*"\)'`
            if ! [[ -z $temp ]] ; then
                temp=${temp#"fx:controller=\""}
                temp=${temp%"\""}
                temp=${temp//"."/"/"}
                controllerClass="$srcFolder/$temp.java"
            fi
        done

        if ! [[ -z $controllerClass ]] ; then
            if ! javac -sourcepath $srcFolder -d out $controllerClass >/dev/null 2>/dev/null ; then
                javac -sourcepath $srcFolder -d out $controllerClass
                echo "Task $num: Build failing!"
                exit 1
            fi
        fi
    fi

    if ! jar -cef $packageName$mainClassName $mainClassName.jar -C out . >/dev/null 2>/dev/null ; then
        jar -cef $packageName$mainClassName $mainClassName.jar -C out .
        echo "Task $num: Build failing!"
        exit 1
    fi
    
    echo "Task $num: Build passing..."
fi

exit 0
