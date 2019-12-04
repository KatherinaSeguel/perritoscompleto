package cl.cristianvidal.dogsmobdevapp.breedList.data

import cl.cristianvidal.dogsmobdevapp.data.resultLiveData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Cristian Vidal on 2019-12-03.
 */
@Singleton
class BreedListRepository @Inject constructor(
    private val dao: BreedDao,
    private val remoteDataSource: BreedListRemoteDataSource
) {

    val breedList = resultLiveData(
        databaseQuery = { dao.getBreedList() },
        networkCall = { remoteDataSource.fetchData() },
        saveCallResult = { dao.insertAll(it) }
    )
}