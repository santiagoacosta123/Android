package com.example.siraepae.manupuladora

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siraepae.databinding.ActivityLoginManiBinding

class activity_login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginManiBinding

    // ÚNICO USUARIO AUTORIZADO
    private val correoCorrecto = "laura@pae.com"
    private val contrasenaCorrecta = "123456"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // EDGE TO EDGE

        enableEdgeToEdge()

        // VIEW BINDING

        binding = ActivityLoginManiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // INSETS
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { vista, insets ->

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
        // CONFIGURACIONES

        configurarLogin()
        configurarOlvideContrasena()
    }

    // LOGIN

    private fun configurarLogin() {

        binding.btnIngresar.setOnClickListener {

            // OBTENER CORREO

            val correo = binding.edtCorreo.text
                .toString()
                .trim()

            // OBTENER CONTRASEÑA

            val contrasena = binding.edtContrasena.text
                .toString()

            // CORREO VACÍO
            if (correo.isEmpty()) {

                binding.edtCorreo.error =
                    "Ingresa tu correo"

                binding.edtCorreo.requestFocus()

                return@setOnClickListener
            }

            // CONTRASEÑA VACÍA

            if (contrasena.isEmpty()) {

                binding.edtContrasena.error =
                    "Ingresa tu contraseña"

                binding.edtContrasena.requestFocus()

                return@setOnClickListener
            }

            // VALIDAR CREDENCIALES

            if (
                correo == correoCorrecto &&
                contrasena == contrasenaCorrecta
            ) {

                // LOGIN CORRECTO

                Toast.makeText(
                    this,
                    "Inicio de sesión correcto",
                    Toast.LENGTH_SHORT
                ).show()

                // IR AL DASHBOARD

                val intent = Intent(
                    this,
                    activity_dashboard::class.java
                )

                startActivity(intent)

                // No permitir regresar al login con "Atrás"
                finish()

            } else {

                // LOGIN INCORRECTO
                Toast.makeText(
                    this,
                    "Correo o contraseña incorrectos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    // OLVIDO CONTRASEÑA

    private fun configurarOlvideContrasena() {

        binding.btnOlvideContrasena.setOnClickListener {

            Toast.makeText(
                this,
                "Contacta al administrador para recuperar tu contraseña",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}