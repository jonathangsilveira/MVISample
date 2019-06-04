package br.edu.jgsilveira.portfolio.mvisample.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import br.edu.jgsilveira.portfolio.mvisample.R
import br.edu.jgsilveira.portfolio.mvisample.ext.setup
import kotlinx.android.synthetic.main.discover_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private val viewModel: MovieViewModel by viewModel()

    companion object {
        fun newInstance() = MovieFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.discover_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        discover.setup()
        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                viewModel.upcoming()
            else
                viewModel.discover()
        }
        viewModel.viewState.observe(viewLifecycleOwner) { state ->
            render(state)
        }
    }

    private fun render(state: State) {
        loading.visibility= if (state.isLoading) View.VISIBLE else View.GONE
        if (state.discover != null)
            discover.adapter = DiscoverAdapter(state.discover)
        else
            discover.adapter = UpcomingAdapter(state.upcoming)
        displayError(state)
    }

    private fun displayError(state: State) {
        if (state.error != null)
            AlertDialog.Builder(requireActivity())
                .setTitle(R.string.error)
                .setMessage(state.error)
                .setPositiveButton(getString(R.string.ok)) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
    }

}
