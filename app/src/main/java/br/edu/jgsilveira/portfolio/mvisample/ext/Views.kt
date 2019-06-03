package br.edu.jgsilveira.portfolio.mvisample.ext

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setup() {
    addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
    layoutManager = LinearLayoutManager(this.context)
}