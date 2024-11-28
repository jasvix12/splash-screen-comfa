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

        // Referencias del header
        val profileIcon = findViewById<ImageView>(R.id.profileIcon)
        profileIcon.setOnClickListener {
            Toast.makeText(this, "Perfil clicado", Toast.LENGTH_SHORT).show()
        }

        // Referencias a los spinners
        val spinnerTipoSolicitud = findViewById<Spinner>(R.id.spinnerTipoSolicitud)
        val spinnerSeccionDestino = findViewById<Spinner>(R.id.spinnerSeccionDestino)
        val spinnerHoraSalida = findViewById<Spinner>(R.id.spinnerHoraSalida)
        val spinnerHoraEntrada = findViewById<Spinner>(R.id.spinnerHoraEntrada)

        // Aquí puedes configurar adaptadores para los spinners si es necesario
        // Por ejemplo, usando ArrayAdapter para cargar datos en los spinners.

        // Referencias del footer
        val aceptIcon = findViewById<ImageView>(R.id.aceptIcon)
        val pendingIcon = findViewById<ImageView>(R.id.pendingIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val approvedIcon = findViewById<ImageView>(R.id.approvedIcon)
        val locationIcon = findViewById<ImageView>(R.id.locationIcon)

        // Manejar eventos de clic en cada ícono
        aceptIcon.setOnClickListener {
            // Lógica para navegar a Aceptar Permisos
            val intent = Intent(this, AceptPermisosActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Navegando a Aceptar Permisos", Toast.LENGTH_SHORT).show()
        }

        pendingIcon.setOnClickListener {
            // Lógica para navegar a Pendientes
            val intent = Intent(this, PendientesActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Navegando a Pendientes", Toast.LENGTH_SHORT).show()
        }

        plusIcon.setOnClickListener {
            // Lógica para crear un nuevo permiso
            Toast.makeText(this, "Crear nuevo permiso (Lógica aún no implementada)", Toast.LENGTH_SHORT).show()
        }

        approvedIcon.setOnClickListener {
            // Lógica para navegar a Aprobados
            val intent = Intent(this, AprobadoActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Navegando a Aprobados", Toast.LENGTH_SHORT).show()
        }

        locationIcon.setOnClickListener {
            // Lógica para mostrar la ubicación actual
            val intent = Intent(this, UbicacionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Navegando a Ubicación", Toast.LENGTH_SHORT).show()
        }
    }
}



