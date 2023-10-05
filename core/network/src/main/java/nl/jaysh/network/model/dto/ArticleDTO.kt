package nl.jaysh.network.model.dto

import kotlinx.serialization.Serializable
import nl.jaysh.model.Article

@Serializable
data class ArticleDTO(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String,
) {
    fun toArticle() = Article(
        author = author,
        title = title,
        description = description,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt,
        content = content,
    )
}
