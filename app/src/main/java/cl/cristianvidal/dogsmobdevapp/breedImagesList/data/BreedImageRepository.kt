package cl.cristianvidal.dogsmobdevapp.breedImagesList.data

import cl.cristianvidal.dogsmobdevapp.data.resultLiveData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Cristian Vidal on 2019-12-04.
 */
@Singleton
class BreedImageRepository @Inject constructor(
    private val dao: BreedImageDAO,
    private val remoteDataSource: BreedImagesRemoteDataSource
){

    fun observeImages(breedString: String) = resultLiveData(
        databaseQuery = { dao.getAllBreedPhoto() },
        networkCall = { remoteDataSource.fetchData(breedString) },
        saveCallResult = { dao.insertAllBreeImages(it.message) })
}