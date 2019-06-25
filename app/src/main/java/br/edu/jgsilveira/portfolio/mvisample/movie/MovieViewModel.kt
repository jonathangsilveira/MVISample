package br.edu.jgsilveira.portfolio.mvisample.movie

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import br.edu.jgsilveira.portfolio.mvisample.data.ActionState
import br.edu.jgsilveira.portfolio.mvisample.data.Result

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
                is ActionState.Loading -> state.copy(isLoading = true)
                is ActionState.DiscoverLoaded -> state.copy(isLoading = false, discover = it.value)
                is ActionState.UpcomingLoaded -> state.copy(isLoading = false, upcoming = it.value)
                is ActionState.Error -> handleError(it)
            }
        }
    }

    private fun handleError(state: ActionState.Error): State {
        return when (state.failure) {
            is Result.Failure.Response<*> -> {
                this.state.copy(isLoading = false, error = state.failure.body?.statusMessage)
            }
            is Result.Failure.Undefined -> this.state.copy(isLoading = false, error = state.failure.cause.message)
        }
    }

    fun upcoming() {
        action.value = Action.UPCOMING
    }

    fun discover() {
        action.value = Action.DISCOVER
    }

}
