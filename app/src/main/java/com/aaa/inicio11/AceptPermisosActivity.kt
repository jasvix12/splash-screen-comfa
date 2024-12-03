package com.aaa.inicio11

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.app.Dialog

class AceptPermisosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acept_permiso)

        // Íconos de navegación
        val profileIcon = findViewById<ImageView>(R.id.profileIcon)
        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        val pendingIcon = findViewById<ImageView>(R.id.pendingIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val approvedIcon = findViewById<ImageView>(R.id.approvedIcon)
        val locationIcon = findViewById<ImageView>(R.id.locationIcon)

        // Mostrar diálogo de cerrar sesión cuando se hace clic en el icono de perfil
        profileIcon.setOnClickListener {
            showLogoutDialog()
        }

        // Otros íconos de navegación (como en tu código original)
        homeIcon.setOnClickListener {
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
            Toast.makeText(this, "Permisos", Toast.LENGTH_SHORT).show()
        }

        approvedIcon.setOnClickListener {
            val intent = Intent(this, AprobadoActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Solicitud Aprobada", Toast.LENGTH_SHORT).show()
        }

        locationIcon.setOnClickListener {
            val intent = Intent(this, UbicacionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Ubicación Clicada", Toast.LENGTH_SHORT).show()
        }

        // Configurar opciones de permisos (código que ya tienes)
        setupPermissionOptions()
    }

    private fun showLogoutDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_logout)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // Obtener los botones del diálogo
        val btnLogout = dialog.findViewById<Button>(R.id.btn_logout)
        val btnCancel = dialog.findViewById<Button>(R.id.btn_cancel)

        // Acción cuando se hace clic en "Cerrar sesión"
        btnLogout.setOnClickListener {
            dialog.dismiss()
            logoutUser()
        }

        // Acción cuando se hace clic en "Cancelar"
        btnCancel.setOnClickListener {
            dialog.dismiss() // Cerrar el diálogo sin hacer nada
        }

        dialog.show() // Mostrar el diálogo
    }

    private fun logoutUser() {
        // Redirigir al usuario a la actividad de Login (pantalla de inicio de sesión)
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish() // Finalizar la actividad actual (cerrar sesión)
    }

    private fun setupPermissionOptions() {
        val laboralAccept = findViewById<ImageView>(R.id.aceptLaboral)
        val laboralCancel = findViewById<ImageView>(R.id.cancelLaboral)

        laboralAccept.setOnClickListener {
            Toast.makeText(this, "Permiso laboral aceptado", Toast.LENGTH_SHORT).show()
        }

        laboralCancel.setOnClickListener {
            Toast.makeText(this, "Permiso laboral rechazado", Toast.LENGTH_SHORT).show()
        }

        val saludAccept = findViewById<ImageView>(R.id.aceptSalud)
        val saludCancel = findViewById<ImageView>(R.id.cancelSalud)

        saludAccept.setOnClickListener {
            Toast.makeText(this, "Permiso salud aceptado", Toast.LENGTH_SHORT).show()
        }

        saludCancel.setOnClickListener {
            Toast.makeText(this, "Permiso salud rechazado", Toast.LENGTH_SHORT).show()
        }

        val personalAccept = findViewById<ImageView>(R.id.aceptPersonal)
        val personalCancel = findViewById<ImageView>(R.id.cancelPersonal)

        personalAccept.setOnClickListener {
            Toast.makeText(this, "Permiso personal aceptado", Toast.LENGTH_SHORT).show()
        }

        personalCancel.setOnClickListener {
            Toast.makeText(this, "Permiso personal rechazado", Toast.LENGTH_SHORT).show()
        }

        val estudioAccept = findViewById<ImageView>(R.id.aceptEstudio)
        val estudioCancel = findViewById<ImageView>(R.id.cancelEstudio)

        estudioAccept.setOnClickListener {
            Toast.makeText(this, "Permiso estudio aceptado", Toast.LENGTH_SHORT).show()
        }

        estudioCancel.setOnClickListener {
            Toast.makeText(this, "Permiso estudio rechazado", Toast.LENGTH_SHORT).show()
        }
    }
}











