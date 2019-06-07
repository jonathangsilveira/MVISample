package br.edu.jgsilveira.portfolio.mvisample.movie

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import br.edu.jgsilveira.portfolio.mvisample.data.Discover
import br.edu.jgsilveira.portfolio.mvisample.data.Result
import br.edu.jgsilveira.portfolio.mvisample.data.Upcoming

class MovieViewModel(
    application: Application,
    dispatcher: MovieDispatcher
) : AndroidViewModel(application) {

    private val state = State()

    private val action: MutableLiveData<Action> by lazy {
        MutableLiveData<Action>().apply {
            value = Action.DISCOVER
        }
    }

    val viewState: LiveData<State> = Transformations.switchMap(action) { action ->
        Transformations.map(dispatcher.dispatch(action)) {
            when (it) {
                is Result.Loading -> state.copy(isLoading = true)
                is Result.Success<*> -> {
                    when (it.value) {
                        is Discover -> state.copy(isLoading = false, discover = it.value)
                        is Upcoming -> state.copy(isLoading = false, upcoming = it.value)
                        else -> state.copy(isLoading = false)
                    }
                }
                is Result.Failure.Response -> state.copy(isLoading = false, error = it.message)
                is Result.Failure.Undefined -> state.copy(isLoading = false, error = it.cause.message)
            }
        }
    }

    fun upcoming() {
        action.value = Action.UPCOMING
    }

    fun discover() {
        action.value = Action.DISCOVER
    }

}
