#!/usr/bin/env bash
set -e

exec $("$(dirname "$(which "${0}")")/javaenv" home)/bin/java "${@}"
