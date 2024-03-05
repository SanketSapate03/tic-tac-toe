package com.example.tictactoeSample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.tictactoeSample.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // 1. making delayed
        Handler().postDelayed({
            val iMain= Intent(this, MainActivity::class.java)
            finish()
            startActivity(iMain)
        }, 4000) // delayed by 4s
    }
}