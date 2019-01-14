package vitorota.mvvmposts.base

import androidx.lifecycle.ViewModel
import vitorota.mvvmposts.injection.component.DaggerViewModelInjector
import vitorota.mvvmposts.injection.component.ViewModelInjector
import vitorota.mvvmposts.injection.module.NetworkModule
import vitorota.mvvmposts.ui.post.PostListViewModel

/**
 *
 * @author Vitor Ota
 * @since 11/01/2019
 */
abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init{
        inject()
    }

    private fun inject(){
        when(this){
            is PostListViewModel -> injector.inject(this)
        }
    }


}