package cl.cristianvidal.dogsmobdevapp.di

import cl.cristianvidal.dogsmobdevapp.breedImagesList.ui.BreedImagesFragment
import cl.cristianvidal.dogsmobdevapp.breedList.ui.BreedListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Cristian Vidal on 2019-12-03.
 */
@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeBreedListFragment(): BreedListFragment

    @ContributesAndroidInjector
    abstract fun contributeBreedImagesFragment(): BreedImagesFragment


}