//
// Copyright (C) 2025 kenway214
// SPDX-License-Identifier: Apache-2.0
//

package com.android.revanced

import android.os.SystemProperties
import android.util.Log

object ReVancedManager {
    private const val TAG = "ReVancedManager"
    private const val PROPERTY_REVANCED_ENABLED = "persist.sys.revan.mod"
    private const val DEFAULT_ENABLED = true

    fun isEnabled(): Boolean =
        SystemProperties.getBoolean(PROPERTY_REVANCED_ENABLED, DEFAULT_ENABLED)

    fun setEnabled(enabled: Boolean): Boolean = try {
        SystemProperties.set(PROPERTY_REVANCED_ENABLED, if (enabled) "true" else "false")
        Log.i(TAG, "ReVanced ${if (enabled) "enabled" else "disabled"}")
        true
    } catch (e: Exception) {
        Log.e(TAG, "Failed to set ReVanced state: ${e.message}")
        false
    }

    fun getPropertyValue(): String =
        SystemProperties.get(PROPERTY_REVANCED_ENABLED, DEFAULT_ENABLED.toString())
}
