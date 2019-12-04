package cl.cristianvidal.dogsmobdevapp.api


import com.google.gson.annotations.SerializedName

data class ResultTest(
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String
)