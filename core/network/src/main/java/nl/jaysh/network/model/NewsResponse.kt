package nl.jaysh.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.jaysh.network.model.dto.ArticleDTO

@Serializable
internal open class NewsResponse(
    @SerialName("status") val status: String,
    @SerialName("totalResults") val totalResults: Int,
    @SerialName("articles") val articles: List<ArticleDTO>,
)
