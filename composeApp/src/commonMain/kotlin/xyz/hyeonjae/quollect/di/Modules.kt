package xyz.hyeonjae.quollect.di

import androidx.navigation.NavController
import org.koin.core.module.Module
import org.koin.dsl.module
import xyz.hyeonjae.quollect.di.router.DefaultSplashRouter
import xyz.hyeonjae.quollect.feature.splash.SplashRouter

fun routerModules(navController: NavController): Array<Module> {
    return arrayOf(
        module {
            factory<SplashRouter> { DefaultSplashRouter(navController) }
        }
    )
}