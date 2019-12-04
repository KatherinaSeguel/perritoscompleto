package cl.cristianvidal.dogsmobdevapp.breedList.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breed_table")
data class Breed(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val breed: String
)