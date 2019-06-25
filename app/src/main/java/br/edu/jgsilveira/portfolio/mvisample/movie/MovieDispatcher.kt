package br.edu.jgsilveira.portfolio.mvisample.movie

import br.edu.jgsilveira.portfolio.mvisample.repository.MovieRepo

class MovieDispatcher(private val repo: MovieRepo) {

    fun dispatch(action: Action) = when (action) {
        Action.DISCOVER -> repo.discover()
        Action.UPCOMING -> repo.upcoming()
    }

}