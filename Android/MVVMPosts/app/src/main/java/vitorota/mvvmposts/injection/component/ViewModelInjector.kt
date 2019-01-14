package vitorota.mvvmposts.injection.component

import dagger.Component
import vitorota.mvvmposts.injection.module.NetworkModule
import vitorota.mvvmposts.ui.post.PostListViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ViewModelInjector {

    fun inject(postListViewModel: PostListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }

}