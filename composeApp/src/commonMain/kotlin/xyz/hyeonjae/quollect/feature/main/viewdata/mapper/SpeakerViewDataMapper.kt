package xyz.hyeonjae.quollect.feature.main.viewdata.mapper

import xyz.hyeonjae.quollect.dto.SpeakerDto
import xyz.hyeonjae.quollect.feature.main.viewdata.SpeakerViewData
import kotlin.math.abs

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
            birthYear != null && deathYear != null -> "${yearText(birthYear)} - ${yearText(deathYear)}"
            birthYear != null -> "${yearText(birthYear)} - "
            deathYear != null -> yearText(deathYear)
            else -> ""
        }
    }

    private fun yearText(year: Int): String {
        return if (year < 0) {
            "기원전 ${abs(year)}"
        } else {
            "$year"
        }
    }
}