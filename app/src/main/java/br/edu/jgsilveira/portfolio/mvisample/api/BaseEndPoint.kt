package br.edu.jgsilveira.portfolio.mvisample.api

import br.edu.jgsilveira.portfolio.mvisample.data.Result
import br.edu.jgsilveira.portfolio.mvisample.data.success
import br.edu.jgsilveira.portfolio.mvisample.data.undefined
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

open class BaseEndPoint {

    protected val retrofit: Retrofit by lazy {
        val contentType = MediaType.get("application/json")
        Retrofit.Builder()
            .baseUrl(Routes.BASE_URL)
            .addConverterFactory(Json.asConverterFactory(contentType = contentType))
            .client(buildClient())
            .build()
    }

    protected inline fun <reified T> service(): Lazy<T> = lazy {
        retrofit.create(T::class.java)
    }

    protected fun <T> safeApiCall(call: () -> Call<T>) = try {
        val response = call().execute()
        if (response.isSuccessful)
            success(response.body())
        else
            Result.Failure.Response(response.code(), response.message())
    } catch (e: Exception) {
        undefined(e)
    }

    private fun buildClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

}