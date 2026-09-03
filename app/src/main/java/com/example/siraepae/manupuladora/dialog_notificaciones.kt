package com.example.siraepae.manupuladora

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.siraepae.R

class dialog_notificaciones : DialogFragment() {

    // ==================================================
    // CREAR DIALOG
    // ==================================================

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = Dialog(requireContext())

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        return dialog
    }


    // ==================================================
    // CARGAR XML
    // ==================================================

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(
            R.layout.activity_dialog_notificaciones_mani,
            container,
            false
        )
    }


    // ==================================================
    // BOTONES
    // ==================================================

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        // ==========================================
        // BOTÓN X - CERRAR NOTIFICACIONES
        // ==========================================

        val btnCerrar = view.findViewById<View>(
            R.id.btnCerrarNotificaciones
        )

        btnCerrar.setOnClickListener {

            dismiss()
        }
    }


    // ==================================================
    // CONFIGURAR VENTANA
    // ==================================================

    override fun onStart() {

        super.onStart()

        val window = dialog?.window ?: return

        // ==========================================
        // FONDO TRANSPARENTE
        // ==========================================

        window.setBackgroundDrawableResource(
            android.R.color.transparent
        )

        // ==========================================
        // TAMAÑO
        // ==========================================

        val anchoPantalla =
            resources.displayMetrics.widthPixels

        val anchoDialogo =
            (anchoPantalla * 0.90).toInt()

        window.setLayout(
            anchoDialogo,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

        // ==========================================
        // POSICIÓN
        // ==========================================

        window.setGravity(
            Gravity.TOP or Gravity.CENTER_HORIZONTAL
        )

        val parametros = window.attributes

        parametros.y = 70

        window.attributes = parametros

        // ==========================================
        // CERRAR TOCANDO FUERA
        // ==========================================

        dialog?.setCanceledOnTouchOutside(true)
    }
}