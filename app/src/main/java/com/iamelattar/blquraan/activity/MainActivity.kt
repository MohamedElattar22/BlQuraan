package com.iamelattar.blquraan.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.iamelattar.blquraan.features.home.ui.screen.HomeScreen
import com.iamelattar.blquraan.features.quraan.ui.screen.QuraanFiltersScreen
import com.iamelattar.blquraan.navigation.HomeScreen
import com.iamelattar.blquraan.navigation.NavDisplayComp
import com.iamelattar.blquraan.navigation.QuraanScreenRoute
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val backStack = rememberNavBackStack(HomeScreen)
            BlQuraanTheme {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    NavDisplayComp(
                        backStack
                    )
                }
            }

        }
    }
    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}

