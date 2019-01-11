package vitorota.mvvm.di

import android.support.v4.app.Fragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import vitorota.mvvm.view.ui.MainActivity

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity():MainActivity
}