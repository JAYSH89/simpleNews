package nl.jaysh.network

import arrow.core.raise.Raise
import nl.jaysh.model.exception.RequestFailed
import nl.jaysh.network.model.dto.ArticleDTO

interface NewsDataSource {
    context(Raise<RequestFailed>)
    suspend fun getNews(query: String): List<ArticleDTO>
}
