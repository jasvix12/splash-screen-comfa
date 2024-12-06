package com.aaa.inicio11

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PermisosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisos)

        val spinnerTipoSolicitud = findViewById<Spinner>(R.id.spinnerTipoSolicitud)
        val spinnerSeccionDestino = findViewById<Spinner>(R.id.spinnerSeccionDestino)
        val spinnerHoraSalida = findViewById<Spinner>(R.id.spinnerHoraSalida)
        val spinnerHoraEntrada = findViewById<Spinner>(R.id.spinnerHoraEntrada)
        val btnEnviar = findViewById<Button>(R.id.btnEnviarPermiso)

        // Configurar los spinners
        configureSpinner(spinnerTipoSolicitud, resources.getStringArray(R.array.tipos_de_solicitud).toList())
        configureSpinner(spinnerSeccionDestino, resources.getStringArray(R.array.secciones_de_destino).toList())
        configureSpinner(spinnerHoraSalida, resources.getStringArray(R.array.hora_de_salida).toList())
        configureSpinner(spinnerHoraEntrada, resources.getStringArray(R.array.hora_de_entrada).toList())

        // Enviar permiso
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

    private fun configureSpinner(spinner: Spinner, data: List<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    private fun validarSeleccion(spinner: Spinner, mensajeError: String): Boolean {
        return if (spinner.selectedItemPosition == 0) {
            Toast.makeText(this, mensajeError, Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }

    private fun enviarPermiso(
        spinnerTipoSolicitud: Spinner,
        spinnerSeccionDestino: Spinner,
        spinnerHoraSalida: Spinner,
        spinnerHoraEntrada: Spinner
    ) {
        val tipo = spinnerTipoSolicitud.selectedItem.toString()
        val seccion = spinnerSeccionDestino.selectedItem.toString()
        val horaSalida = spinnerHoraSalida.selectedItem.toString()
        val horaEntrada = spinnerHoraEntrada.selectedItem.toString()

        // Crear una nueva solicitud y agregarla a FakeDatabase
        val nuevaSolicitud = SolicitudPermiso(tipo, seccion, horaSalida, horaEntrada)
        FakeDatabase.solicitudes.add(nuevaSolicitud)

        // Log para verificar
        android.util.Log.d("PermisosActivity", "Nueva solicitud agregada: $nuevaSolicitud")
        android.util.Log.d("FakeDatabase", "Solicitudes actuales: ${FakeDatabase.solicitudes}")

        Toast.makeText(this, "Permiso enviado correctamente", Toast.LENGTH_SHORT).show()

        // Navegar a AceptPermisosActivity
        val intent = Intent(this, AceptPermisosActivity::class.java)
        startActivity(intent)
    }
}









