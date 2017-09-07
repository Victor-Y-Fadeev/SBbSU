#!/bin/bash

num=$1
files=`ls *.cpp`
main=`grep -rl " main(" .`
main=${main%".cpp"}

if ! g++ -std=c++11 $files -o $main.out >/dev/null 2>/dev/null ; then
    g++ -std=c++11 $files -o $main.out
    echo "Task $num: Build failing!"
    exit 1
fi

echo "Task $num: Build passing..."

exit 0
