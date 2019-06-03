package br.edu.jgsilveira.portfolio.mvisample.api

class MovieEndPoint : BaseEndPoint() {

    private val service: DiscoverService by service()

    fun discover(queries: Map<String, String> = mapOf()) = safeApiCall {
        service.discover(queries)
    }

    fun upcoming() = safeApiCall {
        service.upcoming()
    }

}