package br.edu.jgsilveira.portfolio.mvisample.api

import br.edu.jgsilveira.portfolio.mvisample.BuildConfig
import br.edu.jgsilveira.portfolio.mvisample.data.Discover
import br.edu.jgsilveira.portfolio.mvisample.data.Upcoming
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverService {

    @GET(value = Routes.MOVIE_DISCOVER)
    fun discover(@Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY): Call<Discover>

    @GET(value = Routes.UPCOMING)
    fun upcoming(@Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY): Call<Upcoming>

}