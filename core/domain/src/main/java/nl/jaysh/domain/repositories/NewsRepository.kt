package nl.jaysh.domain.repositories

import arrow.core.raise.Raise
import nl.jaysh.model.Article
import nl.jaysh.model.exception.RequestFailed

interface NewsRepository {
    context(Raise<RequestFailed>)
    suspend fun listNews(query: String): List<Article>
}
