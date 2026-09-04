package com.example.siraepae.manupuladora

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import com.example.siraepae.R
import com.example.siraepae.databinding.BottomNavigationManiBinding

class BottomNavigation(
    private val activity: Activity,
    private val binding: BottomNavigationManiBinding
) {

    fun configurar(pantallaActual: String) {

        // INICIO
        binding.navInicio.setOnClickListener {

            if (pantallaActual != "inicio") {

                val intent = Intent(
                    activity,
                    activity_dashboard::class.java
                )

                activity.startActivity(intent)
                activity.finish()
            }
        }

        // ASIGNADAS

        binding.navAsignadas.setOnClickListener {

            if (pantallaActual != "asignadas") {

                val intent = Intent(
                    activity,
                    preparaciones_asignadas::class.java
                )

                activity.startActivity(intent)
                activity.finish()
            }
        }

        // INVENTARIO

        binding.navInventario.setOnClickListener {

            if (pantallaActual != "inventario") {

                val intent = Intent(
                    activity,
                    activity_inventario::class.java
                )

                activity.startActivity(intent)
                activity.finish()
            }
        }

        // AVISOS

        binding.navAvisos.setOnClickListener {

            if (pantallaActual != "avisos") {

                val intent = Intent(
                    activity,
                    avisos_mani::class.java
                )

                activity.startActivity(intent)
                activity.finish()
            }
        }

        // PERFIL

        binding.navPerfil.setOnClickListener {

            if (pantallaActual != "perfil") {

                val intent = Intent(
                    activity,
                    perfil_mani::class.java
                )

                activity.startActivity(intent)
                activity.finish()
            }
        }

        // MARCAR PANTALLA ACTUAL

        seleccionar(pantallaActual)
    }

    // SELECCIONAR ELEMENTO ACTIVO

    private fun seleccionar(pantalla: String) {

        val amarillo = ContextCompat.getColor(
            activity,
            R.color.amarillo_principal
        )

        val gris = ContextCompat.getColor(
            activity,
            R.color.icono_gris
        )

        // TODOS EN GRIS

        binding.iconInicio.imageTintList =
            ColorStateList.valueOf(gris)

        binding.textInicio.setTextColor(gris)


        binding.iconAsignadas.imageTintList =
            ColorStateList.valueOf(gris)

        binding.textAsignadas.setTextColor(gris)


        binding.iconInventario.imageTintList =
            ColorStateList.valueOf(gris)

        binding.textInventario.setTextColor(gris)


        binding.iconAvisos.imageTintList =
            ColorStateList.valueOf(gris)

        binding.textAvisos.setTextColor(gris)


        binding.iconPerfil.imageTintList =
            ColorStateList.valueOf(gris)

        binding.textPerfil.setTextColor(gris)

        // ELEMENTO ACTIVO

        when (pantalla) {

            "inicio" -> {

                binding.iconInicio.imageTintList =
                    ColorStateList.valueOf(amarillo)

                binding.textInicio.setTextColor(amarillo)
            }


            "asignadas" -> {

                binding.iconAsignadas.imageTintList =
                    ColorStateList.valueOf(amarillo)

                binding.textAsignadas.setTextColor(amarillo)
            }


            "inventario" -> {

                binding.iconInventario.imageTintList =
                    ColorStateList.valueOf(amarillo)

                binding.textInventario.setTextColor(amarillo)
            }


            "avisos" -> {

                binding.iconAvisos.imageTintList =
                    ColorStateList.valueOf(amarillo)

                binding.textAvisos.setTextColor(amarillo)
            }


            "perfil" -> {

                binding.iconPerfil.imageTintList =
                    ColorStateList.valueOf(amarillo)

                binding.textPerfil.setTextColor(amarillo)
            }
        }
    }
}