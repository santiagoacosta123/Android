package com.example.siraepae.manupuladora

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.manupuladora.BottomNavigation
import com.example.siraepae.databinding.ActivityInventarioManiBinding

class activity_inventario : AppCompatActivity() {

    // ==================================================
    // VIEW BINDING
    // ==================================================

    private lateinit var binding: ActivityInventarioManiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ==================================================
        // EDGE TO EDGE
        // ==================================================

        enableEdgeToEdge()

        // ==================================================
        // VIEW BINDING
        // ==================================================

        binding = ActivityInventarioManiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ==================================================
        // INSETS
        // ==================================================

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

        // ==================================================
        // CONFIGURAR PANTALLA
        // ==================================================

        configurarBotonAtras()
        configurarBusqueda()
        configurarNavegacion()
    }

    // ==================================================
    // BOTÓN ATRÁS
    // ==================================================

    private fun configurarBotonAtras() {

        binding.btnAtras.setOnClickListener {
            finish()
        }
    }

    // ==================================================
    // BUSCAR
    // ==================================================

    private fun configurarBusqueda() {

        binding.btnBuscar.setOnClickListener {

            Toast.makeText(
                this,
                "Buscar ingrediente",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    // ==================================================
    // NAVEGACIÓN INFERIOR
    // ==================================================

    private fun configurarNavegacion() {

        val bottomNavigation = BottomNavigation(
            this,
            binding.bottomNavigation
        )

        bottomNavigation.configurar("inventario")
    }
}