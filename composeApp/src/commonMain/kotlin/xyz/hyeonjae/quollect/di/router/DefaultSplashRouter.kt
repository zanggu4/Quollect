package xyz.hyeonjae.quollect.di.router

import androidx.navigation.NavController
import xyz.hyeonjae.quollect.feature.splash.SplashRouter

class DefaultSplashRouter(private val navController: NavController) : SplashRouter {
    override fun startMain() {
        navController.navigate(route = "Main") {
            // Splash는 끄기
            popUpTo("Splash") {
                inclusive = true
            }
        }
    }
}
