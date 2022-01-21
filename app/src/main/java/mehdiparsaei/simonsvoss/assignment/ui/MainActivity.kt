package mehdiparsaei.simonsvoss.assignment.ui

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
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
    }

    private fun subscribe() {
        binding.apply {
            lifecycleScope.launchWhenResumed {
                viewModel.locksFlow.collectLatest {
                    when (it) {
                        is Resource.Loading -> {
                            progressBar.isVisible = true
                        }
                        is Resource.Error -> {
                            Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                        }
                        is Resource.Success -> {
                            mainAdapter.submitList(it.data)
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