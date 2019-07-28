#!/usr/bin/env bash
set -e

d=$(dirname "$(which "${0}")")
java_home=$("$d/javaenv" home)
exec ${java_home}/bin/java "${@}"

