package vitorota.mvvm.di

import dagger.Subcomponent
import vitorota.mvvm.viewmodel.ProjectListViewModel
import vitorota.mvvm.viewmodel.ProjectViewModel

@Subcomponent
interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubComponent
    }

    fun projectListViewModel(): ProjectListViewModel
    fun projectViewModel(): ProjectViewModel
}