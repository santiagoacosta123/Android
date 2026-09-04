package com.example.siraepae.manupuladora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siraepae.databinding.ActivityInfoMenuManiBinding

class info_menu_mani : AppCompatActivity() {

    private lateinit var binding: ActivityInfoMenuManiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityInfoMenuManiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnAtras.setOnClickListener {
            finish()
        }

        val bottomNavigation = BottomNavigation(
            this,
            binding.bottomNavigation
        )
        bottomNavigation.configurar("inicio")
    }
}