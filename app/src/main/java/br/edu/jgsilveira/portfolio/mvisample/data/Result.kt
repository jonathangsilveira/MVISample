package br.edu.jgsilveira.portfolio.mvisample.data

sealed class Result {

    object Loading : Result()

    data class Success<T>(val value: T) : Result()

    sealed class Failure: Result() {

        data class Response(val code: Int, val message: String): Failure()

        data class Undefined(val cause: Throwable): Failure()

    }

}

fun loading() = Result.Loading

fun <T> success(value: T) = Result.Success(value)

fun response(code: Int, message: String) = Result.Failure.Response(code, message)

fun undefined(cause: Throwable) = Result.Failure.Undefined(cause)