#!/usr/bin/env bash

JAVA_NATIVE_CLIENT_DIR=java-native-client

rm -rf $JAVA_NATIVE_CLIENT_DIR}
openapi-generator generate \
    --input-spec ~/code/hahabit/openapi.yaml \
    --generator-name java \
    --library native \
    --package-name tech.skagedal.hahabit.cli \
    --output $JAVA_NATIVE_CLIENT_DIR

