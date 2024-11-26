package com.aaa.inicio11

import android.annotation.SuppressLint
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

        // Configurar los iconos del footer
        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        val pendingIcon = findViewById<ImageView>(R.id.pendingIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val approvedIcon = findViewById<ImageView>(R.id.approvedIcon)
        val locationIcon = findViewById<ImageView>(R.id.locationIcon)

        // Evento de clic en el icono de "Home"
        homeIcon.setOnClickListener {
            Toast.makeText(this, "Navegando a la página de Inicio", Toast.LENGTH_SHORT).show()
            // Agrega navegación al inicio si es necesario
        }

        // Evento de clic en el icono de "Pendientes"
        pendingIcon.setOnClickListener {
            Toast.makeText(this, "Ya estás en la sección de Pendientes", Toast.LENGTH_SHORT).show()
        }

        // Evento de clic en el icono de "Más"
        plusIcon.setOnClickListener {
            Toast.makeText(this, "Accediendo a la sección de Crear Permiso", Toast.LENGTH_SHORT).show()
            // Agrega navegación para crear un nuevo permiso
        }

        // Evento de clic en el icono de "Mapa"
        approvedIcon.setOnClickListener {
            Toast.makeText(this, "Mapa abierto", Toast.LENGTH_SHORT).show()
            // Lógica para abrir un mapa o mostrar ubicaciones
        }

        // Evento de clic en el icono de "Ubicación"
        locationIcon.setOnClickListener {
            Toast.makeText(this, "Ubicación actual mostrada", Toast.LENGTH_SHORT).show()
            // Lógica para mostrar la ubicación actual
        }

        // Cargar solicitudes pendientes
        loadPendingRequests()
    }

    // Función para cargar solicitudes pendientes
    private fun loadPendingRequests() {
        // Aquí puedes implementar la lógica para cargar y mostrar las solicitudes pendientes
        // Por ejemplo, puedes cargar una lista desde una base de datos local o una API
        Toast.makeText(this, "Cargando solicitudes pendientes...", Toast.LENGTH_SHORT).show()

        // Ejemplo de una lista simple de solicitudes
        val pendingRequests = listOf(
            "Permiso laboral del 25/11/2024",
            "Permiso personal del 24/11/2024",
            "Permiso de estudio del 23/11/2024"
        )

        // Mostrar estas solicitudes en un RecyclerView o un TextView (según tu diseño)
        for (request in pendingRequests) {
            println("Solicitud: $request") // Para depuración
        }
    }
}
