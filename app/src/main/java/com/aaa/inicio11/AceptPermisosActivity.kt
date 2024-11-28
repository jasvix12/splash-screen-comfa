package com.aaa.inicio11

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AceptPermisosActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acept_permiso)

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
            Toast.makeText(this, " Permisos", Toast.LENGTH_SHORT).show()
        }

        approvedIcon.setOnClickListener {
            val intent = Intent(this, AprobadoActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Solicitud a Aprovada", Toast.LENGTH_SHORT).show()
        }

        locationIcon.setOnClickListener {
            val intent = Intent(this, UbicacionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Ubicación clicada", Toast.LENGTH_SHORT).show()
        }

        setupPermissionOptions()
    }

    private fun setupPermissionOptions() {
        val laboralAccept = findViewById<ImageView>(R.id.aceptLaboral)
        val laboralCancel = findViewById<ImageView>(R.id.cancelLaboral)

        laboralAccept.setOnClickListener {
            Toast.makeText(this, "Permiso laboral aceptado", Toast.LENGTH_SHORT).show()
        }

        laboralCancel.setOnClickListener {
            Toast.makeText(this, "Permiso laboral rechazado", Toast.LENGTH_SHORT).show()
        }

        val saludAccept = findViewById<ImageView>(R.id.aceptSalud)
        val saludCancel = findViewById<ImageView>(R.id.cancelSalud)

        saludAccept.setOnClickListener {
            Toast.makeText(this, "Permiso salud aceptado", Toast.LENGTH_SHORT).show()
        }

        saludCancel.setOnClickListener {
            Toast.makeText(this, "Permiso salud rechazado", Toast.LENGTH_SHORT).show()
        }

        val personalAccept = findViewById<ImageView>(R.id.aceptPersonal)
        val personalCancel = findViewById<ImageView>(R.id.cancelPersonal)

        personalAccept.setOnClickListener {
            Toast.makeText(this, "Permiso personal aceptado", Toast.LENGTH_SHORT).show()
        }

        personalCancel.setOnClickListener {
            Toast.makeText(this, "Permiso personal rechazado", Toast.LENGTH_SHORT).show()
        }

        val estudioAccept = findViewById<ImageView>(R.id.aceptEstudio)
        val estudioCancel = findViewById<ImageView>(R.id.cancelEstudio)

        estudioAccept.setOnClickListener {
            Toast.makeText(this, "Permiso estudio aceptado", Toast.LENGTH_SHORT).show()
        }

        estudioCancel.setOnClickListener {
            Toast.makeText(this, "Permiso estudio rechazado", Toast.LENGTH_SHORT).show()
        }
    }
}









