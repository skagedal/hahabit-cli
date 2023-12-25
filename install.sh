#!/usr/bin/env bash

set -e

# cd java-client

# TOOL=hahabit
# BIN=${HOME}/local/bin
# BUILT_BINARY=`pwd`/${TOOL}/build/install/${TOOL}/bin/${TOOL}

# ./gradlew install
# ln -fs ${BUILT_BINARY} ${BIN}/${TOOL}-java
# cd ../rust/hahabit

cd rust/hahabit
cargo install --path .

