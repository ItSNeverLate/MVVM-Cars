package com.sevenpeakssoftware.mehdi.data.remote.datasource

import android.util.Log
import retrofit2.Response
import com.sevenpeakssoftware.mehdi.domain.util.Result

private const val TAG = "BaseDataSource"

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            Log.d(TAG, "getResult: $response")
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null)
                    return Result.Success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }


    private fun <T> error(message: String): Result<T> {
        return Result.Error("Network call has failed for a following reason: $message")
    }

}