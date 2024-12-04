package com.aaa.inicio11

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AceptPermisosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisos)

        // Configuración de los Spinners
        val tipoSolicitudSpinner = findViewById<Spinner>(R.id.spinnerTipoSolicitud)
        val sesionDestinoSpinner = findViewById<Spinner>(R.id.spinnerSeccionDestino)
        val horaSalidaSpinner = findViewById<Spinner>(R.id.spinnerHoraSalida)
        val horaEntradaSpinner = findViewById<Spinner>(R.id.spinnerHoraEntrada)

        // Arreglos de opciones para los spinners
        val tipoSolicitudOptions = arrayOf("Personal", "Enfermedad", "Vacaciones", "Otros")
        val sesionDestinoOptions = arrayOf("Mañana", "Tarde", "Noche")
        val horaSalidaOptions = arrayOf("06:00", "07:00", "08:00", "09:00", "10:00")
        val horaEntradaOptions = arrayOf("14:00", "15:00", "16:00", "17:00", "18:00")

        // Adaptadores para los Spinners
        val tipoSolicitudAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tipoSolicitudOptions)
        tipoSolicitudAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tipoSolicitudSpinner.adapter = tipoSolicitudAdapter

        val sesionDestinoAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sesionDestinoOptions)
        sesionDestinoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sesionDestinoSpinner.adapter = sesionDestinoAdapter

        val horaSalidaAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, horaSalidaOptions)
        horaSalidaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        horaSalidaSpinner.adapter = horaSalidaAdapter

        val horaEntradaAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, horaEntradaOptions)
        horaEntradaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        horaEntradaSpinner.adapter = horaEntradaAdapter

        // Configuración de los botones de acción
        val profileIcon = findViewById<ImageView>(R.id.profileIcon)
        val aceptIcon = findViewById<ImageView>(R.id.aceptIcon)
        val pendingIcon = findViewById<ImageView>(R.id.pendingIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val approvedIcon = findViewById<ImageView>(R.id.approvedIcon)
        val locationIcon = findViewById<ImageView>(R.id.locationIcon)

        // Eventos de los botones
        profileIcon?.setOnClickListener { showLogoutDialog() }
        aceptIcon?.setOnClickListener {
            Toast.makeText(this, "Aceptar Permisos", Toast.LENGTH_SHORT).show()
        }
        pendingIcon?.setOnClickListener {
            startActivity(Intent(this, PendientesActivity::class.java))
            Toast.makeText(this, "Solicitudes Pendientes", Toast.LENGTH_SHORT).show()
        }
        plusIcon?.setOnClickListener {
            startActivity(Intent(this, PermisosActivity::class.java))
            Toast.makeText(this, "Permisos", Toast.LENGTH_SHORT).show()
        }
        approvedIcon?.setOnClickListener {
            startActivity(Intent(this, AprobadoActivity::class.java))
            Toast.makeText(this, "Solicitud Aprobada", Toast.LENGTH_SHORT).show()
        }
        locationIcon?.setOnClickListener {
            startActivity(Intent(this, UbicacionActivity::class.java))
            Toast.makeText(this, "Ubicación Clicada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showLogoutDialog() {
        Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_SHORT).show()
    }
}














