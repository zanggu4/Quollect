package xyz.hyeonjae.quollect.feature.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import quollect.composeapp.generated.resources.Res
import quollect.composeapp.generated.resources.logo

@Composable
fun MainScreen(
    quote: String,
    author: String,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    onShareClick: () -> Unit,
    onAirbnbClick: () -> Unit // 에어비앤비 추천 클릭 이벤트
) {
    val pageCount = 5
    val pagerState = rememberPagerState(
        initialPage = 0, // 시작 페이지
        initialPageOffsetFraction = 0f, // 시작 페이지 오프셋 (0.0 ~ 1.0)
    ) {
        pageCount // 페이지 개수 제공 (Compose 1.7.0-alpha03 이상)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), // 흰색 배경
        verticalArrangement = Arrangement.SpaceBetween, // 위, 아래, 중앙에 요소 배치
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f), // 남은 공간을 모두 채우도록
            contentPadding = PaddingValues(horizontal = 32.dp), // 양쪽 패딩 (선택 사항)
            pageSpacing = 16.dp,
        ) { page ->
            quoteCard(
                viewData = QuoteViewData.sample()
            )
        }
        // 하단 (액션 버튼)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = onFavoriteClick) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = "Favorite",
                    // tint = Color.Black // 아이콘 색상을 기본값(보통 검정)으로
                )
            }

            IconButton(onClick = onShareClick) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Share",
                    // tint = Color.Black
                )
            }
            // Airbnb 추천 버튼 (선택 사항)

            Box(
                modifier = Modifier
                    .clickable(onClick = onAirbnbClick)
                    .padding(8.dp)

            ) {
                Image(
                    painter = painterResource(Res.drawable.logo),  // 에어비앤비 로고 이미지
                    contentDescription = "Airbnb Recommendations",
                    modifier = Modifier.size(24.dp) // 적절한 크기로 조정
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun quoteCard(
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
                text = viewData.speaker.name,
                color = Color.DarkGray,
                fontSize = 14.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth() // 오른쪽 정렬
            )
            Text(
                text = "(${viewData.speaker.lifespan})",
                color = Color.DarkGray,
                fontSize = 14.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth() // 오른쪽 정렬
            )
        }
    }
}

data class QuoteViewData(
    val id: Long,
    val speaker: SpeakerViewData,
    val koreanText: String,
    val originalText: String?,

    ) {
    companion object {
        fun sample(): QuoteViewData {
            return QuoteViewData(
                id = 1,
                speaker = SpeakerViewData.sample(),
                koreanText = "바람의 방향이 바뀔 때, 어떤 이들은 벽을 세우고, 어떤 이들은 풍차를 만든다.",
                originalText = "Салхины чиглэл өөрчлөгдөхөд, зарим нь хана босгож, зарим нь салхин тээрэм барьдаг.",
            )
        }
    }
}

data class SpeakerViewData(
    val id: Long,
    val name: String,
    val lifespan: String,
) {
    companion object {
        fun sample(): SpeakerViewData {
            return SpeakerViewData(
                id = 1,
                name = "바야르마 몽흐바트",
                lifespan = "1921~1998"
            )
        }
    }
}