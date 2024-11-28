package com.aaa.inicio11

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PermisosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisos)


        val profileIcon = findViewById<ImageView>(R.id.profileIcon)
        profileIcon.setOnClickListener {
            Toast.makeText(this, "Perfil clicado", Toast.LENGTH_SHORT).show()
        }


        val spinnerTipoSolicitud = findViewById<Spinner>(R.id.spinnerTipoSolicitud)
        val spinnerSeccionDestino = findViewById<Spinner>(R.id.spinnerSeccionDestino)
        val spinnerHoraSalida = findViewById<Spinner>(R.id.spinnerHoraSalida)
        val spinnerHoraEntrada = findViewById<Spinner>(R.id.spinnerHoraEntrada)




        val aceptIcon = findViewById<ImageView>(R.id.aceptIcon)
        val pendingIcon = findViewById<ImageView>(R.id.pendingIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val approvedIcon = findViewById<ImageView>(R.id.approvedIcon)
        val locationIcon = findViewById<ImageView>(R.id.locationIcon)


        aceptIcon.setOnClickListener {
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
            Toast.makeText(this, "Crear Permiso ", Toast.LENGTH_SHORT).show()
        }

        approvedIcon.setOnClickListener {
            val intent = Intent(this, AprobadoActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Solicitud Aprobada", Toast.LENGTH_SHORT).show()
        }

        locationIcon.setOnClickListener {
            val intent = Intent(this, UbicacionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Mostrar Ubicación", Toast.LENGTH_SHORT).show()
        }
    }
}



