package cl.cristianvidal.dogsmobdevapp.breedImagesList.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "breedImages")
data class BreedImages(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String
)