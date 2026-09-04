package com.example.siraepae.manupuladora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siraepae.databinding.ActivityAvisosManiBinding

class avisos_mani : AppCompatActivity() {

    private lateinit var binding: ActivityAvisosManiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAvisosManiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnAtras.setOnClickListener {
            finish()
        }

        binding.btnCampana.setOnClickListener {
            val notificaciones = dialog_notificaciones()
            notificaciones.show(supportFragmentManager, "dialog_notificaciones")
        }
    }
}