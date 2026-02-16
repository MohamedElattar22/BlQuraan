package com.iamelattar.blquraan

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.iamelattar.blquraan.features.home.navigation.HomeGraph
import com.iamelattar.blquraan.navigation.AppNavGraph
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme
import com.iamelattar.blquraan.utils.hasPermissions

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun ComposeApp(
    onSplashVisibilityChange: (Boolean) -> Unit,
) {
    var isSplashScreenHidden by rememberSaveable { mutableStateOf(false) }
    var startDestination: Any by remember { mutableStateOf(HomeGraph.Route) }

    val navController = rememberNavController()
    val context = LocalContext.current
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {}
    )

    LaunchedEffect(isSplashScreenHidden) {
        if (!isSplashScreenHidden) {
            onSplashVisibilityChange(false)
            isSplashScreenHidden = true
            startDestination = HomeGraph.HomeScreen
        }
    }

    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (!context.hasPermissions(Manifest.permission.POST_NOTIFICATIONS)) {
                permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }

    if (isSplashScreenHidden) {
        BlQuraanTheme {
            Surface {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .imePadding(),
                    contentWindowInsets = WindowInsets(0)
                ) { paddingValues ->
                    AppNavGraph(
                        modifier = Modifier.padding(paddingValues),
                        navController = navController,
                        startDestination = startDestination
                    )
                }
            }
        }
    }
}