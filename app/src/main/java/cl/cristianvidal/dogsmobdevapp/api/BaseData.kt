package cl.cristianvidal.dogsmobdevapp.api

import cl.cristianvidal.dogsmobdevapp.data.Result
import retrofit2.Response
import timber.log.Timber

/**
 * Created by Cristian Vidal on 2019-12-03.
 */
abstract class BaseData {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): cl.cristianvidal.dogsmobdevapp.data.Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): cl.cristianvidal.dogsmobdevapp.data.Result<T> {
        Timber.e(message)
        return cl.cristianvidal.dogsmobdevapp.data.Result.error("Network call has failed for a following reason: $message")
    }

}
