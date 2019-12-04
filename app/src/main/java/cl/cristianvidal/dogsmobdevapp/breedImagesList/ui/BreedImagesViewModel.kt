package cl.cristianvidal.dogsmobdevapp.breedImagesList.ui

import androidx.lifecycle.ViewModel
import cl.cristianvidal.dogsmobdevapp.breedImagesList.data.BreedImageRepository
import javax.inject.Inject

class BreedImagesViewModel @Inject constructor(repository: BreedImageRepository) : ViewModel() {

    val breedImageList = repository.observeImages(breedString = String())


}