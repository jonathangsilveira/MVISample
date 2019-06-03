package br.edu.jgsilveira.portfolio.mvisample.api

import br.edu.jgsilveira.portfolio.mvisample.BuildConfig
import br.edu.jgsilveira.portfolio.mvisample.data.DiscoverMovies
import br.edu.jgsilveira.portfolio.mvisample.data.Upcoming
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface DiscoverService {

    @GET(value = Routes.MOVIE_DISCOVER)
    fun discover(@QueryMap queries: Map<String, String>): Call<DiscoverMovies>

    @GET(value = Routes.UPCOMING)
    fun upcoming(@Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY): Call<Upcoming>

}