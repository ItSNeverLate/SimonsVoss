package mehdiparsaei.simonsvoss.assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import dagger.hilt.EntryPoint
import mehdiparsaei.simonsvoss.assignment.R

@EntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}