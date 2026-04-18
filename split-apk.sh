#!/bin/bash

SIZE="20m"

find . -type f -name "*.apk" ! -name "*.part*" | while read -r apk; do
    echo "Splitting: $apk"

    rm -f "$apk.part"*

    if split -b $SIZE -d -a 3 "$apk" "$apk.part"; then
        echo "Successfully created parts for $(basename "$apk")"
    else
        echo "Error: Failed to split $apk"
    fi
done

echo "--- Splitting Complete ---"
