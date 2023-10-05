package nl.jaysh.domain.use_cases

import arrow.core.raise.Raise
import nl.jaysh.domain.repositories.NewsRepository
import nl.jaysh.model.Article
import nl.jaysh.model.exception.RequestFailed
import javax.inject.Inject

class GetNewsOverviewUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    context(Raise<RequestFailed>)
    suspend operator fun invoke(query: String): List<Article> {
        return newsRepository.listNews(query = query)
    }
}
