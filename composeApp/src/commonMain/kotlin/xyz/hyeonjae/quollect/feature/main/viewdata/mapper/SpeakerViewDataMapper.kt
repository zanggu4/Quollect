package xyz.hyeonjae.quollect.feature.main.viewdata.mapper

import xyz.hyeonjae.quollect.dto.SpeakerDto
import xyz.hyeonjae.quollect.feature.main.viewdata.SpeakerViewData

class SpeakerViewDataMapper {
    fun viewData(dto: SpeakerDto?): SpeakerViewData? {
        return dto?.let {
            SpeakerViewData(
                id = it.speakerId,
                name = it.koreanName,
                lifespan = calculateLifespan(it.birthYear, it.deathYear),
            )
        }
    }

    private fun calculateLifespan(birthYear: Int?, deathYear: Int?): String {
        return when {
            birthYear != null && deathYear != null -> "$birthYear - $deathYear"
            birthYear != null -> "$birthYear"
            deathYear != null -> "$deathYear"
            else -> ""
        }
    }
}