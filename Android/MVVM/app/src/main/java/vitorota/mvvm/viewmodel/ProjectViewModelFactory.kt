package vitorota.mvvm.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.ArrayMap
import vitorota.mvvm.di.ViewModelSubComponent
import java.util.concurrent.Callable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProjectViewModelFactory @Inject constructor(var viewModelSubComponent: ViewModelSubComponent) :
    ViewModelProvider.Factory {

    private val creators: ArrayMap<Class<*>, Callable<out ViewModel>> = ArrayMap()

    init {
        creators[ProjectViewModel::class.java] = Callable { viewModelSubComponent.projectViewModel() }
        creators[ProjectListViewModel::class.java] = Callable { viewModelSubComponent.projectListViewModel() }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator = creators[modelClass]
        if (creator == null) {
            for ((k, v) in creators) {
                if (modelClass.isAssignableFrom(k)) {
                    creator = v
                    break
                }
            }
        }

        if (creator == null) {
            throw IllegalArgumentException("Unknown model class $modelClass")
        }

        try {
            return creator.call() as T
        } catch (e: Exception) {
            throw  RuntimeException()
        }
    }

}