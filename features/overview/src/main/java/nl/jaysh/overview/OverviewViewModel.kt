package nl.jaysh.overview

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.raise.fold
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import nl.jaysh.domain.use_cases.GetNewsOverviewUseCase
import nl.jaysh.model.Article
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
    private val getNews: GetNewsOverviewUseCase,
) : ViewModel() {

    private val defaultQuery = "Android"

    val state: StateFlow<OverviewModelState> = loadData()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = OverviewModelState.Loading,
        )

    @VisibleForTesting
    private fun loadData() = flow {
        fold(
            block = { getNews(query = defaultQuery) },
            recover = { failure -> emit(OverviewModelState.Error(message = failure.message)) },
            transform = { news -> emit(OverviewModelState.Success(news = news)) }
        )
    }
}

sealed class OverviewModelState {
    data object Loading : OverviewModelState()
    data class Error(val message: String) : OverviewModelState()
    data class Success(val news: List<Article>) : OverviewModelState()
}
