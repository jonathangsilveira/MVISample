package br.edu.jgsilveira.portfolio.mvisample.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.jgsilveira.portfolio.mvisample.R

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.discover_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieFragment.newInstance())
                .commitNow()
        }
    }

}
