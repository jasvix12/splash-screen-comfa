package com.aaa.inicio11

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PermisosActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisos)


        val fabButton = findViewById<ImageView>(R.id.homeIcon)
        val iconBook = findViewById<ImageView>(R.id.pendingIcon)
        val iconShoe = findViewById<ImageView>(R.id.mapIcon)
        val iconApple = findViewById<ImageView>(R.id.locationIcon)
        val iconUser = findViewById<ImageView>(R.id.profileIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon) // El ícono de "más"


        fabButton.setOnClickListener {
            Toast.makeText(this, "Home Icon Clicked", Toast.LENGTH_SHORT).show()
        }

        iconBook.setOnClickListener {
            Toast.makeText(this, "Pending Icon Clicked", Toast.LENGTH_SHORT).show()
        }

        iconShoe.setOnClickListener {
            Toast.makeText(this, "Map Icon Clicked", Toast.LENGTH_SHORT).show()
        }

        iconApple.setOnClickListener {
            Toast.makeText(this, "Location Icon Clicked", Toast.LENGTH_SHORT).show()
        }

        iconUser.setOnClickListener {
            Toast.makeText(this, "Profile Icon Clicked", Toast.LENGTH_SHORT).show()
        }

        // Configurar el onClickListener para el ícono de "más"
        plusIcon.setOnClickListener {
            // Crear el Intent para navegar a la actividad de Permisos
            val intent = Intent(this, PermisosActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Más Icon Clicked, navegando a Permisos", Toast.LENGTH_SHORT).show()
        }
    }
}

