//
// Copyright (C) 2025 kenway214
// SPDX-License-Identifier: Apache-2.0
//

package com.android.revanced

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.ComponentName
import android.content.pm.PackageManager

class BootCompletedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Intent.ACTION_LOCKED_BOOT_COMPLETED && 
            intent.action != Intent.ACTION_BOOT_COMPLETED) return

        val pm = context.packageManager
        val componentName = ComponentName(context, ReVancedActivity::class.java)
        
        pm.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }
}