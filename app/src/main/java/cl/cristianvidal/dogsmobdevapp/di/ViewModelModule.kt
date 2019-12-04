package cl.cristianvidal.dogsmobdevapp.di

import androidx.lifecycle.ViewModel
import cl.cristianvidal.dogsmobdevapp.breedImagesList.ui.BreedImagesViewModel
import cl.cristianvidal.dogsmobdevapp.breedList.ui.BreedListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Cristian Vidal on 2019-12-03.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BreedListViewModel::class)
    abstract fun bindBreedListViewModel(viewModel: BreedListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BreedImagesViewModel::class)
    abstract fun bindBreedImagesViewModel(viewModel: BreedImagesViewModel): ViewModel



}