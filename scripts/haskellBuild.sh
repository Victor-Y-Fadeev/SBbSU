#!/bin/bash

num=$1
main=`grep -rl "main" *.hs`
out=${main//.hs/.out}

if [[ -z $main ]] ; then
    exit 0
fi

if ! ghc *.hs -o $out >/dev/null 2>/dev/null ; then
    echo "Task $num: Build failing!"
    ghc *.hs -o $out
    exit 1
fi

echo "Task $num: Build passing..."

exit 0
