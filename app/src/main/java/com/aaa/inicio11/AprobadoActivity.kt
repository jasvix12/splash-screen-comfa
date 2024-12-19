package com.aaa.inicio11

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import android.widget.Button
import android.app.Dialog
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AprobadoActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.solicitud_aprobada)

        val mensajeAprobado = intent.getStringExtra("mensaje_aprobado")
        val textoMensajeAprobado = findViewById<TextView>(R.id.textMensajeAprobado)
        val contenedorMensaje = findViewById<LinearLayout>(R.id.contenedorMensaje)
        val checkIcon = findViewById<ImageView>(R.id.checkIcon)

        if (!mensajeAprobado.isNullOrEmpty()) {
            textoMensajeAprobado.text = mensajeAprobado
            contenedorMensaje.setBackgroundResource(R.drawable.border_cuadro) // Mostrar fondo
            checkIcon.visibility = View.VISIBLE // Mostrar el ícono de check
        } else {
            textoMensajeAprobado.text = "No hay mensajes disponibles"
            contenedorMensaje.setBackgroundResource(android.R.color.transparent) // Fondo transparente
            checkIcon.visibility = View.GONE // Ocultar el ícono de check
        }

        // Configuración de íconos del menú
        val profileIcon = findViewById<ImageView>(R.id.profileIcon)
        val aceptIcon = findViewById<ImageView>(R.id.aceptIcon)
        val pendingIcon = findViewById<ImageView>(R.id.pendingIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val approvedIcon = findViewById<ImageView>(R.id.approvedIcon)
        val locationIcon = findViewById<ImageView>(R.id.locationIcon)

        profileIcon.setOnClickListener { showLogoutDialog() }
        aceptIcon.setOnClickListener { navigateToActivity(AceptPermisosActivity::class.java, "Aceptar Permisos") }
        pendingIcon.setOnClickListener { navigateToActivity(PendientesActivity::class.java, "Solicitudes Pendientes") }
        plusIcon.setOnClickListener { navigateToActivity(PermisosActivity::class.java, "Crear Permiso") }
        approvedIcon.setOnClickListener { Toast.makeText(this, "Solicitud Aprobada", Toast.LENGTH_SHORT).show() }
        locationIcon.setOnClickListener { navigateToActivity(UbicacionActivity::class.java, "Mostrar Ubicación") }

        loadApprovedRequests()
    }

    // Método para mostrar el diálogo de cerrar sesión
    private fun showLogoutDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_logout)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val btnLogout = dialog.findViewById<Button>(R.id.btn_logout)
        val btnCancel = dialog.findViewById<Button>(R.id.btn_cancel)

        btnLogout.setOnClickListener {
            dialog.dismiss()
            logoutUser()
        }

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    // Método para cerrar sesión y redirigir al LoginActivity
    private fun logoutUser() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    // Método para cargar solicitudes aprobadas (simulado)
    private fun loadApprovedRequests() {
        Toast.makeText(this, "Cargando solicitudes aprobadas...", Toast.LENGTH_SHORT).show()
        val approvedRequests = listOf(
            "Permiso laboral del 20/11/2024",
            "Permiso personal del 15/11/2024",
            "Permiso de salud del 10/11/2024"
        )
        for (request in approvedRequests) {
            println("Aprobada: $request")
        }
    }

    // Método auxiliar para navegación a otras actividades
    private fun navigateToActivity(activityClass: Class<*>, message: String) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

