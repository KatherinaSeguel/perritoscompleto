package cl.cristianvidal.dogsmobdevapp.breedList.ui

import androidx.lifecycle.ViewModel
import cl.cristianvidal.dogsmobdevapp.breedList.data.BreedListRepository
import javax.inject.Inject

/**
 * The ViewModel for breedListFragment
 */
class BreedListViewModel @Inject constructor(repository: BreedListRepository) : ViewModel() {

    val breedList = repository.breedList




}