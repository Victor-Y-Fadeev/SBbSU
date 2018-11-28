#!/bin/bash

num=$1

if ! [[ -d src/test ]] ; then
    exit 0
fi

if ! mvn clean test >/dev/null 2>/dev/null ; then
    echo "Task $num: Test failing!"
    mvn clean test
    exit 1
fi

echo "Task $num: Test passing..."

exit 0
