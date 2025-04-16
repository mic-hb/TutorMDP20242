package com.example.tutorm4

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.tutorm4.databinding.ActivityLoginRegisterBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginRegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up bottom navigation dengan nav controller dan navHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container_view_logreg) as NavHostFragment
        val navController = navHostFragment.navController

        // digunakan untuk menentukan user akan diarahkan ke halaman mana ketika suatu tombol ditekan
        binding.bottomNav.setOnItemSelectedListener {
            if(it.itemId == R.id.login_mi){
                navController.navigate(R.id.action_global_loginFragment)
            } else {
                navController.navigate(R.id.action_global_registerFragment)
            }
            true
        }

        // nah ada beberapa file yang kita tidak ingin munculkan bottom navigationnya
        // maka kita bisa menggunakan addOnDestinationChangedListener
        // dan kita bisa menentukan kapan bottom navigationnya akan muncul dan kapan tidak
        navController.addOnDestinationChangedListener{
                controller, destination, arguments ->

            if(destination.id == R.id.userFragment){
                binding.bottomNav.visibility = View.GONE
            }
            else{
                binding.bottomNav.visibility = View.VISIBLE
            }
        }
    }

}