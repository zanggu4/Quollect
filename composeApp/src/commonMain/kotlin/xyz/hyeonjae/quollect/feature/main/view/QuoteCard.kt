package xyz.hyeonjae.quollect.feature.main.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.hyeonjae.quollect.feature.main.viewdata.QuoteViewData

@Composable
fun QuoteCard(
    modifier: Modifier = Modifier,
    viewData: QuoteViewData
) {
    Card(
        modifier = modifier, // 외부에서 Modifier 받아서 적용
        shape = RoundedCornerShape(12.dp),
        elevation = 1.dp, // 그림자 효과
        backgroundColor = Color.White, // 배경색
    ) {
        // 중앙 (명언 텍스트)
        Column(
            modifier = Modifier
                .padding(20.dp), // 내부 패딩
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = viewData.koreanText,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start,
            )
            if (viewData.originalText != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = viewData.originalText,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Start,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = viewData.speaker?.name ?: "",
                color = Color.DarkGray,
                fontSize = 14.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth() // 오른쪽 정렬
            )
            Text(
                text = "(${viewData.speaker?.lifespan})",
                color = Color.DarkGray,
                fontSize = 14.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth() // 오른쪽 정렬
            )
        }
    }
}