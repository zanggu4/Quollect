package xyz.hyeonjae.quollect.feature.main.viewdata

data class QuoteViewData(
    val id: Long,
    val speaker: SpeakerViewData?,
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
