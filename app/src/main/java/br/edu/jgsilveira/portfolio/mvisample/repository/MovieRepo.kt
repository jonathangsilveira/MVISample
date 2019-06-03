package br.edu.jgsilveira.portfolio.mvisample.repository

import androidx.lifecycle.LiveData
import br.edu.jgsilveira.portfolio.mvisample.data.Result

interface MovieRepo {

    fun discover(queries: Map<String, String> = mapOf()): LiveData<Result>

    fun upcoming(): LiveData<Result>

}