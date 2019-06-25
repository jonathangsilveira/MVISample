package br.edu.jgsilveira.portfolio.mvisample.data

sealed class Result<out T> {

    data class Success<out T>(val value: T?) : Result<T>()

    sealed class Failure: Result<Nothing>() {

        data class Response<T: ApiError>(val code: Int, val message: String, val body: T? = null): Failure()

        data class Undefined(val cause: Throwable): Failure()

    }

}

fun <T> success(value: T) = Result.Success(value)

fun <T: ApiError> response(code: Int, message: String, body: T? = null) = Result.Failure.Response(code, message, body)

fun undefined(cause: Throwable) = Result.Failure.Undefined(cause)