package xyz.hyeonjae.quollect.feature.main.viewdata

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