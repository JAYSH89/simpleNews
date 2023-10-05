package nl.jaysh.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import logcat.LogPriority
import logcat.logcat
import nl.jaysh.network.NewsDataSource
import nl.jaysh.network.ktor.NewsDataSourceImpl
import nl.jaysh.simplenews.core.network.BuildConfig
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val TAG = "KTOR"
    private const val URL = "newsapi.org/v2"

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun providesHttpClient(jsonConfig: Json): HttpClient = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    logcat(TAG, LogPriority.DEBUG) { message }
                }
            }
        }

        engine {
            connectTimeout = 100_000
            socketTimeout = 100_000
        }

        install(ContentNegotiation) {
            json(jsonConfig)
        }

        install(DefaultRequest) {
            url {
                protocol = URLProtocol.HTTPS
                host = URL
            }
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            header("X-Api-Key", BuildConfig.API_KEY)
        }

        install(Resources)
    }

    @Provides
    @Singleton
    fun providesNewsDataSource(client: HttpClient): NewsDataSource = NewsDataSourceImpl(client)
}
