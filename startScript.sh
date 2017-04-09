#!/bin/bash
 
echo ""
echo "Course 1 (semester 1)"
echo ""

cd course1/semester1

if ! ../../searchScript.sh cppBuild.sh ; then
    exit 1
fi

cd ../..


echo ""
echo "Course 1 (semester 2)"
echo ""

cd course1/semester2

if ! ../../searchScript.sh javaBuild.sh javaTest.sh ; then
    exit 1
fi

cd ../..


exit 0
