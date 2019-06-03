package br.edu.jgsilveira.portfolio.mvisample.api

object Routes {

    const val BASE_URL = "https://api.themoviedb.org/"

    const val GUEST_SESSION = "/3/authentication/guest_session/new"

    const val NEW_TOKEN = "/3/authentication/token/new"

    const val RATED_MOVIES = "/3/guest_session/{guest_session_id}/rated/discover"

    const val MOVIE_DISCOVER = "/3/discover/movie"

    const val RATE_MOVIE = "/3/movie/{movie_id}/rating"

    const val NEW_SESSION = "/3/authentication/session/new"

    const val MOVIE_GENRES = "/3/genre/movie/list"

    const val MOVIE_DETAIL = "/3/movie/{movie_id}"

    const val CONFIGURATION = "/3/configuration"

    const val UPCOMING = "/3/movie/upcoming"

}