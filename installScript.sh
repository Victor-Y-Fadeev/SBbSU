#!/bin/bash

#---CppInstall---

add-apt-repository -y ppa:ubuntu-toolchain-r/test
apt-get update -y
apt-get install -y g++-4.8
update-alternatives --install /usr/bin/g++ g++ /usr/bin/g++-4.8 50

exit 0
