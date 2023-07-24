package com.github.jesushzc.tvapp.utils

/**
 * Created by Jesus Hernandez on 24/07/2023.
 * @param T
 * Class to handle the response of the API
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}