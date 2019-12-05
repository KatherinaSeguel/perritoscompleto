package cl.cristianvidal.dogsmobdevapp.breedImagesList.ui

import androidx.lifecycle.ViewModel
import cl.cristianvidal.dogsmobdevapp.breedImagesList.data.BreedImageRepository
import javax.inject.Inject

class BreedImagesViewModel @Inject constructor(repository: BreedImageRepository) : ViewModel() {

    lateinit var id: String
    val breedImages by lazy { repository.observeSet(id) }

}