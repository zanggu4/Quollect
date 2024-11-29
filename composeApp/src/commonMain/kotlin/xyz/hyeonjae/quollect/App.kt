package xyz.hyeonjae.quollect

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import xyz.hyeonjae.quollect.feature.splash.SplashScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        SplashScreen(modifier = Modifier.fillMaxSize())
    }
}
