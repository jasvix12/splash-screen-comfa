package com.aaa.inicio11

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AprovadaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.solicitud_aprobada) // Asegúrate de que este sea el nombre correcto del XML

        // Configuración del header
        val profileIcon = findViewById<ImageView>(R.id.profileIcon)
        profileIcon.setOnClickListener {
            Toast.makeText(this, "Icono de perfil clicado", Toast.LENGTH_SHORT).show()
            // Aquí puedes implementar navegación al perfil del usuario si es necesario
        }

        // Configuración de los iconos del footer
        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        val pendingIcon = findViewById<ImageView>(R.id.pendingIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val approvedIcon = findViewById<ImageView>(R.id.approvedIcon)
        val locationIcon = findViewById<ImageView>(R.id.locationIcon)

        homeIcon.setOnClickListener {
            Toast.makeText(this, "Navegando a la página de Inicio", Toast.LENGTH_SHORT).show()
            // Agrega navegación a la pantalla de inicio
        }

        pendingIcon.setOnClickListener {
            Toast.makeText(this, "Navegando a la sección de Pendientes", Toast.LENGTH_SHORT).show()
            // Agrega navegación a la sección de pendientes
        }

        plusIcon.setOnClickListener {
            Toast.makeText(this, "Accediendo a la sección de Crear Permiso", Toast.LENGTH_SHORT).show()
            // Agrega navegación para crear un nuevo permiso
        }

        approvedIcon.setOnClickListener {
            Toast.makeText(this, "Navegando a Aprobadas", Toast.LENGTH_SHORT).show()
            // Ya estamos en la pantalla de Aprobadas, puedes desactivar este clic si prefieres
        }

        locationIcon.setOnClickListener {
            Toast.makeText(this, "Mostrando la ubicación", Toast.LENGTH_SHORT).show()
            // Implementa la lógica para mostrar la ubicación
        }

        // Cargar solicitudes aprobadas
        loadApprovedRequests()
    }

    private fun loadApprovedRequests() {
        // Aquí puedes implementar la lógica para cargar las solicitudes aprobadas
        Toast.makeText(this, "Cargando solicitudes aprobadas...", Toast.LENGTH_SHORT).show()

        // Ejemplo de lista de solicitudes aprobadas
        val approvedRequests = listOf(
            "Permiso laboral del 20/11/2024",
            "Permiso personal del 15/11/2024",
            "Permiso de salud del 10/11/2024"
        )

        // Muestra las solicitudes aprobadas en un RecyclerView o un TextView
        for (request in approvedRequests) {
            println("Aprobada: $request") // Esto

        }
    }
}