package com.iamelattar.blquraan.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.iamelattar.blquraan.features.home.ui.screen.HomeScreen
import com.iamelattar.blquraan.features.quraan.ui.screen.QuraanFiltersScreen
import java.util.Map.entry

@Composable
fun NavDisplayComp(
    backStack: NavBackStack
) {

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry <HomeScreen>{
                HomeScreen(backStack)
            }
            entry <QuraanScreenRoute>{
                QuraanFiltersScreen(
                   backStack = backStack
                )
            }

        }
    )
}