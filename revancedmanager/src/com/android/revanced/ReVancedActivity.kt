//
// Copyright (C) 2025 kenway214
// SPDX-License-Identifier: Apache-2.0
//

package com.android.revanced

import android.os.Bundle
import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity
import com.android.revanced.R

class ReVancedActivity : CollapsingToolbarBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(com.android.settingslib.collapsingtoolbar.R.id.content_frame, 
                ReVancedSettingsFragment())
            .commit()
    }
}
