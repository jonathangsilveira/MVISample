package br.edu.jgsilveira.portfolio.mvisample.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.jgsilveira.portfolio.mvisample.R
import br.edu.jgsilveira.portfolio.mvisample.data.DiscoverMovies
import kotlinx.android.synthetic.main.movie_item.view.*

class DiscoverAdapter(private val discover: DiscoverMovies?): RecyclerView.Adapter<DiscoverAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int = discover?.results?.size ?: 0

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = discover!!.results[position]
        with(holder.itemView) {
            title.text = movie.title
            voteAverage.text = movie.voteAverage.toString()
        }
    }

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}