package xyz.hyeonjae.quollect.feature.main.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.hyeonjae.quollect.feature.main.viewdata.QuoteViewData

@Composable
fun QuoteCardPager(
    quotes: List<QuoteViewData>,
    modifier: Modifier,
    loadMoreAction: () -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = 0, // 시작 페이지
        initialPageOffsetFraction = 0f, // 시작 페이지 오프셋 (0.0 ~ 1.0)
        pageCount = { quotes.size }
    )

    val loadMoreAvailable = quotes.isNotEmpty() && pagerState.currentPage >= quotes.size - 2
    LaunchedEffect(loadMoreAvailable) {
        if (loadMoreAvailable) {
            loadMoreAction()
        }
    }

    // 카드 페이저
    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 32.dp), // 양쪽 패딩 (선택 사항)
        pageSpacing = 16.dp,
    ) { page ->
        val quote = quotes[page]
        QuoteCard(viewData = quote)
    }
}
