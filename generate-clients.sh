#!/usr/bin/env bash

BASE_PACKAGE=tech.skagedal.hahabit.generated
JAVA_CLIENT_DIR=java-client
TMP_DIR=$(mktemp -d)
PKG_DIR=src/main/java/tech/skagedal/hahabit
SOURCE_DIR=$TMP_DIR/$PKG_DIR/generated
TARGET_DIR=$JAVA_CLIENT_DIR/hahabit/$PKG_DIR

openapi-generator generate \
    --input-spec ~/code/hahabit/openapi.yaml \
    --generator-name java \
    --library native \
    --api-package ${BASE_PACKAGE}.api \
    --invoker-package ${BASE_PACKAGE}.invoker \
    --package-name ${BASE_PACKAGE}.package \
    --model-package ${BASE_PACKAGE}.model \
    --output $TMP_DIR \
    --additional-properties=hideGenerationTimestamp=true

rm -rf $TARGET_DIR/generated
cp -r $SOURCE_DIR $TARGET_DIR/

rm -rf rust/hahabit/openapi
openapi-generator generate \
    --input-spec ~/code/hahabit/openapi.yaml \
    --generator-name rust \
    --library reqwest \
    --output rust/hahabit/openapi
