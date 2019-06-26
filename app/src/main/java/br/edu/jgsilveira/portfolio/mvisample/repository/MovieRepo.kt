package br.edu.jgsilveira.portfolio.mvisample.repository

import androidx.lifecycle.LiveData
import br.edu.jgsilveira.portfolio.mvisample.data.ActionState

interface MovieRepo {

    fun discover(): LiveData<ActionState>

    fun upcoming(): LiveData<ActionState>

}