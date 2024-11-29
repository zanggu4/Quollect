package xyz.hyeonjae.quollect.feature.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import quollect.composeapp.generated.resources.Res
import quollect.composeapp.generated.resources.ic_bookmark
import quollect.composeapp.generated.resources.ic_bulb
import quollect.composeapp.generated.resources.ic_paw
import quollect.composeapp.generated.resources.ic_share

@Composable
fun MainScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    router: MainRouter = koinInject()
) {
    Column(
        modifier = modifier
            .background(gradientBackground())
            .padding(
                horizontal = 20.dp,
                vertical = 40.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Daily Quote",
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(Modifier.height(30.dp))
        Image(
            painter = painterResource(Res.drawable.ic_paw),
            contentDescription = null,
            modifier = Modifier.size(60.dp),
        )
        Spacer(Modifier.height(30.dp))
        Text(
            text = "과거는 우리의 그림자일 뿐, 우리가 그 안에 살 필요는 없다.",
            fontSize = 30.sp,
            lineHeight = 40.sp,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(20.dp))
        Text(
            text = "\"The past is only our shadow; we don’t need to live in it.\"",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "\"Der Vergangenheit ist nur unser Schatten; wir müssen nicht darin leben.\"",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.weight(1.0f))
        Row(modifier = Modifier.padding(horizontal = 20.dp)) {
            IconButton(res = Res.drawable.ic_bookmark) {}
            Spacer(Modifier.weight(1.0f))
            IconButton(res = Res.drawable.ic_bulb) {}
            Spacer(Modifier.weight(1.0f))
            IconButton(res = Res.drawable.ic_share) {}
        }
    }
}

private fun gradientBackground(): Brush {
    return Brush.linearGradient(
        colors = listOf(
            Color(255, 255, 255),
            Color(173, 216, 230),
            Color(216, 191, 216),
        ), // 시작 색상과 끝 색상
        start = Offset.Zero,
        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY),
    )
}

@Composable
private fun IconButton(res: DrawableResource, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent, // 배경색 투명
        ),
        elevation = null, // 그림자 제거
        contentPadding = PaddingValues(8.dp),
        content = {
            Image(
                painter = painterResource(res),
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                colorFilter = ColorFilter.tint(Color.White),
            )
        }
    )
}
