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
        setContentView(R.layout.pendientes)


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
            Toast.makeText(this, " Aceptar Permisos", Toast.LENGTH_SHORT).show()

        }

        pendingIcon.setOnClickListener {
            Toast.makeText(this, "Solicitudes Pendientes", Toast.LENGTH_SHORT).show()
        }

        plusIcon.setOnClickListener {
            val intent = Intent(this, PermisosActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, " Crear Permiso", Toast.LENGTH_SHORT).show()

        }

        approvedIcon.setOnClickListener {
            val intent = Intent(this, AprobadoActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Solicitud Aprobada", Toast.LENGTH_SHORT).show()

        }

        locationIcon.setOnClickListener {
            val intent = Intent(this, UbicacionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Mostrar Ubicacion", Toast.LENGTH_SHORT).show()

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
