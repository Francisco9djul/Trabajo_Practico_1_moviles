package com.example.tp1_g6
import android.view.View
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
class BienvenidaActivity : AppCompatActivity() {

    private lateinit var textViewSaludo: TextView
    private lateinit var imageViewLogo: ImageView
    private lateinit var buttonCerrarSesion: Button
    private lateinit var buttonSalir: Button
    private lateinit var spinnerPlataforma: Spinner
    private lateinit var checkBoxProgramacion: CheckBox
    private lateinit var checkBoxRedes: CheckBox
    private lateinit var checkBoxSeguridad: CheckBox
    private lateinit var checkBoxHardware: CheckBox
    private lateinit var checkBoxOtra: CheckBox
    private lateinit var editTextOtraPreferencia: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        textViewSaludo = findViewById(R.id.textViewSaludo)
        imageViewLogo = findViewById(R.id.imageViewLogo)
        buttonCerrarSesion = findViewById(R.id.buttonCerrarSesion)
        buttonSalir = findViewById(R.id.buttonSalir)
        spinnerPlataforma = findViewById(R.id.spinnerPlataforma)
        checkBoxProgramacion = findViewById(R.id.checkBoxProgramacion)
        checkBoxRedes = findViewById(R.id.checkBoxRedes)
        checkBoxSeguridad = findViewById(R.id.checkBoxSeguridad)
        checkBoxHardware = findViewById(R.id.checkBoxHardware)
        checkBoxOtra = findViewById(R.id.checkBoxOtra)
        editTextOtraPreferencia = findViewById(R.id.editTextOtraPreferencia)

        // Obtener el nombre del usuario desde el Intent
        val usuario = intent.getStringExtra("usuario")
        textViewSaludo.text = "¡Bienvenido, $usuario!"

        // Configuración del Spinner de plataformas
        val plataformas = arrayOf("Selecciona una plataforma", "Android", "iOS")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, plataformas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPlataforma.adapter = adapter

        spinnerPlataforma.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    1 -> {
                    imageViewLogo.setImageResource(R.drawable.logo_android) // Asegúrate de tener este recurso
                    }
                    2 -> {
                    imageViewLogo.setImageResource(R.drawable.logo_ios) // Asegúrate de tener este recurso
                }
            }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {}
        }

        // Mostrar/Ocultar campo "Otra preferencia"
        checkBoxOtra.setOnCheckedChangeListener { _, isChecked ->
            editTextOtraPreferencia.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        buttonCerrarSesion.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        buttonSalir.setOnClickListener {
            finishAffinity() // Cierra la app completamente
        }
    }
}
