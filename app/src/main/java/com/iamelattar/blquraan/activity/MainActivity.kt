package com.iamelattar.blquraan.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation3.runtime.NavBackStack
import com.iamelattar.blquraan.features.quraan.ui.screen.QuraanFiltersScreen
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlQuraanTheme {
                val navBackStack = NavBackStack()
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    QuraanFiltersScreen()
                }
            }
        }
    }
}

