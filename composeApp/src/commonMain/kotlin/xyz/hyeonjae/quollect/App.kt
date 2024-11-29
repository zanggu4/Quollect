package xyz.hyeonjae.quollect

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import xyz.hyeonjae.quollect.di.routerModules
import xyz.hyeonjae.quollect.feature.main.MainScreen
import xyz.hyeonjae.quollect.feature.splash.SplashScreen

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    KoinApplication(application = {
        modules(*routerModules(navController))
    }) {
        MaterialTheme {
            NavHost(navController = navController, startDestination = "Splash") {
                composable(route = "Splash") {
                    SplashScreen()
                }
                composable(route = "Main") {
                    MainScreen()
                }
            }
        }
    }
}

