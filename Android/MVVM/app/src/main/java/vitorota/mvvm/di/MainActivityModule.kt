package vitorota.mvvm.di

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import vitorota.mvvm.view.ui.MainActivity

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity():MainActivity
}