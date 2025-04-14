package com.example.tp1_g6

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val editTextRepetir = findViewById<EditText>(R.id.editTextRepetir)
        val buttonRegistrar = findViewById<Button>(R.id.buttonRegistrar)

        buttonRegistrar.setOnClickListener {
            val nombre = editTextNombre.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString()
            val repetir = editTextRepetir.text.toString()

            if (nombre.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Nombre y Email no pueden estar vacíos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.length < 6) {
                Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != repetir) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Aquí podrías guardar el usuario si quisieras
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

            // Volver al LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}