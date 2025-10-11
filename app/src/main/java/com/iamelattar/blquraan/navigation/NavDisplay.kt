package com.iamelattar.blquraan.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.iamelattar.blquraan.features.home.ui.screen.HomeScreen
import com.iamelattar.blquraan.features.quraan.ui.screen.QuraanFiltersScreen

@Composable
fun NavDisplayComp(
    backStack: NavBackStack
) {
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<HomeScreen> {
                HomeScreen(
                    onNavigate = { feature ->
                    }
                )
            }
            entry<QuraanScreenRoute> {
                QuraanFiltersScreen()
            }
        }
    )
}