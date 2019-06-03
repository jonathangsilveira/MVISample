package br.edu.jgsilveira.portfolio.mvisample.data


import com.google.gson.annotations.SerializedName

data class Upcoming(
    val page: Int,
    val results: List<Result>,
    val dates: Dates,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
) {
    data class Result(
        val id: Int,
        val popularity: Double,
        @SerializedName("vote_count")
        val voteCount: Int,
        @SerializedName("vote_average")
        val voteAverage: Double
    )

    data class Dates(
        val maximum: String,
        val minimum: String
    )
}