package br.edu.jgsilveira.portfolio.mvisample.api

class MovieEndPoint : BaseEndPoint() {

    private val service: MovieService by service()

    fun discover() = safeApiCall {
        service.discover()
    }

    fun upcoming() = safeApiCall {
        service.upcoming()
    }

}