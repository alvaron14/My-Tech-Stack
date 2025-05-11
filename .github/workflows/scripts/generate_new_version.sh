#!/bin/bash

# Read current version from pom.xml
current_version=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

if [[ -z "$current_version" ]]; then
  echo "Failed to read current version from pom.xml"
  exit 1
fi

# Split into components
IFS='.' read -r major minor patch <<<"${current_version//-SNAPSHOT/}"

# Which part to bump?
part_to_bump=$1  # "major", "minor", or "patch"

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

new_version="${major}.${minor}.${patch}-SNAPSHOT"

echo "$new_version"