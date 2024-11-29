package xyz.hyeonjae.quollect.feature.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject

@Composable
fun MainScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    router: MainRouter = koinInject()
) {
    Surface(modifier = modifier) {
        Text("Main Screen")
    }
}