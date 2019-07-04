package br.edu.jgsilveira.portfolio.mvisample.api

import br.edu.jgsilveira.portfolio.mvisample.BuildConfig
import br.edu.jgsilveira.portfolio.mvisample.data.*
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class BaseEndPoint {

    protected val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Routes.BASE_URL)
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    protected inline fun <reified T> service(): Lazy<T> = lazy {
        retrofit.create(T::class.java)
    }

    protected fun <T> safeApiCall(call: () -> Call<T>) = try {
        val result = call().execute()
        when {
            result.isSuccessful -> success(result.body())
            result.code() == 401 -> unauthorized(result)
            result.code() == 404 -> notFound(result)
            else -> response(code = result.code(), message = result.message(), body = null)
        }
    } catch (e: Exception) {
        undefined(e)
    }

    private fun <T> unauthorized(result: Response<T>): Result.Failure.Response<Unauthorized> {
        val json = result.errorBody()?.string()
        val unauthorized = Gson().fromJson(json, Unauthorized::class.java)
        return response(result.code(), result.message(), unauthorized)
    }

    private fun <T> notFound(result: Response<T>): Result.Failure.Response<NotFound> {
        val json = result.errorBody()?.string()
        val notFound = Gson().fromJson(json, NotFound::class.java)
        return response(result.code(), result.message(), notFound)
    }

    private fun createClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                intercept(chain)
            }.build()
    }

    private fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val request = chain.request()
        val url = request.url()
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()
        val newRequest = request.newBuilder()
            .url(url)
            .addHeader("Accept", "application/json")
            .addHeader("Charset", Charsets.UTF_8.displayName())
            .build()
        return chain.proceed(newRequest)
    }

}