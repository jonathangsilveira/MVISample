package br.edu.jgsilveira.portfolio.mvisample.api

import br.edu.jgsilveira.portfolio.mvisample.data.Discover
import br.edu.jgsilveira.portfolio.mvisample.data.Upcoming
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MovieService {

    @GET(value = Routes.MOVIE_DISCOVER)
    fun discover(@QueryMap queries: Map<String, String>): Call<Discover>

    @GET(value = Routes.UPCOMING)
    fun upcoming(): Call<Upcoming>

}