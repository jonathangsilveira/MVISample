package br.edu.jgsilveira.portfolio.mvisample.api

class MovieEndPoint : BaseEndPoint() {

    private val service: DiscoverService by service()

    fun discover() = safeApiCall {
        service.discover()
    }

    fun upcoming() = safeApiCall {
        service.upcoming()
    }

}