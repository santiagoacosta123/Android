package com.example.siraepae.manupuladora

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.manupuladora.popup_estado
import com.example.siraepae.R
import com.example.siraepae.databinding.ActivityPrepChocolateManiBinding

class activity_preparacion_chocolate : AppCompatActivity() {

    private lateinit var binding: ActivityPrepChocolateManiBinding

    companion object {
        private const val REQUEST_ESTADO = 100
        const val EXTRA_ESTADO_SELECCIONADO = "ESTADO_SELECCIONADO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ==========================================
        // EDGE TO EDGE
        // ==========================================

        enableEdgeToEdge()

        // ==========================================
        // VIEW BINDING
        // ==========================================

        binding = ActivityPrepChocolateManiBinding.inflate(
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

        binding.btnTerminado.setOnClickListener {

            val intent = Intent(
                this,
                popup_estado::class.java
            )

            startActivityForResult(
                intent,
                REQUEST_ESTADO
            )
        }
    }

    // ==========================================
    // RECIBIR ESTADO DEL POPUP
    // ==========================================

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(
            requestCode,
            resultCode,
            data
        )

        if (
            requestCode == REQUEST_ESTADO &&
            resultCode == Activity.RESULT_OK
        ) {

            val estado = data?.getStringExtra(
                EXTRA_ESTADO_SELECCIONADO
            )

            if (!estado.isNullOrEmpty()) {
                actualizarEstado(estado)
            }
        }
    }

    // ==========================================
    // ACTUALIZAR BOTÓN SEGÚN EL ESTADO
    // ==========================================

    private fun actualizarEstado(estado: String) {

        binding.btnTerminado.text = estado

        when (estado) {

            "Pendiente" -> {

                binding.btnTerminado.setBackgroundResource(
                    R.drawable.bg_estado_pendiente
                )
            }

            "En preparación" -> {

                binding.btnTerminado.setBackgroundResource(
                    R.drawable.bg_estado_preparacion
                )
            }

            "Terminado" -> {

                binding.btnTerminado.setBackgroundResource(
                    R.drawable.bg_estado_terminado
                )
            }
                
            }
        }
    }