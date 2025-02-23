package xyz.hyeonjae.quollect.di

import androidx.navigation.NavController
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.serializer.KotlinXSerializer
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import xyz.hyeonjae.quollect.di.router.DefaultMainRouter
import xyz.hyeonjae.quollect.di.router.DefaultSplashRouter
import xyz.hyeonjae.quollect.feature.main.router.MainRouter
import xyz.hyeonjae.quollect.feature.main.viewmodel.MainViewModel
import xyz.hyeonjae.quollect.feature.splash.SplashRouter

fun routerModules(navController: NavController): Array<Module> {
    return arrayOf(
        module {
            factory<SplashRouter> { DefaultSplashRouter(navController) }
        },
        module {
            factory<MainRouter> { DefaultMainRouter(navController) }
        },
    )
}

fun viewModels(): Array<Module> {
    return arrayOf(
        module {
            viewModel { MainViewModel(get()) }
        },
    )
}

fun supabase(): Module {
    return module {
        factory<SupabaseClient> {
            createSupabaseClient(
                supabaseUrl = "https://awodphvhhrpyxmfkozsn.supabase.co",
                supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImF3b2RwaHZoaHJweXhtZmtvenNuIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzk2Nzk5MzgsImV4cCI6MjA1NTI1NTkzOH0.OTJZZ1XL5VuDpaMR3NOKJsDSZAdkIggMzsA-ikC5ch0"
            ) {
                defaultSerializer = KotlinXSerializer(Json {
                    explicitNulls = false
                })
                install(Postgrest)
            }
        }
    }
}
