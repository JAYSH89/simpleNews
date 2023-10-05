package nl.jaysh.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import nl.jaysh.model.Article

@Composable
fun OverviewScreen(viewModel: OverviewViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    OverviewScreenContent(state = state)
}

@Composable
private fun OverviewScreenContent(state: OverviewModelState) {
    Scaffold { paddingValues ->
        when (state) {
            is OverviewModelState.Error -> OverviewError(message = state.message)
            OverviewModelState.Loading -> OverviewLoading()
            is OverviewModelState.Success -> {
                Articles(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(all = 16.dp),
                    articles = state.news,
                )
            }
        }
    }
}

@Composable
private fun OverviewLoading() = Column(
    modifier = Modifier
        .fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
) {
    CircularProgressIndicator()
}

@Composable
private fun Articles(modifier: Modifier = Modifier, articles: List<Article>) = LazyColumn(
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(8.dp),
) {
    items(articles) { article ->
        Card(
            modifier = Modifier.fillMaxWidth(),
        ) {
            article.urlToImage?.let { url ->
                OverviewImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    url = url,
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text(
                    modifier = Modifier.padding(all = 12.dp),
                    text = article.title,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    modifier = Modifier.padding(all = 12.dp),
                    text = article.content,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun OverviewError(message: String) = Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
    content = { Text(text = message, style = MaterialTheme.typography.titleLarge) }
)

@Composable
private fun OverviewImage(modifier: Modifier = Modifier, url: String) {
    Column(modifier = modifier) {
        AsyncImage(
            model = url,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}
