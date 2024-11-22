package com.aaa.inicio11

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PermisosActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisos)


        val fabButton = findViewById<ImageView>(R.id.fabButton)
        val iconBook = findViewById<ImageView>(R.id.icon_book)
        val iconShoe = findViewById<ImageView>(R.id.icon_shoe)
        val iconApple = findViewById<ImageView>(R.id.icon_apple)
        val iconUser = findViewById<ImageView>(R.id.icon_user)


        fabButton.setOnClickListener {
            Toast.makeText(this, "FAB Button Clicked", Toast.LENGTH_SHORT).show()

        }

        iconBook.setOnClickListener {
            Toast.makeText(this, "Book Icon Clicked", Toast.LENGTH_SHORT).show()

        }

        iconShoe.setOnClickListener {
            Toast.makeText(this, "Shoe Icon Clicked", Toast.LENGTH_SHORT).show()

        }

        iconApple.setOnClickListener {
            Toast.makeText(this, "Apple Icon Clicked", Toast.LENGTH_SHORT).show()

        }

        iconUser.setOnClickListener {
            Toast.makeText(this, "User Icon Clicked", Toast.LENGTH_SHORT).show()

        }
    }
}
