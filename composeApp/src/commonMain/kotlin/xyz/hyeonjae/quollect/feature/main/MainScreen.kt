package xyz.hyeonjae.quollect.feature.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import quollect.composeapp.generated.resources.Res
import quollect.composeapp.generated.resources.logo
import xyz.hyeonjae.quollect.feature.main.view.QuoteCardPager
import xyz.hyeonjae.quollect.feature.main.viewmodel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = koinInject(),
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    onShareClick: () -> Unit,
    onAirbnbClick: () -> Unit // 에어비앤비 추천 클릭 이벤트
) {
    val quotes by viewModel.quotes.collectAsState(emptyList())

    // 초기화
    LaunchedEffect(Unit) {
        viewModel.reset()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), // 흰색 배경
        verticalArrangement = Arrangement.SpaceBetween, // 위, 아래, 중앙에 요소 배치
    ) {
        QuoteCardPager(
            quotes = quotes,
            modifier = Modifier.weight(1f),
            loadMoreAction = {
                viewModel.loadMore()
            }
        )

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
