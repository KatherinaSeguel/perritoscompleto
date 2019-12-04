package cl.cristianvidal.dogsmobdevapp.breedList.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "breed_table")
data class Breed(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String
)