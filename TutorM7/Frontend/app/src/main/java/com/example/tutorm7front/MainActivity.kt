package com.example.tutorm7front

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tutorm7front.databinding.ActivityMainBinding
import com.example.tutorm7front.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var heroDetailLauncher: ActivityResultLauncher<Intent>
    private var heroesList = mutableListOf<HeroEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupHeroDetailLauncher()
        fetchHeroes()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setupHeroDetailLauncher() {
        heroDetailLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                fetchHeroes() // Refresh the hero list after deletion
            }
        }
    }

    private fun fetchHeroes() {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.instance.getHeroes()
                withContext(Dispatchers.Main) {
                    heroesList = response.heroes.toMutableList()
                    binding.recyclerView.adapter = HeroAdapter(heroesList) { hero ->
                        val intent = Intent(this@MainActivity, HeroDetailActivity::class.java)
                        intent.putExtra("hero", hero)
                        heroDetailLauncher.launch(intent)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Failed: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
