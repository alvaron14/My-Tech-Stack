#!/bin/bash

LABELS=$(echo "$1" | jq -r '.[].name')
RELEASE_TYPE="minor"  # default if no label

for label in $LABELS; do
  label="${label##*/}"

  if [[ "$label" == "patch" || "$label" == "minor" || "$label" == "major" ]]; then
    RELEASE_TYPE="$label"
    break
  fi
done

echo $RELEASE_TYPE