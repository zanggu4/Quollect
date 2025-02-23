package xyz.hyeonjae.quollect

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import xyz.hyeonjae.quollect.di.routerModules
import xyz.hyeonjae.quollect.di.supabase
import xyz.hyeonjae.quollect.di.viewModels
import xyz.hyeonjae.quollect.feature.main.MainScreen
import xyz.hyeonjae.quollect.feature.splash.SplashScreen

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    var isFavorite by remember { mutableStateOf(false) }

    KoinApplication(application = {
        modules(*routerModules(navController), *viewModels(), supabase())
    }) {
        MaterialTheme {
            NavHost(navController = navController, startDestination = "Splash") {
                composable(route = "Splash") {
                    SplashScreen()
                }
                composable(route = "Main") {
                    MainScreen(
                        isFavorite = isFavorite,
                        onFavoriteClick = { isFavorite = !isFavorite },
                        onShareClick = { /* 공유 기능 구현 */ },
                        onAirbnbClick = { /* Airbnb 추천 로직 */ }
                    )
                }
            }
        }
    }
}

