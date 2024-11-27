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
        val iconShoe = findViewById<ImageView>(R.id.approvedIcon)
        val iconApple = findViewById<ImageView>(R.id.locationIcon)
        val iconUser = findViewById<ImageView>(R.id.profileIcon)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)

        fabButton.setOnClickListener {
            val intent = Intent(this, AceptPermisosActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Acept permiso", Toast.LENGTH_SHORT).show()
        }

        iconBook.setOnClickListener {
            val intent = Intent(this, PendientesActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Pending Icon Clicked", Toast.LENGTH_SHORT).show()
        }

        iconShoe.setOnClickListener {
            val intent = Intent(this, AprovadaActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Approved Icon Clicked", Toast.LENGTH_SHORT).show()
        }

        iconApple.setOnClickListener {
            Toast.makeText(this, "Location Icon Clicked", Toast.LENGTH_SHORT).show()
        }

        iconUser.setOnClickListener {
            Toast.makeText(this, "Profile Icon Clicked", Toast.LENGTH_SHORT).show()
        }

        plusIcon.setOnClickListener {
            val intent = Intent(this, PermisosActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Ya estás en Permisos", Toast.LENGTH_SHORT).show()
        }
    }
}


