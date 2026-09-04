package com.example.siraepae.manupuladora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siraepae.databinding.ActivityDialogInfoBinding

class dialog_info : AppCompatActivity() {

    private lateinit var binding: ActivityDialogInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDialogInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val titulo = intent.getStringExtra("TITULO")
        val mensaje = intent.getStringExtra("MENSAJE")

        if (!titulo.isNullOrEmpty()) {
            binding.tvDialogTitle.text = titulo
        }

        if (!mensaje.isNullOrEmpty()) {
            binding.tvDialogMessage.text = mensaje
        }

        binding.btnDialogClose.setOnClickListener {
            finish()
        }
    }
}