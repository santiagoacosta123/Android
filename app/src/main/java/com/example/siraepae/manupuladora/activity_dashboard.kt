package com.example.siraepae.manupuladora

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.manupuladora.BottomNavigation
import com.example.manupuladora.dialog_notificaciones
import com.example.manupuladora.preparaciones_asignadas
import com.example.siraepae.databinding.ActivityDashboardManiBinding

class activity_dashboard : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardManiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ==========================================
        // EDGE TO EDGE
        // ==========================================

        enableEdgeToEdge()

        // ==========================================
        // VIEW BINDING
        // ==========================================

        binding = ActivityDashboardManiBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // ==========================================
        // INSETS
        // ==========================================

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

        // ==========================================
        // CONFIGURAR BOTONES
        // ==========================================

        configurarNotificaciones()

        configurarCategorias()

        // ==========================================
        // BARRA INFERIOR
        // ==========================================

        val bottomNavigation = BottomNavigation(
            this,
            binding.bottomNavigation
        )

        bottomNavigation.configurar("inicio")
    }

    // ==================================================
    // NOTIFICACIONES
    // ==================================================

    private fun configurarNotificaciones() {

        binding.btnNotificaciones.setOnClickListener {

            val notificaciones = dialog_notificaciones()

            notificaciones.show(
                supportFragmentManager,
                "dialog_notificaciones"
            )
        }
    }

    // ==================================================
    // CATEGORÍAS
    // ==================================================

    private fun configurarCategorias() {

        binding.cardDesayuno.setOnClickListener {
            abrirPreparacionesAsignadas("Desayuno")
        }

        binding.cardRefrigerio.setOnClickListener {
            abrirPreparacionesAsignadas("Refrigerio")
        }

        binding.cardAlmuerzo.setOnClickListener {
            abrirPreparacionesAsignadas("Almuerzo")
        }
    }

    // ==================================================
    // ABRIR PREPARACIONES ASIGNADAS
    // ==================================================

    private fun abrirPreparacionesAsignadas(
        categoria: String
    ) {

        val intent = Intent(
            this,
            preparaciones_asignadas::class.java
        )

        intent.putExtra(
            "CATEGORIA_SELECCIONADA",
            categoria
        )

        startActivity(intent)
    }
}