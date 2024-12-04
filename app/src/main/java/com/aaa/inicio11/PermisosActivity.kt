package com.aaa.inicio11

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PermisosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisos)

        // Referencias a los elementos del diseño
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
        val btnEnviar = findViewById<Button>(R.id.btnEnviarPermiso) // Botón de enviar

        // Configuración de los datos en los Spinners (desde strings.xml)
        configureSpinner(spinnerTipoSolicitud, resources.getStringArray(R.array.tipos_de_solicitud).toList())
        configureSpinner(spinnerSeccionDestino, resources.getStringArray(R.array.secciones_de_destino).toList())
        configureSpinner(spinnerHoraSalida, resources.getStringArray(R.array.hora_de_salida).toList())
        configureSpinner(spinnerHoraEntrada, resources.getStringArray(R.array.hora_de_entrada).toList())

        // Eventos de clic para los íconos
        profileIcon.setOnClickListener { showLogoutDialog() }
        aceptIcon.setOnClickListener { navigateToActivity(AceptPermisosActivity::class.java, "Aceptar Permisos") }
        pendingIcon.setOnClickListener { navigateToActivity(PendientesActivity::class.java, "Solicitudes Pendientes") }
        approvedIcon.setOnClickListener { navigateToActivity(AprobadoActivity::class.java, "Solicitud Aprobada") }
        locationIcon.setOnClickListener { navigateToActivity(UbicacionActivity::class.java, "Mostrar Ubicación") }

        // Evento de clic en el botón "plusIcon" para guardar una nueva solicitud
        plusIcon.setOnClickListener {
            if (validarSeleccion(spinnerTipoSolicitud, "Selecciona un tipo de solicitud") &&
                validarSeleccion(spinnerSeccionDestino, "Selecciona una sección de destino") &&
                validarSeleccion(spinnerHoraSalida, "Selecciona una hora de salida") &&
                validarSeleccion(spinnerHoraEntrada, "Selecciona una hora de entrada")
            ) {
                guardarPermiso(spinnerTipoSolicitud, spinnerSeccionDestino, spinnerHoraSalida, spinnerHoraEntrada)
            }
        }

        // Funcionalidad para el botón "Enviar"
        btnEnviar.setOnClickListener {
            if (validarSeleccion(spinnerTipoSolicitud, "Selecciona un tipo de solicitud") &&
                validarSeleccion(spinnerSeccionDestino, "Selecciona una sección de destino") &&
                validarSeleccion(spinnerHoraSalida, "Selecciona una hora de salida") &&
                validarSeleccion(spinnerHoraEntrada, "Selecciona una hora de entrada")
            ) {
                enviarPermiso(spinnerTipoSolicitud, spinnerSeccionDestino, spinnerHoraSalida, spinnerHoraEntrada)
            }
        }
    }

    // Configuración de Spinner con datos
    private fun configureSpinner(spinner: Spinner, data: List<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    // Validar que el usuario haya seleccionado un valor distinto al primer elemento
    private fun validarSeleccion(spinner: Spinner, mensajeError: String): Boolean {
        return if (spinner.selectedItemPosition == 0) {
            Toast.makeText(this, mensajeError, Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }

    // Guardar la solicitud de permiso en una base de datos simulada
    private fun guardarPermiso(spinnerTipoSolicitud: Spinner, spinnerSeccionDestino: Spinner, spinnerHoraSalida: Spinner, spinnerHoraEntrada: Spinner) {
        val tipo = spinnerTipoSolicitud.selectedItem.toString()
        val seccion = spinnerSeccionDestino.selectedItem.toString()
        val horaSalida = spinnerHoraSalida.selectedItem.toString()
        val horaEntrada = spinnerHoraEntrada.selectedItem.toString()

        // Crear y guardar la solicitud en la base de datos simulada
        val nuevaSolicitud = SolicitudPermiso(tipo, seccion, horaSalida, horaEntrada)
        FakeDatabase.solicitudes.add(nuevaSolicitud)

        Toast.makeText(this, "Permiso creado exitosamente", Toast.LENGTH_SHORT).show()
    }

    // Acción del botón "Enviar"
    private fun enviarPermiso(spinnerTipoSolicitud: Spinner, spinnerSeccionDestino: Spinner, spinnerHoraSalida: Spinner, spinnerHoraEntrada: Spinner) {
        val tipo = spinnerTipoSolicitud.selectedItem.toString()
        val seccion = spinnerSeccionDestino.selectedItem.toString()
        val horaSalida = spinnerHoraSalida.selectedItem.toString()
        val horaEntrada = spinnerHoraEntrada.selectedItem.toString()

        // Enviar la solicitud (ejemplo con Toast, puedes cambiarlo a una lógica personalizada)
        Toast.makeText(
            this,
            "Permiso enviado:\nTipo: $tipo\nSección: $seccion\nSalida: $horaSalida\nEntrada: $horaEntrada",
            Toast.LENGTH_LONG
        ).show()
    }

    // Navegar a otra actividad y mostrar un mensaje Toast
    private fun navigateToActivity(activityClass: Class<*>, message: String) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Mostrar el cuadro de diálogo para cerrar sesión
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








