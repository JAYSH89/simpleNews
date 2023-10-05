package nl.jaysh.network.ktor

import arrow.core.raise.Raise
import arrow.core.raise.ensure
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.http.isSuccess
import nl.jaysh.model.exception.RequestFailed
import nl.jaysh.network.NewsDataSource
import nl.jaysh.network.ktor.resource.EverythingResource
import nl.jaysh.network.model.NewsResponse
import nl.jaysh.network.model.dto.ArticleDTO
import javax.inject.Inject

internal class NewsDataSourceImpl @Inject constructor(
    private val client: HttpClient,
) : NewsDataSource {

    context(Raise<RequestFailed>)
    override suspend fun getNews(query: String): List<ArticleDTO> {
        val response = client.get(EverythingResource(q = query))

        ensure(response.status.isSuccess()) {
            val errorMessage = "Something went wrong"
            RequestFailed(errorMessage, response.status.value)
        }

        val body = response.body<NewsResponse>()
        return body.articles
    }
}
