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

        val spinnerTipoSolicitud = findViewById<Spinner>(R.id.spinnerTipoSolicitud)
        val spinnerSeccionDestino = findViewById<Spinner>(R.id.spinnerSeccionDestino)
        val spinnerHoraSalida = findViewById<Spinner>(R.id.spinnerHoraSalida)
        val spinnerHoraEntrada = findViewById<Spinner>(R.id.spinnerHoraEntrada)

        // Datos desde resources/strings.xml
        val tiposDeSolicitud = resources.getStringArray(R.array.tipos_de_solicitud).toList()
        val seccionesDestino = resources.getStringArray(R.array.secciones_de_destino).toList()
        val horasSalida = resources.getStringArray(R.array.horas).toList()
        val horasEntrada = resources.getStringArray(R.array.horas).toList()

        // Configuración de Spinners
        configureSpinner(spinnerTipoSolicitud, tiposDeSolicitud)
        configureSpinner(spinnerSeccionDestino, seccionesDestino)
        configureSpinner(spinnerHoraSalida, horasSalida)
        configureSpinner(spinnerHoraEntrada, horasEntrada)

        // Eventos de clic
        profileIcon.setOnClickListener { showLogoutDialog() }
        aceptIcon.setOnClickListener { navigateToActivity(AceptPermisosActivity::class.java, "Aceptar Permisos") }
        pendingIcon.setOnClickListener { navigateToActivity(PendientesActivity::class.java, "Solicitudes Pendientes") }
        approvedIcon.setOnClickListener { navigateToActivity(AprobadoActivity::class.java, "Solicitud Aprobada") }
        locationIcon.setOnClickListener { navigateToActivity(UbicacionActivity::class.java, "Mostrar Ubicación") }

        plusIcon.setOnClickListener {
            if (validarSeleccion(spinnerTipoSolicitud, "Selecciona un tipo de solicitud") &&
                validarSeleccion(spinnerSeccionDestino, "Selecciona una sección de destino") &&
                validarSeleccion(spinnerHoraSalida, "Selecciona una hora de salida") &&
                validarSeleccion(spinnerHoraEntrada, "Selecciona una hora de entrada")) {

                guardarPermiso(spinnerTipoSolicitud, spinnerSeccionDestino, spinnerHoraSalida, spinnerHoraEntrada)
            }
        }
    }

    // Configuración de Spinners
    private fun configureSpinner(spinner: Spinner, data: List<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    // Validar selección de Spinner
    private fun validarSeleccion(spinner: Spinner, mensajeError: String): Boolean {
        return if (spinner.selectedItemPosition == 0) {
            Toast.makeText(this, mensajeError, Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }

    // Guardar permiso
    private fun guardarPermiso(spinnerTipoSolicitud: Spinner, spinnerSeccionDestino: Spinner, spinnerHoraSalida: Spinner, spinnerHoraEntrada: Spinner) {
        val tipo = spinnerTipoSolicitud.selectedItem.toString()
        val seccion = spinnerSeccionDestino.selectedItem.toString()
        val horaSalida = spinnerHoraSalida.selectedItem.toString()
        val horaEntrada = spinnerHoraEntrada.selectedItem.toString()

        val permiso = "Tipo: $tipo, Sección: $seccion, Salida: $horaSalida, Entrada: $horaEntrada"
        Toast.makeText(this, "Permiso creado: $permiso", Toast.LENGTH_LONG).show()

        // Aquí puedes agregar lógica para guardar el permiso en una base de datos o enviarlo a un servidor
    }

    // Navegar a otra actividad
    private fun navigateToActivity(activityClass: Class<*>, message: String) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Mostrar diálogo de cerrar sesión
    private fun showLogoutDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_logout)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val btnLogout = dialog.findViewById<Button>(R.id.btn_logout)
        val btnCancel = dialog.findViewById<Button>(R.id.btn_cancel)

        btnLogout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Has cerrado sesión", Toast.LENGTH_SHORT).show()
            logoutUser()
        }

        btnCancel.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    // Cerrar sesión y redirigir al LoginActivity
    private fun logoutUser() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}






