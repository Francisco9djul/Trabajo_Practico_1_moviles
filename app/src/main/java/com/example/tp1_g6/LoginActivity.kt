package com.example.tp1_g6
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextUsuario: EditText
    private lateinit var editTextContrasena: EditText
    private lateinit var buttonIngresar: Button
    private lateinit var buttonRegistrarse: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextUsuario = findViewById(R.id.editTextUsuario)
        editTextContrasena = findViewById(R.id.editTextContrasena)
        buttonIngresar = findViewById(R.id.buttonIngresar)
        buttonRegistrarse = findViewById(R.id.buttonRegistrarse)

        buttonIngresar.setOnClickListener {
            val usuario = editTextUsuario.text.toString()
            val contrasena = editTextContrasena.text.toString()

            if (usuario == "Juan Torres" && contrasena == "1234utn") {
                val intent = Intent(this, BienvenidaActivity::class.java)
                intent.putExtra("usuario", usuario)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        buttonRegistrarse.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
}