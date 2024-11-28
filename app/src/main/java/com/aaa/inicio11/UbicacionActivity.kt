package com.aaa.inicio11

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UbicacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ubicacion)


        // Footer
        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        val pendingIcon = findViewById<ImageView>(R.id.pendingIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val approvedIcon = findViewById<ImageView>(R.id.approvedIcon)
        val locationIcon = findViewById<ImageView>(R.id.locationIcon)

        // Navegación desde los íconos del footer
        homeIcon.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Navegando a Inicio", Toast.LENGTH_SHORT).show()
        }

        pendingIcon.setOnClickListener {
            val intent = Intent(this, PendientesActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Navegando a Pendientes", Toast.LENGTH_SHORT).show()
        }

        plusIcon.setOnClickListener {
            Toast.makeText(this, "Abrir Crear Permiso", Toast.LENGTH_SHORT).show()
            // Implementa lógica para agregar permisos
        }

        approvedIcon.setOnClickListener {
            val intent = Intent(this, AprobadoActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Navegando a Aprobados", Toast.LENGTH_SHORT).show()
        }

        locationIcon.setOnClickListener {
            Toast.makeText(this, "Ya estás en Ubicación", Toast.LENGTH_SHORT).show()
        }

        // Cargar el mapa o ubicación
        loadMap()
    }

    private fun loadMap() {
        // Implementa la lógica para cargar un mapa real (como Google Maps)
        Toast.makeText(this, "Cargando el mapa...", Toast.LENGTH_SHORT).show()
    }
}
