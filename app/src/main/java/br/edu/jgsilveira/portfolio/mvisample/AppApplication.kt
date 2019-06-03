package br.edu.jgsilveira.portfolio.mvisample

import android.app.Application
import br.edu.jgsilveira.portfolio.mvisample.api.MovieEndPoint
import br.edu.jgsilveira.portfolio.mvisample.movie.MovieDispatcher
import br.edu.jgsilveira.portfolio.mvisample.movie.MovieViewModel
import br.edu.jgsilveira.portfolio.mvisample.repository.MovieRepo
import br.edu.jgsilveira.portfolio.mvisample.repository.MovieRepoImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        val module = module {
            factory {
                MovieEndPoint()
            }
            factory<MovieRepo>(override = true) {
                MovieRepoImpl(get())
            }
            factory(override = true) {
                MovieDispatcher(get())
            }
            viewModel(override = true) {
                MovieViewModel(androidApplication(), get())
            }
        }
        startKoin {
            androidContext(this@AppApplication)
            modules(module)
        }
    }

}