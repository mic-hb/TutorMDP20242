package com.example.tutorm7front

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.tutorm7front.databinding.ActivityHeroDetailBinding
import com.example.tutorm7front.network.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import android.graphics.BitmapFactory

class HeroDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroDetailBinding
    private lateinit var hero: HeroEntity
    private lateinit var editHeroLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hero = intent.getSerializableExtra("hero") as HeroEntity

        setupView()
        setupEditLauncher()
        setupButtons()
    }

    private fun setupView() {
        binding.textViewName.text = hero.name
        binding.textViewDescription.text = hero.description
        binding.textViewDifficulty.text = "Difficulty: ${"🌟".repeat(hero.difficulty.toInt())}"

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val url = URL(hero.image)
                val input = url.openStream()
                val bitmap = BitmapFactory.decodeStream(input)

                withContext(Dispatchers.Main) {
                    binding.imageViewHero.setImageBitmap(bitmap)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun setupEditLauncher() {
        editHeroLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                setResult(RESULT_OK) // Notify MainActivity to refresh
                finish()
            }
        }
    }

    private fun setupButtons() {
        binding.buttonEdit.setOnClickListener {
            val intent = Intent(this, EditHeroActivity::class.java)
            intent.putExtra("hero", hero)
            editHeroLauncher.launch(intent)
        }

        binding.buttonDelete.setOnClickListener {
            deleteHero()
        }

        binding.buttonBack.setOnClickListener {
            finish()
        }
    }

    private fun deleteHero() {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                RetrofitInstance.instance.deleteHero(hero.id)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@HeroDetailActivity, "Hero deleted", Toast.LENGTH_SHORT).show()
                    setResult(RESULT_OK) // Notify MainActivity to refresh
                    finish()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
