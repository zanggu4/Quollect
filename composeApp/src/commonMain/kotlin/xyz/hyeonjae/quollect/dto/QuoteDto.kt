package xyz.hyeonjae.quollect.dto

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class QuoteDto(
    @SerialName("quote_id") val quoteId: Long,
    @SerialName("speaker_id") val speakerId: Long,
    @SerialName("original_text") val originalText: String,
    @SerialName("korean_translation") val koreanTranslation: String?,
    @SerialName("english_translation") val englishTranslation: String?,
    @SerialName("description") val description: String?,
    @SerialName("speakers") val speaker: SpeakerDto?,
)
