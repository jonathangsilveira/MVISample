package br.edu.jgsilveira.portfolio.mvisample.repository

import androidx.lifecycle.liveData
import br.edu.jgsilveira.portfolio.mvisample.api.MovieEndPoint
import br.edu.jgsilveira.portfolio.mvisample.data.ActionState
import br.edu.jgsilveira.portfolio.mvisample.data.Result
import kotlinx.coroutines.Dispatchers

class MovieRepoImpl(private val endPoint: MovieEndPoint) : MovieRepo {

    override fun upcoming() = liveData(Dispatchers.IO) {
        emit(ActionState.Loading)
        when (val result = endPoint.upcoming()) {
            is Result.Success -> emit(ActionState.UpcomingLoaded(result.value))
            is Result.Failure -> emit(ActionState.Error(result))
        }
    }

    override fun discover(queries: Map<String, String>) = liveData(Dispatchers.IO) {
        emit(ActionState.Loading)
        when (val result = endPoint.discover(queries)) {
            is Result.Success -> emit(ActionState.DiscoverLoaded(result.value))
            is Result.Failure -> emit(ActionState.Error(result))
        }
    }

}