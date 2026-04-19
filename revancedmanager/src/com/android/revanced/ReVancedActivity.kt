//
// Copyright (C) 2025 kenway214
// SPDX-License-Identifier: Apache-2.0
//

package com.android.revanced

import android.os.Bundle
import android.os.PowerManager
import android.content.Context
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android.revanced.ui.ReVancedScreen
import com.android.revanced.ui.ReVancedTheme

class ReVancedActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            ReVancedTheme {
                ReVancedScreen(
                    onToggle = { enabled ->
                        val success = ReVancedManager.setEnabled(enabled)
                        if (!success) {
                            Toast.makeText(this, R.string.revanced_toggle_failed, Toast.LENGTH_SHORT).show()
                        }
                    },
                    onReboot = {
                        val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
                        pm.reboot(null)
                    }
                )
            }
        }
    }
}
