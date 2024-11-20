package com.aaa.inicio11

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val splashImage: ImageView = findViewById(R.id.SplashScreenImage)
        val splashText: TextView = findViewById(R.id.SplashScreenText)

        // Hacemos el logo invisible al inicio
        splashImage.alpha = 0f
        splashText.alpha = 0f

        // Animación de expansión del logo
        val scaleUpX = ObjectAnimator.ofFloat(splashImage, "scaleX", 0f, 1f)
        val scaleUpY = ObjectAnimator.ofFloat(splashImage, "scaleY", 0f, 1f)
        val fadeInLogo = ObjectAnimator.ofFloat(splashImage, "alpha", 0f, 1f)

        // Duración de la animación del logo
        scaleUpX.duration = 2000
        scaleUpY.duration = 2000
        fadeInLogo.duration = 2000

        // Ejecutar animación del logo
        scaleUpX.start()
        scaleUpY.start()
        fadeInLogo.start()

        // Esperamos que el logo termine de animarse antes de mostrar el texto
        Handler().postDelayed({
            splashText.visibility = View.VISIBLE
            val fadeInText = ObjectAnimator.ofFloat(splashText, "alpha", 0f, 1f)
            fadeInText.duration = 1500
            fadeInText.start()

            // Mostrar cada letra de "Comfacauca" con un pequeño retraso
            showTextLetterByLetter(splashText)
        }, 2000) // Esperamos 2 segundos para mostrar el texto después del logo

        // Después de completar la animación del texto, pasamos al siguiente Activity
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000) // Esperamos 5 segundos en total (2 de animación + 3 adicionales para ver el texto completo)
    }

    // Función para mostrar el texto letra por letra
    private fun showTextLetterByLetter(textView: TextView) {
        val fullText = "Comfacauca"
        val delay = 150L // Retraso entre cada letra

        for (i in 0 until fullText.length) {
            Handler().postDelayed({
                textView.text = fullText.substring(0, i + 1)
            }, delay * i)
        }
    }
}






