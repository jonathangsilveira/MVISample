package br.edu.jgsilveira.portfolio.mvisample.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.jgsilveira.portfolio.mvisample.R
import br.edu.jgsilveira.portfolio.mvisample.data.Upcoming
import kotlinx.android.synthetic.main.movie_item.view.*

class UpcomingAdapter(private val upcoming: Upcoming?): RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return UpcomingViewHolder(view)
    }

    override fun getItemCount(): Int = upcoming?.results?.size ?: 0

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        val item = upcoming!!.results[position]
        holder.itemView.title.text = item.title
        holder.itemView.voteAverage.text = item.voteAverage.toString()
    }

    inner class UpcomingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}