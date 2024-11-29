package com.aaa.inicio11

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PermisosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisos)

        // Íconos de navegación
        val profileIcon = findViewById<ImageView>(R.id.profileIcon)
        val aceptIcon = findViewById<ImageView>(R.id.aceptIcon)
        val pendingIcon = findViewById<ImageView>(R.id.pendingIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val approvedIcon = findViewById<ImageView>(R.id.approvedIcon)
        val locationIcon = findViewById<ImageView>(R.id.locationIcon)

        // Spinners
        val spinnerTipoSolicitud = findViewById<Spinner>(R.id.spinnerTipoSolicitud)
        val spinnerSeccionDestino = findViewById<Spinner>(R.id.spinnerSeccionDestino)
        val spinnerHoraSalida = findViewById<Spinner>(R.id.spinnerHoraSalida)
        val spinnerHoraEntrada = findViewById<Spinner>(R.id.spinnerHoraEntrada)

        // Configurar adaptadores para los Spinners
        val tiposDeSolicitud = listOf("Permiso Personal", "Permiso Laboral", "Permiso de Salud")
        val seccionesDestino = listOf("Sección A", "Sección B", "Sección C")
        val horas = listOf("08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00")

        // Configurar adaptadores para los spinners
        val adapterTipoSolicitud = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposDeSolicitud)
        adapterTipoSolicitud.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTipoSolicitud.adapter = adapterTipoSolicitud

        val adapterSeccionDestino = ArrayAdapter(this, android.R.layout.simple_spinner_item, seccionesDestino)
        adapterSeccionDestino.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSeccionDestino.adapter = adapterSeccionDestino

        val adapterHoraSalida = ArrayAdapter(this, android.R.layout.simple_spinner_item, horas)
        adapterHoraSalida.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerHoraSalida.adapter = adapterHoraSalida

        val adapterHoraEntrada = ArrayAdapter(this, android.R.layout.simple_spinner_item, horas)
        adapterHoraEntrada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerHoraEntrada.adapter = adapterHoraEntrada

        // Mostrar diálogo de cerrar sesión cuando se hace clic en el icono de perfil
        profileIcon.setOnClickListener {
            showLogoutDialog()  // Llama a la función para mostrar el diálogo
        }

        // Otros íconos de navegación
        aceptIcon.setOnClickListener {
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
            Toast.makeText(this, "Crear Permiso", Toast.LENGTH_SHORT).show()
        }

        approvedIcon.setOnClickListener {
            val intent = Intent(this, AprobadoActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Solicitud Aprobada", Toast.LENGTH_SHORT).show()
        }

        locationIcon.setOnClickListener {
            val intent = Intent(this, UbicacionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Mostrar Ubicación", Toast.LENGTH_SHORT).show()
        }
    }

    // Método para mostrar el diálogo de cerrar sesión
    private fun showLogoutDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_logout)  // Diseño del diálogo
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // Obtener los botones del diálogo
        val btnLogout = dialog.findViewById<Button>(R.id.btn_logout)
        val btnCancel = dialog.findViewById<Button>(R.id.btn_cancel)

        // Acción cuando se hace clic en "Cerrar sesión"
        btnLogout.setOnClickListener {
            dialog.dismiss()  // Cerrar el diálogo
            logoutUser()      // Llamar al método para cerrar sesión
        }

        // Acción cuando se hace clic en "Cancelar"
        btnCancel.setOnClickListener {
            dialog.dismiss()  // Cerrar el diálogo sin hacer nada
        }

        dialog.show() // Mostrar el diálogo
    }

    // Método para cerrar sesión y redirigir al LoginActivity
    private fun logoutUser() {
        // Redirigir al usuario a la actividad de Login (pantalla de inicio de sesión)
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish() // Finalizar la actividad actual (cerrar sesión)
    }
}





