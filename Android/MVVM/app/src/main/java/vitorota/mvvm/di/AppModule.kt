package vitorota.mvvm.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vitorota.mvvm.service.repository.GitHubService
import vitorota.mvvm.viewmodel.ProjectViewModelFactory
import javax.inject.Singleton

@Module(subcomponents = [ViewModelSubComponent::class])
class AppModule {

    @Singleton
    @Provides
    fun provideGithubService(): GitHubService =
        Retrofit.Builder()
            .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubService::class.java)

    @Singleton
    @Provides
    fun provideViewModelFactory(builder: ViewModelSubComponent.Builder): ViewModelProvider.Factory =
            ProjectViewModelFactory(builder.build())

}