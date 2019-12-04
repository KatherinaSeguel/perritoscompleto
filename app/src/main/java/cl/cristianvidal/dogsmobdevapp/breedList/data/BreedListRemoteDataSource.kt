package cl.cristianvidal.dogsmobdevapp.breedList.data

import cl.cristianvidal.dogsmobdevapp.api.BaseData
import javax.inject.Inject

/**
 * Created by Cristian Vidal on 2019-12-03.
 */
class BreedListRemoteDataSource @Inject constructor(private val service: cl.cristianvidal.dogsmobdevapp.api.ApiDogService) :
    BaseData() {

    suspend fun fetchData() = getResult { service.getBreedList() }
}