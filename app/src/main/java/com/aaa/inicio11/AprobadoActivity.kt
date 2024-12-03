package com.aaa.inicio11

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import android.widget.Button
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity

class AprobadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.solicitud_aprobada)


        val profileIcon = findViewById<ImageView>(R.id.profileIcon)
        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        val pendingIcon = findViewById<ImageView>(R.id.pendingIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val approvedIcon = findViewById<ImageView>(R.id.approvedIcon)
        val locationIcon = findViewById<ImageView>(R.id.locationIcon)


        profileIcon.setOnClickListener {
            showLogoutDialog()
        }


        homeIcon.setOnClickListener {
            val intent = Intent(this, AceptPermisosActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Aceptar Permisos", Toast.LENGTH_SHORT).show()
        }

        pendingIcon.setOnClickListener {
            val intent = Intent(this, PendientesActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Solicitudes Pendientes", Toast.LENGTH_SHORT).show()
        }

        plusIcon.setOnClickListener {
            val intent = Intent(this, PermisosActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Crear Permiso", Toast.LENGTH_SHORT).show()
        }

        approvedIcon.setOnClickListener {
            Toast.makeText(this, "Solicitud Aprobada", Toast.LENGTH_SHORT).show()
        }

        locationIcon.setOnClickListener {
            val intent = Intent(this, UbicacionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Mostrar Ubicación", Toast.LENGTH_SHORT).show()
        }

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
}
