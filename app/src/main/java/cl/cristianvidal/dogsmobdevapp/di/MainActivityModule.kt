package cl.cristianvidal.dogsmobdevapp.di

import cl.cristianvidal.dogsmobdevapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Cristian Vidal on 2019-12-03.
 */

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity
}