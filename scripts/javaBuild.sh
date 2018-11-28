#!/bin/bash

num=$1

if ! mvn clean compile >/dev/null 2>/dev/null ; then
    echo "Task $num: Build failing!"
    mvn clean compile
    exit 1
fi

echo "Task $num: Build passing..."

exit 0
