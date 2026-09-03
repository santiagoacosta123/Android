package com.example.siraepae.manupuladora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siraepae.R
import com.example.siraepae.databinding.ActivityPrepHuevoRevueltoManiBinding

class preparacion_huevo_revuelto : AppCompatActivity() {

    private lateinit var binding: ActivityPrepHuevoRevueltoManiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ==========================================
        // EDGE TO EDGE
        // ==========================================

        enableEdgeToEdge()

        // ==========================================
        // VIEW BINDING
        // ==========================================

        binding = ActivityPrepHuevoRevueltoManiBinding.inflate(
            layoutInflater
        )

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
        // BOTÓN VOLVER
        // ==========================================

        binding.btnVolver.setOnClickListener {
            finish()
        }

        // ==========================================
        // BOTÓN ESTADO
        // ==========================================

        binding.btnEstado.setOnClickListener {

            val dialogo = popup_estado(this) { estado ->

                cambiarEstado(estado)
            }

            dialogo.show()
        }
    }

    // ==========================================
    // CAMBIAR ESTADO
    // ==========================================

    private fun cambiarEstado(estado: String) {

        // Cambiar texto
        binding.btnEstado.text = estado

        // Cambiar fondo según el estado
        when (estado) {

            "Pendiente" -> {

                binding.btnEstado.setBackgroundResource(
                    R.drawable.bg_estado_pendiente
                )
            }

            "En preparación" -> {

                binding.btnEstado.setBackgroundResource(
                    R.drawable.bg_estado_preparacion
                )
            }

            "Terminado" -> {

                binding.btnEstado.setBackgroundResource(
                    R.drawable.bg_estado_terminado
                )
            }
        }
    }
}