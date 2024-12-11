package com.aaa.inicio11

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class PermisosActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisos)

        // Inicializar Firestore
        db = FirebaseFirestore.getInstance()

        // Iconos del footer
        val aceptIcon: ImageView = findViewById(R.id.aceptIcon)
        val pendingIcon: ImageView = findViewById(R.id.pendingIcon)
        val plusIcon: ImageView = findViewById(R.id.plusIcon)
        val approvedIcon: ImageView = findViewById(R.id.approvedIcon)
        val locationIcon: ImageView = findViewById(R.id.locationIcon)
        val profileIcon: ImageView = findViewById(R.id.profileIcon) // Ícono para cerrar sesión

        // Botones del formulario
        val btnSolicitar: Button = findViewById(R.id.btnSolicitar)
        val btnCancelar: Button = findViewById(R.id.btnCancelar)

        // Otros elementos del formulario
        val fechaSalida: EditText = findViewById(R.id.fechaSalida)
        val horaSalida: EditText = findViewById(R.id.horaSalida)
        val horaEntrada: EditText = findViewById(R.id.horaEntrada)
        val destino: EditText = findViewById(R.id.destino)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroupPermisos)
        val autorizadores = listOf(
            findViewById<CheckBox>(R.id.autorizador1),
            findViewById<CheckBox>(R.id.autorizador4)
        )

        // Lógica para íconos del footer
        aceptIcon.setOnClickListener {
            navigateToActivity(AceptPermisosActivity::class.java, "Inicio")
        }

        pendingIcon.setOnClickListener {
            navigateToActivity(PendientesActivity::class.java, "Solicitudes Pendientes")
        }

        plusIcon.setOnClickListener {
            navigateToActivity(PermisosActivity::class.java, "Crear Permiso")
        }

        approvedIcon.setOnClickListener {
            navigateToActivity(AprobadoActivity::class.java, "Permisos Aprobados")
        }

        locationIcon.setOnClickListener {
            navigateToActivity(UbicacionActivity::class.java, "Mostrar Ubicación")
        }

        // Lógica para cerrar sesión
        profileIcon.setOnClickListener {
            showLogoutDialog()
        }

        // Lógica para el botón "Solicitar"
        btnSolicitar.setOnClickListener {
            val fecha = fechaSalida.text.toString()
            val salida = horaSalida.text.toString()
            val entrada = horaEntrada.text.toString()
            val destinoText = destino.text.toString()

            val selectedRadioButtonId = radioGroup.checkedRadioButtonId

            val tipoPermiso = if (selectedRadioButtonId != -1) {
                findViewById<RadioButton>(selectedRadioButtonId).text.toString()
            } else {
                null
            }

            val autorizadoresSeleccionados = autorizadores.filter { it.isChecked }.map { it.text.toString() }

            if (fecha.isEmpty() || salida.isEmpty() || tipoPermiso.isNullOrEmpty() || autorizadoresSeleccionados.isEmpty() || destinoText.isEmpty()) {
                Snackbar.make(it, "Por favor, completa todos los campos obligatorios", Snackbar.LENGTH_LONG).show()
            } else {
                enviarPermiso(fecha, salida, entrada, tipoPermiso, destinoText, autorizadoresSeleccionados)
            }
        }

        // Lógica para el botón "Cancelar"
        btnCancelar.setOnClickListener {
            finish()
        }

        // Eventos para abrir el DatePicker (para seleccionar fecha)
        fechaSalida.setOnClickListener {
            mostrarDatePicker(fechaSalida)
        }

        // Eventos para abrir el TimePicker (para seleccionar hora)
        horaSalida.setOnClickListener {
            mostrarTimePicker(horaSalida)
        }

        horaEntrada.setOnClickListener {
            mostrarTimePicker(horaEntrada)
        }
    }

    private fun enviarPermiso(
        fecha: String,
        salida: String,
        entrada: String,
        tipoPermiso: String,
        destino: String,
        autorizadores: List<String>
    ) {
        val permiso = mapOf(
            "fecha" to fecha,
            "horaSalida" to salida,
            "horaEntrada" to entrada,
            "tipoPermiso" to tipoPermiso,
            "destino" to destino,
            "autorizadores" to autorizadores,
            "estado" to "pendiente"  // El estado inicial es "pendiente"
        )

        db.collection("solicitudes")
            .add(permiso)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(this, "Permiso enviado exitosamente", Toast.LENGTH_SHORT).show()
                // Guardar el ID del documento para su posterior uso
                val permisoId = documentReference.id
                updatePermissionStatus(permisoId, "pendiente")
                finish()
            }
            .addOnFailureListener { e ->
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Error al enviar permiso: ${e.message}",
                    Snackbar.LENGTH_LONG
                ).show()
            }
    }

    private fun updatePermissionStatus(permisoId: String, estado: String) {
        val permisoRef = db.collection("solicitudes").document(permisoId)
        permisoRef.update("estado", estado)
            .addOnSuccessListener {
                Snackbar.make(findViewById(android.R.id.content), "Estado actualizado a $estado", Snackbar.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Snackbar.make(findViewById(android.R.id.content), "Error al actualizar estado: ${e.message}", Snackbar.LENGTH_LONG).show()
            }
    }

    private fun mostrarDatePicker(editText: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val fecha = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            editText.setText(fecha)
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun mostrarTimePicker(editText: EditText) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
            val hora = String.format("%02d:%02d", selectedHour, selectedMinute)
            editText.setText(hora)
        }, hour, minute, true)

        timePickerDialog.show()
    }

    private fun navigateToActivity(targetActivity: Class<*>, message: String) {
        val intent = Intent(this, targetActivity)
        startActivity(intent)
        Toast.makeText(this, "Navegando a $message", Toast.LENGTH_SHORT).show()
    }

    private fun showLogoutDialog() {
        // Crear el diálogo de cierre de sesión
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_logout)  // Asegúrate de tener un diseño para el diálogo
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

    private fun logoutUser() {
        // Redirigir al Login y limpiar actividades previas
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}





















