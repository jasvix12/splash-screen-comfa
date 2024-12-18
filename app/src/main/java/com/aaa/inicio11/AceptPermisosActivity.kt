package com.aaa.inicio11

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AceptPermisosActivity : AppCompatActivity() {
    private var adapter: SolicitudAdapter? = null
    private val solicitudesList: MutableList<Solicitud> = SolicitudesManager.solicitudesPendientes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acept_permiso)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewSolicitudes)
        configurarRecyclerView(recyclerView)
        configurarFooter()
    }

    private fun configurarRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(this)


        adapter = SolicitudAdapter(
            solicitudesList,
            object : SolicitudAdapter.OnAceptarListener {
                override fun onAceptar(solicitud: Solicitud?) {
                    solicitud?.let {
                        actualizarEstadoSolicitud(it, "aceptado")
                    }
                }
            },
            object : SolicitudAdapter.OnCancelarListener {
                override fun onCancelar(solicitud: Solicitud?) {
                    solicitud?.let {
                        Toast.makeText(this@AceptPermisosActivity, "Acción cancelada para el permiso: ${it.tipo}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        )

        recyclerView.adapter = adapter
    }


    private fun actualizarEstadoSolicitud(solicitud: Solicitud, nuevoEstado: String) {
        solicitud.estado = nuevoEstado
        solicitudesList.remove(solicitud)
        adapter?.notifyDataSetChanged()
        Toast.makeText(this, "Permiso $nuevoEstado correctamente", Toast.LENGTH_SHORT).show()
    }

    private fun configurarFooter() {
        try {
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
        } catch (e: Exception) {
            Log.e(TAG, "Error al configurar el footer", e)
        }
    }

    private fun showLogoutDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_logout)
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)

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

    companion object {
        private const val TAG = "AceptPermisosActivity"
    }
}












