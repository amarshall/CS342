#!/bin/bash

suffix=$1
dir="$(pwd)/$2"
# dir=$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)
ln -s "$dir" "/tmp/Marshall_John_$suffix"
tar czL --exclude build -C /tmp/ -f "$HOME/Desktop/Marshall_John_$suffix.tar.gz" "Marshall_John_$suffix"
rm "/tmp/Marshall_John_$suffix"
