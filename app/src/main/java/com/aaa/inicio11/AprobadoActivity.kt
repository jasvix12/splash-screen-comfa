package com.aaa.inicio11

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AprobadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.solicitud_aprobada)


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
            val intent = Intent(this, AceptPermisosActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Aceptar Permisos", Toast.LENGTH_SHORT).show()

        }

        pendingIcon.setOnClickListener {
            val intent = Intent(this, PendientesActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Solicitudes Pendientes", Toast.LENGTH_SHORT).show()

        }

        plusIcon.setOnClickListener {
            val intent = Intent(this, PermisosActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, " Crear Permiso", Toast.LENGTH_SHORT).show()

        }

        approvedIcon.setOnClickListener {
            Toast.makeText(this, "solicitud Aprobada", Toast.LENGTH_SHORT).show()

        }

        locationIcon.setOnClickListener {
            val  intent = Intent(this, UbicacionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Mostrar Ubicación", Toast.LENGTH_SHORT).show()

        }


        loadApprovedRequests()
    }

    private fun loadApprovedRequests() {

        Toast.makeText(this, "Cargando solicitudes aprobadas...", Toast.LENGTH_SHORT).show()


        val approvedRequests = listOf(
            "Permiso laboral del 20/11/2024",
            "Permiso personal del 15/11/2024",
            "Permiso de salud del 10/11/2024"
        )


        for (request in approvedRequests) {
            println("Aprobada: $request")

        }
    }
}