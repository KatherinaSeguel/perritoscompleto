package cl.cristianvidal.dogsmobdevapp.breedImagesList.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Cristian Vidal on 2019-12-04.
 */
@Dao
interface BreedImageDAO {

    @Query("SELECT * FROM breedImages ORDER BY id DESC")
    fun getAllBreedPhoto(): LiveData<List<BreedImages>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBreeImages(breedImages: List<BreedImages>)
}