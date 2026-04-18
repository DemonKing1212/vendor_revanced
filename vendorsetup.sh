#!/bin/bash

REV_ROOT="vendor/revanced"
PRODUCT_APP="$REV_ROOT/common/product/app"
PRODUCT_RV="$REV_ROOT/common/product/etc/rv"

echo "--- ReVanced: Initializing Build Environment ---"

merge_apk_parts() {
    local dir=$1
    local base_name=$2

    if [ -f "$dir/${base_name}.part000" ]; then
        echo "Merging: $base_name in $dir"
        cat "$dir/${base_name}.part"* > "$dir/${base_name}"
        if [ $? -eq 0 ]; then
            echo "Successfully merged $base_name"
        else
            echo "Error: Failed to merge $base_name"
            return 1
        fi
    fi
}

extract_libs() {
    local app_dir=$1
    local apk_name=$2

    if [ -f "$app_dir/$apk_name" ]; then
        echo "Extracting libs for $apk_name..."
        rm -rf "$app_dir/lib"

        unzip -q -o "$app_dir/$apk_name" "lib/arm64-v8a/*" -d "$app_dir"

        if [ -d "$app_dir/lib/arm64-v8a" ]; then
            mv "$app_dir/lib/arm64-v8a" "$app_dir/lib/arm64"
            touch "$app_dir/lib/placeholder.txt"
            echo "Libs processed: $app_dir/lib/arm64"
        fi
    fi
}

merge_apk_parts "$PRODUCT_RV" "YTMusicPatched.apk"
merge_apk_parts "$PRODUCT_RV" "YTPatched.apk"
merge_apk_parts "$PRODUCT_APP/YTMusic" "com.google.android.apps.youtube.music.apk"
merge_apk_parts "$PRODUCT_APP/YouTube" "com.google.android.youtube.apk"

extract_libs "$PRODUCT_APP/YTMusic" "com.google.android.apps.youtube.music.apk"
extract_libs "$PRODUCT_APP/YouTube" "com.google.android.youtube.apk"

echo "--- ReVanced: Setup Complete ---"
