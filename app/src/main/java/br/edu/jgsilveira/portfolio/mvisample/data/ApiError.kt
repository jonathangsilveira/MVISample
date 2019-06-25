package br.edu.jgsilveira.portfolio.mvisample.data


import com.google.gson.annotations.SerializedName

open class ApiError(
    @SerializedName("status_message")
    open val statusMessage: String,
    @SerializedName("status_code")
    open val statusCode: Int
)

class Unauthorized(
    statusMessage: String,
    statusCode: Int
) : ApiError(statusMessage, statusCode)

class NotFound(
    statusMessage: String,
    statusCode: Int
) : ApiError(statusMessage, statusCode)