package com.example.siraepae.manupuladora

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siraepae.R
import com.example.siraepae.databinding.ActivityPrepArepaMaizManiBinding

class preparacion_arepa_maiz : AppCompatActivity() {

    private lateinit var binding: ActivityPrepArepaMaizManiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPrepArepaMaizManiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // INSETS

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { vista, insets ->

            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            vista.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // BOTÓN VOLVER

        binding.btnVolver.setOnClickListener {
            finish()
        }

        // BOTÓN ESTADO

        binding.btnEstado.setOnClickListener {

            val intent = Intent(
                this,
                popup_estado::class.java
            )

            startActivity(intent)
        }
    }
}