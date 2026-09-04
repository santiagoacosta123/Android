package com.example.siraepae.manupuladora

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import com.example.siraepae.R

class popup_estado(
    context: Context,
    private val onEstadoSeleccionado: (String) -> Unit
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.activity_popup_estado_mani)

        // CONFIGURAR VENTANA

        window?.apply {

            setBackgroundDrawableResource(
                android.R.color.transparent
            )

            setGravity(Gravity.CENTER)

            addFlags(
                WindowManager.LayoutParams.FLAG_DIM_BEHIND
            )

            attributes = attributes.apply {
                dimAmount = 0.35f
            }
        }

        // OPCIONES

        val opcionPendiente = findViewById<TextView>(
            R.id.opcionPendiente
        )

        val opcionPreparacion = findViewById<TextView>(
            R.id.opcionPreparacion
        )

        val opcionTerminado = findViewById<TextView>(
            R.id.opcionTerminado
        )

        // PENDIENTE

        opcionPendiente.setOnClickListener {

            onEstadoSeleccionado("Pendiente")

            dismiss()
        }

        // EN PREPARACIÓN

        opcionPreparacion.setOnClickListener {

            onEstadoSeleccionado("En preparación")

            dismiss()
        }

        // TERMINADO
        opcionTerminado.setOnClickListener {

            onEstadoSeleccionado("Terminado")

            dismiss()
        }

        // CERRAR TOCANDO AFUERA

        setCanceledOnTouchOutside(true)
    }
}