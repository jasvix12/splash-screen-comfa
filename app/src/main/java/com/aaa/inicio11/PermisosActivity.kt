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

        // Listas de datos para los spinners
        val tiposDeSolicitud = listOf("Selecciona el tipo de solicitud", "Permiso Personal", "Permiso Laboral", "Permiso de Salud", "Permiso de Estudio")
        val seccionesDestino = listOf("Selecciona una sección", "Sección A", "Sección B", "Sección C")

        // Listas separadas para horas de salida y entrada
        val horasSalida = listOf("Selecciona la hora de salida", "07:00 AM", "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM","01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM")
        val horasEntrada = listOf("Selecciona la hora de entrada","07:00 AM", "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM")

        // Configurar adaptadores para los spinners
        configureSpinner(spinnerTipoSolicitud, tiposDeSolicitud)
        configureSpinner(spinnerSeccionDestino, seccionesDestino)
        configureSpinner(spinnerHoraSalida, horasSalida)
        configureSpinner(spinnerHoraEntrada, horasEntrada)


        profileIcon.setOnClickListener { showLogoutDialog() }
        aceptIcon.setOnClickListener { navigateToActivity(AceptPermisosActivity::class.java, "Aceptar Permisos") }
        pendingIcon.setOnClickListener { navigateToActivity(PendientesActivity::class.java, "Solicitudes Pendientes") }
        plusIcon.setOnClickListener { Toast.makeText(this, "Crear Permiso", Toast.LENGTH_SHORT).show() }
        approvedIcon.setOnClickListener { navigateToActivity(AprobadoActivity::class.java, "Solicitud Aprobada") }
        locationIcon.setOnClickListener { navigateToActivity(UbicacionActivity::class.java, "Mostrar Ubicación") }
    }

    // Método para configurar un spinner con su lista de datos
    private fun configureSpinner(spinner: Spinner, data: List<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    // Método para manejar la navegación a otra actividad con un mensaje
    private fun navigateToActivity(activityClass: Class<*>, message: String) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
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

        btnCancel.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }

    // Método para cerrar sesión y redirigir al LoginActivity
    private fun logoutUser() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

}





