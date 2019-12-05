package cl.cristianvidal.dogsmobdevapp.breedImagesList.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.distinctUntilChanged
import cl.cristianvidal.dogsmobdevapp.data.Result
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
) {

    private val breedImages: LiveData<List<BreedImages>> = MutableLiveData()

    suspend fun getImages(id: String): Result<BreedImages> {

        // This is define on BaseRepository
        val breedResponce = remoteDataSource.fetchData(id)

        return breedResponce

    }


    fun observeSet(id: String) = resultLiveData(
        databaseQuery = { dao.getAllBreedPhoto() },
        networkCall = { remoteDataSource.fetchData(id) },
        saveCallResult = { dao.insertAllBreeImages(it) })
        .distinctUntilChanged()



}