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


        splashImage.alpha = 0f
        splashText.alpha = 0f


        val scaleUpX = ObjectAnimator.ofFloat(splashImage, "scaleX", 0f, 1f)
        val scaleUpY = ObjectAnimator.ofFloat(splashImage, "scaleY", 0f, 1f)
        val fadeInLogo = ObjectAnimator.ofFloat(splashImage, "alpha", 0f, 1f)


        scaleUpX.duration = 2000
        scaleUpY.duration = 2000
        fadeInLogo.duration = 2000


        scaleUpX.start()
        scaleUpY.start()
        fadeInLogo.start()


        Handler().postDelayed({
            splashText.visibility = View.VISIBLE
            val fadeInText = ObjectAnimator.ofFloat(splashText, "alpha", 0f, 1f)
            fadeInText.duration = 1500
            fadeInText.start()


            showTextLetterByLetter(splashText)
        }, 2000)


        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }


    private fun showTextLetterByLetter(textView: TextView) {
        val fullText = "Comfacauca"
        val delay = 150L

        for (i in 0 until fullText.length) {
            Handler().postDelayed({
                textView.text = fullText.substring(0, i + 1)
            }, delay * i)
        }
    }
}






