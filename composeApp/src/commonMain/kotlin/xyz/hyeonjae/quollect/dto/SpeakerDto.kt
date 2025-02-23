package xyz.hyeonjae.quollect.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpeakerDto(
    @SerialName("speaker_id") val speakerId: Long,
    @SerialName("korean_name") val koreanName: String,
    @SerialName("english_name") val englishName: String,
    @SerialName("native_name") val nativeName: String,
    @SerialName("nationality") val nationality: String,
    @SerialName("birth_year") val birthYear: Int?,
    @SerialName("death_year") val deathYear: Int?,
    @SerialName("is_real") val isReal: Boolean,
    @SerialName("biography") val biography: String,
)