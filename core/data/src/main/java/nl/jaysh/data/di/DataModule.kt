package nl.jaysh.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nl.jaysh.domain.repositories.NewsRepository
import nl.jaysh.data.news.NewsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsNewsRepository(newsRepository: NewsRepositoryImpl): NewsRepository
}
