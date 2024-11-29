package xyz.hyeonjae.quollect.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import quollect.composeapp.generated.resources.Res
import quollect.composeapp.generated.resources.logo

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    router: SplashRouter = koinInject()
) {
    LaunchedEffect(Unit) {
        delay(1000)
        router.startMain()
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = null
        )
    }
}