package xyz.hyeonjae.quollect.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import quollect.composeapp.generated.resources.Res
import quollect.composeapp.generated.resources.logo

@Composable
fun SplashScreen(
    modifier: Modifier,
    router: SplashRouter? = null
) {
    LaunchedEffect(Unit) {
        router?.startMain()
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