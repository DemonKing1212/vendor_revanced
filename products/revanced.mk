#
# Copyright (C) 2025 kenway214
# SPDX-License-Identifier: Apache-2.0
#

# RevancedManager app
PRODUCT_PACKAGES += \
    RevancedManager

$(call inherit-product, vendor/revanced/common/common-vendor.mk)

# Sepolicy
include vendor/revanced/sepolicy/SEPolicy.mk

# Init
PRODUCT_COPY_FILES += \
    vendor/revanced/common/product/etc/init/init.rv.rc:$(TARGET_COPY_OUT_PRODUCT)/etc/init/init.rv.rc

# Enable by default
PRODUCT_PRODUCT_PROPERTIES += \
    persist.sys.revan.mod=true
