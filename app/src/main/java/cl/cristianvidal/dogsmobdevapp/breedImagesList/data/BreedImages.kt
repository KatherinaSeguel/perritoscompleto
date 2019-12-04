package cl.cristianvidal.dogsmobdevapp.breedImagesList.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breedImages")
data class BreedImages(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val breedImageURL: String
)