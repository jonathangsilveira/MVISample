package br.edu.jgsilveira.portfolio.mvisample.data

import com.google.gson.annotations.SerializedName

data class Discover(
        val page: Int,
        val results: List<Result>,
        @SerializedName("total_results")
        val totalResults: Int,
        @SerializedName("total_pages")
        val totalPages: Int
) {
    data class Result(
            val id: Int,
            @SerializedName("release_date")
            val releaseDate: String,
            val title: String,
            val popularity: Double,
            @SerializedName("vote_average")
            val voteAverage: Double
    )
}