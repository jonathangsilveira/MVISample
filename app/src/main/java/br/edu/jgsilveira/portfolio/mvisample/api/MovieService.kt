package br.edu.jgsilveira.portfolio.mvisample.api

import br.edu.jgsilveira.portfolio.mvisample.data.Discover
import br.edu.jgsilveira.portfolio.mvisample.data.Upcoming
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {

    @GET(value = Routes.MOVIE_DISCOVER)
    fun discover(): Call<Discover>

    @GET(value = Routes.UPCOMING)
    fun upcoming(): Call<Upcoming>

}