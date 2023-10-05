package nl.jaysh.data.news

import arrow.core.raise.Raise
import nl.jaysh.domain.repositories.NewsRepository
import nl.jaysh.model.Article
import nl.jaysh.model.exception.RequestFailed
import nl.jaysh.network.NewsDataSource
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsDataSource: NewsDataSource,
) : NewsRepository {

    context(Raise<RequestFailed>)
    override suspend fun listNews(query: String): List<Article> = newsDataSource
        .getNews(query = query)
        .map { article -> article.toArticle() }
}
