package br.edu.jgsilveira.portfolio.mvisample.repository

import androidx.lifecycle.liveData
import br.edu.jgsilveira.portfolio.mvisample.api.MovieEndPoint
import br.edu.jgsilveira.portfolio.mvisample.data.loading
import kotlinx.coroutines.Dispatchers

class MovieRepoImpl(private val endPoint: MovieEndPoint) : MovieRepo {

    override fun upcoming() = liveData(Dispatchers.IO) {
        emit(loading())
        emit(endPoint.upcoming())
    }

    override fun discover(queries: Map<String, String>) = liveData(Dispatchers.IO) {
        emit(loading())
        emit(endPoint.discover(queries))
    }

}