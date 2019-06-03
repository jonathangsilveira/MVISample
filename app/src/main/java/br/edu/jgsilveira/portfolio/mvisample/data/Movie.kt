package br.edu.jgsilveira.portfolio.mvisample.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class Movie(
    val id: Int,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: Date,
    val runtime: Int,
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)