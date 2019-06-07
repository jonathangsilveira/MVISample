package br.edu.jgsilveira.portfolio.mvisample.repository

import androidx.lifecycle.LiveData
import br.edu.jgsilveira.portfolio.mvisample.data.Result

interface MovieRepo {

    fun discover(): LiveData<Result>

    fun upcoming(): LiveData<Result>

}