package com.example.siraepae.manupuladora

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siraepae.R
import com.example.siraepae.databinding.ActivityPrepAsigManiBinding

class preparaciones_asignadas : AppCompatActivity() {

    private lateinit var binding: ActivityPrepAsigManiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // EDGE TO EDGE

        enableEdgeToEdge()

        // VIEW BINDING

        binding = ActivityPrepAsigManiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // CATEGORÍA SELECCIONADA

        val categoria = intent.getStringExtra(
            "CATEGORIA_SELECCIONADA"
        ) ?: "Desayuno"

        binding.txtCategoria.text = categoria

        binding.txtTituloPreparaciones.text =
            "Preparaciones de $categoria"

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
        // BOTTOM NAVIGATION

        val bottomNavigation = BottomNavigation(
            this,
            binding.bottomNavigation
        )

        bottomNavigation.configurar("asignadas")

        // BOTONES DE PREPARACIONES

        // CHOCOLATE EN LECHE

        binding.cardChocolateLeche.setOnClickListener {

            val intent = Intent(
                this,
                activity_preparacion_chocolate::class.java
            )

            startActivity(intent)
        }
        // HUEVO REVUELTO

        binding.cardHuevoRevuelto.setOnClickListener {

            val intent = Intent(
                this,
                preparacion_huevo_revuelto::class.java
            )

            startActivity(intent)
        }

        // AREPA DE MAÍZ

        binding.cardArepaMaiz.setOnClickListener {

            val intent = Intent(
                this,
                preparacion_arepa_maiz::class.java
            )

            startActivity(intent)
        }
        // BANANO
        // ==================================================
        // Sin acción por ahora porque todavía no tenemos
        // una pantalla de preparación para el banano.

    }
}