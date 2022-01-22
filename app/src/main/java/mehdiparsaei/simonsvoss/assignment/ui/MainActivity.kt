package mehdiparsaei.simonsvoss.assignment.ui

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import mehdiparsaei.simonsvoss.assignment.R
import mehdiparsaei.simonsvoss.assignment.databinding.ActivityMainBinding
import mehdiparsaei.simonsvoss.assignment.domain.util.Resource

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter

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
                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}