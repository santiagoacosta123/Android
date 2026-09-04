package com.example.siraepae.manupuladora

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siraepae.databinding.ActivityInventarioManiBinding

class activity_inventario : AppCompatActivity() {


    private lateinit var binding: ActivityInventarioManiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()

        binding = ActivityInventarioManiBinding.inflate(layoutInflater)
        setContentView(binding.root)


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

        configurarBotonAtras()
        configurarBusqueda()
        configurarNavegacion()
    }

    private fun configurarBotonAtras() {

        binding.btnAtras.setOnClickListener {
            finish()
        }
    }


    private fun configurarBusqueda() {

        binding.btnBuscar.setOnClickListener {

            Toast.makeText(
                this,
                "Buscar ingrediente",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun configurarNavegacion() {

        val bottomNavigation = BottomNavigation(
            this,
            binding.bottomNavigation
        )

        bottomNavigation.configurar("inventario")
    }
}