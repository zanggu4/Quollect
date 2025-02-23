package xyz.hyeonjae.quollect.feature.main.viewdata.mapper

import xyz.hyeonjae.quollect.dto.QuoteDto
import xyz.hyeonjae.quollect.feature.main.viewdata.QuoteViewData

class QuoteViewDataMapper {
    fun viewData(dto: QuoteDto): QuoteViewData {
        return QuoteViewData(
            id = dto.quoteId,
            speaker = SpeakerViewDataMapper().viewData(dto.speaker),
            koreanText = dto.koreanTranslation ?: "",
            originalText = dto.originalText,
        )
    }
}
