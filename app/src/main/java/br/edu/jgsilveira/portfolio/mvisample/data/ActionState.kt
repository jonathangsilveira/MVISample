package br.edu.jgsilveira.portfolio.mvisample.data

sealed class ActionState {

    object Loading: ActionState()

    data class DiscoverLoaded(val value: Discover?): ActionState()

    data class UpcomingLoaded(val value: Upcoming?): ActionState()

    data class Error(val failure: Result.Failure): ActionState()

}