package br.edu.jgsilveira.portfolio.mvisample.movie

import br.edu.jgsilveira.portfolio.mvisample.data.Discover
import br.edu.jgsilveira.portfolio.mvisample.data.Upcoming

data class State(
    val isLoading: Boolean = false,
    val discover: Discover? = null,
    val upcoming: Upcoming? = null,
    val error: String? = null
)