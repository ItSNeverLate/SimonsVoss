package mehdiparsaei.simonsvoss.assignment.presentation.ui

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import mehdiparsaei.simonsvoss.assignment.R
import mehdiparsaei.simonsvoss.assignment.databinding.ActivityMainBinding
import mehdiparsaei.simonsvoss.assignment.domain.util.Resource
import mehdiparsaei.simonsvoss.assignment.presentation.util.setOnQueryTextChanged

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        init()
        subscribe()
    }

    private fun init() {
        mainAdapter = MainAdapter()
        binding.apply {
            recyclerView.apply {
                adapter = mainAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
                setHasFixedSize(true)
            }
        }
    }

    private fun subscribe() {
        binding.apply {
            lifecycleScope.launchWhenResumed {
                viewModel.locksFlow.collectLatest {
                    progressBar.isVisible = it is Resource.Loading

                    when(it) {
                        is Resource.Error -> it.error?.let { error ->
                            Toast.makeText(this@MainActivity, error.toString(), Toast.LENGTH_SHORT)
                                .show()
                        }
                        is Resource.Success -> it.data?.let { data ->
                            mainAdapter.submitList(data)
                            mainAdapter.searchQuery = viewModel.searchQuery.value
                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu);

        val searchItem = menu.findItem(R.id.action_search_query)
        searchView = searchItem.actionView as SearchView

        val pendingQuery = viewModel.searchQuery.value
        if (pendingQuery != null && pendingQuery.isNotEmpty()) {
            searchItem.expandActionView()
            searchView.setQuery(pendingQuery, false)
        }

        searchView.setOnQueryTextChanged {
            viewModel.searchQuery.value = it
        }

        return true;
    }
}