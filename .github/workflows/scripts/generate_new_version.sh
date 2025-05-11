#!/bin/bash

if [[ -z "$1" ]]; then
  echo "Failed to read current version from pom.xml"
  exit 1
fi

# Split into components
IFS='.' read -r major minor patch <<<"${1//-SNAPSHOT/}"

# Which part to bump?
part_to_bump=$2  # "major", "minor", or "patch"

case $part_to_bump in
  major)
    ((major+=1)); minor=0; patch=0;;
  minor)
    ((minor+=1)); patch=0;;
  patch)
    ((patch+=1));;
  *)
    echo "Usage: $0 {major|minor|patch}"
    exit 1
esac

new_version="${major}.${minor}.${patch}"

echo "$new_version"