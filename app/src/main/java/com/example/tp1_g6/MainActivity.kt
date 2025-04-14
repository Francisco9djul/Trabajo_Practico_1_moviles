package com.example.tp1_g6


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Abrir directamente LoginActivity cuando la aplicación se inicie
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)


    }
}