package br.edu.jgsilveira.portfolio.mvisample.api

import br.edu.jgsilveira.portfolio.mvisample.data.Result
import br.edu.jgsilveira.portfolio.mvisample.data.success
import br.edu.jgsilveira.portfolio.mvisample.data.undefined
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class BaseEndPoint {

    protected val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Routes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
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

}