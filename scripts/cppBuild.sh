#!/bin/bash

num=$1

if ! make >/dev/null 2>/dev/null ; then
    echo "Task $num: Build failing!"
    make
    exit 1
fi

echo "Task $num: Build passing..."

exit 0
