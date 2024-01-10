package com.example.appdia4

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.appdia4.databinding.ActivityMainBinding
import kotlin.arrayOf as arrayOf1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        installSplashScreen()
        setContentView(R.layout.activity_main)


        val SPLASH_SCREEN: Long = 5000

        val topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        val iv1: ImageView = binding.iv1
        val tv1: TextView = binding.tv1
        val tv2: TextView = binding.tv2

        val scaleX = ObjectAnimator.ofFloat(iv1, View.SCALE_X, 1.0f, 0.6f)
        val scaleY = ObjectAnimator.ofFloat(iv1, View.SCALE_Y, 1.0f, 0.6f)

        val fadeIn = ObjectAnimator.ofFloat(iv1, View.ALPHA, 0f, 1f)
        fadeIn.duration = 1000

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(scaleX, scaleY, fadeIn)
        animatorSet.startDelay = 100
        animatorSet.duration = 1500

        animatorSet.start()

        iv1.startAnimation(topAnim)
        tv1.startAnimation(bottomAnim)
        tv2.startAnimation(bottomAnim)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN)
    }
}