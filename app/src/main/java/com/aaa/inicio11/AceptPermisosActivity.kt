package com.aaa.inicio11

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class AceptPermisosActivity : AppCompatActivity() {

    // Adaptador del RecyclerView
    private lateinit var adapter: SolicitudAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acept_permiso)

        // Configurar RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewSolicitudes)
        configurarRecyclerView(recyclerView)

        // Configurar íconos del footer
        configurarFooter()
    }

    private fun configurarRecyclerView(recyclerView: RecyclerView) {
        // Inicializar el adaptador con las solicitudes de FakeDatabase
        adapter = SolicitudAdapter(
            FakeDatabase.solicitudes,
            onAceptarClick = { solicitud ->
                // Aceptar solicitud
                FakeDatabase.solicitudes.remove(solicitud)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Permiso aceptado: ${solicitud.tipo}", Toast.LENGTH_SHORT).show()
            },
            onRechazarClick = { solicitud ->
                // Rechazar solicitud
                FakeDatabase.solicitudes.remove(solicitud)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Permiso rechazado: ${solicitud.tipo}", Toast.LENGTH_SHORT).show()
            }
        )

        // Configurar RecyclerView con el adaptador
        recyclerView.adapter = adapter
    }

    private fun configurarFooter() {
        // Referencias a los íconos del footer
        val profileIcon = findViewById<ImageView>(R.id.profileIcon)
        val aceptIcon = findViewById<ImageView>(R.id.aceptIcon)
        val pendingIcon = findViewById<ImageView>(R.id.pendingIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val approvedIcon = findViewById<ImageView>(R.id.approvedIcon)
        val locationIcon = findViewById<ImageView>(R.id.locationIcon)

        // Eventos de clic para cada ícono
        profileIcon.setOnClickListener { showLogoutDialog() }
        aceptIcon.setOnClickListener { navigateToActivity(AceptPermisosActivity::class.java, "Aceptar Permisos") }
        pendingIcon.setOnClickListener { navigateToActivity(PendientesActivity::class.java, "Solicitudes Pendientes") }
        plusIcon.setOnClickListener { navigateToActivity(PermisosActivity::class.java, "Crear Permiso") }
        approvedIcon.setOnClickListener { navigateToActivity(AprobadoActivity::class.java, "Solicitud Aprobada") }
        locationIcon.setOnClickListener { navigateToActivity(UbicacionActivity::class.java, "Mostrar Ubicación") }
    }

    private fun showLogoutDialog() {
        // Mostrar diálogo de cierre de sesión
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
        // Redirigir al Login y limpiar actividades previas
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    private fun navigateToActivity(activityClass: Class<*>, message: String) {
        // Navegar a otra actividad
        val intent = Intent(this, activityClass)
        startActivity(intent)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

















