package com.aaa.inicio11

import SolicitudAdapter
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class AceptPermisosActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var adapter: SolicitudAdapter
    private val solicitudesList = mutableListOf<Solicitud>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acept_permiso)

        // Inicializa Firebase Firestore
        db = FirebaseFirestore.getInstance()

        // Configurar RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewSolicitudes)
        configurarRecyclerView(recyclerView)

        // Cargar las solicitudes desde Firestore
        loadSolicitudesFromFirestore()

        // Configurar íconos del footer
        configurarFooter()
    }

    private fun loadSolicitudesFromFirestore() {
        db.collection("solicitudes")
            .whereEqualTo("estado", "pendiente")
            .get()
            .addOnSuccessListener { documents ->
                solicitudesList.clear()
                for (document in documents) {
                    val solicitud = document.toObject(Solicitud::class.java)
                    solicitud?.let { solicitudesList.add(it) }
                }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al cargar las solicitudes", Toast.LENGTH_SHORT).show()
            }
    }

    private fun configurarRecyclerView(recyclerView: RecyclerView) {
        adapter = SolicitudAdapter(
            solicitudesList,
            onAceptarClick = { solicitud -> mostrarCuadroDialogo(solicitud, "aceptado") },
            onRechazarClick = { solicitud -> mostrarCuadroDialogo(solicitud, "rechazado") }
        )
        recyclerView.adapter = adapter
    }

    private fun mostrarCuadroDialogo(solicitud: Solicitud, nuevoEstado: String) {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Confirmar Acción")
        dialogBuilder.setMessage(
            """
            Tipo: ${solicitud.tipo}
            Sección: ${solicitud.seccion}
            Hora de Salida: ${solicitud.horaSalida}
            Hora de Entrada: ${solicitud.horaEntrada}
            
            ¿Deseas marcar esta solicitud como "$nuevoEstado"?
            """.trimIndent()
        )
        dialogBuilder.setPositiveButton("Sí") { _, _ ->
            actualizarEstadoSolicitud(solicitud, nuevoEstado)
        }
        dialogBuilder.setNegativeButton("Cancelar", null)
        dialogBuilder.create().show()
    }

    private fun actualizarEstadoSolicitud(solicitud: Solicitud, nuevoEstado: String) {
        db.collection("solicitudes")
            .whereEqualTo("tipo", solicitud.tipo)
            .whereEqualTo("seccion", solicitud.seccion)
            .whereEqualTo("horaSalida", solicitud.horaSalida)
            .whereEqualTo("horaEntrada", solicitud.horaEntrada)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    val documentId = documents.documents[0].id
                    db.collection("solicitudes").document(documentId)
                        .update("estado", nuevoEstado)
                        .addOnSuccessListener {
                            solicitudesList.remove(solicitud)
                            adapter.notifyDataSetChanged()
                            Toast.makeText(this, "Permiso $nuevoEstado correctamente", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "Error al actualizar la solicitud", Toast.LENGTH_SHORT).show()
                        }
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al buscar la solicitud", Toast.LENGTH_SHORT).show()
            }
    }

    private fun configurarFooter() {
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
        approvedIcon.setOnClickListener { navigateToActivity(AprobadoActivity::class.java, "Solicitud Aprobada") }
        locationIcon.setOnClickListener { navigateToActivity(UbicacionActivity::class.java, "Mostrar Ubicación") }
    }

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

    private fun logoutUser() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    private fun navigateToActivity(activityClass: Class<*>, message: String) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}















