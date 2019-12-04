package cl.cristianvidal.dogsmobdevapp.breedList.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Cristian Vidal on 2019-12-03.
 */
@Dao
interface BreedDao {

    @Query("SELECT * FROM breed_table ORDER BY id DESC")
    fun getBreedList(): LiveData<List<Breed>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(breed: List<Breed>)

}