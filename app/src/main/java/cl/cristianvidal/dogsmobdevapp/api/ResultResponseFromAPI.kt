package cl.cristianvidal.dogsmobdevapp.api

/**
 * Created by Cristian Vidal on 2019-12-03.
 */
data class ResultResponseFromAPI<T>(
    val message: List<T>,
    val status: String
)