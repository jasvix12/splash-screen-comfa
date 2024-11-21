package com.aaa.inicio11

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val googleButton: LinearLayout = findViewById(R.id.googleButton)

        googleButton.setOnClickListener {
            // Acción al hacer clic en el botón
            // Por ejemplo, pasar a la siguiente actividad
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Cierra la actividad actual
        }
    }
}

