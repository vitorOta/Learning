package vitorota.mvvm.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vitorota.mvvm.view.ui.ProjectFragment
import vitorota.mvvm.view.ui.ProjectListFragment

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeProjectFragment():ProjectFragment

    @ContributesAndroidInjector
    abstract fun contributeProjectListFragment(): ProjectListFragment
}