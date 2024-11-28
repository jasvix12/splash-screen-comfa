package com.aaa.inicio11

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PendientesActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pendientes) // Manteniendo el layout, aunque el contexto es de "Pendientes"

        // Configurar el header
        val profileIcon = findViewById<ImageView>(R.id.profileIcon)
        profileIcon.setOnClickListener {
            Toast.makeText(this, "Icono de perfil clicado", Toast.LENGTH_SHORT).show()
        }


        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        val pendingIcon = findViewById<ImageView>(R.id.pendingIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val approvedIcon = findViewById<ImageView>(R.id.approvedIcon)
        val locationIcon = findViewById<ImageView>(R.id.locationIcon)


        homeIcon.setOnClickListener {
            val intent = Intent( this, AceptPermisosActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Navegando a la página de Inicio", Toast.LENGTH_SHORT).show()
            // Agrega navegación al inicio si es necesario
        }

        // Evento de clic en el icono de "Pendientes"
        pendingIcon.setOnClickListener {
            Toast.makeText(this, "Ya estás en la sección de Pendientes", Toast.LENGTH_SHORT).show()
        }


        plusIcon.setOnClickListener {
            val intent = Intent(this, PermisosActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Accediendo a la sección de Crear Permiso", Toast.LENGTH_SHORT).show()

        }


        approvedIcon.setOnClickListener {
            val intent = Intent(this, AprobadoActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "navegando a aprobados", Toast.LENGTH_SHORT).show()
            // Lógica para abrir un mapa o mostrar ubicaciones
        }


        locationIcon.setOnClickListener {
            Toast.makeText(this, "Ubicación actual mostrada", Toast.LENGTH_SHORT).show()

        }


        loadPendingRequests()
    }


    private fun loadPendingRequests() {

        Toast.makeText(this, "Cargando solicitudes pendientes...", Toast.LENGTH_SHORT).show()


        val pendingRequests = listOf(
            "Permiso laboral del 25/11/2024",
            "Permiso personal del 24/11/2024",
            "Permiso de estudio del 23/11/2024"
        )


        for (request in pendingRequests) {
            println("Solicitud: $request")
        }
    }
}
