package com.example.actbanderaof.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.actbanderaof.databinding.ActivityEditarBanderaBinding
class EditarBanderaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarBanderaBinding
    private var position: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarBanderaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar los datos del intent
        val nombre = intent.getStringExtra("nombre")
        val photo = intent.getIntExtra("photo", -1)
        position = intent.getIntExtra("posicion", -1)

        // Verificar que los datos son válidos
        if (position == -1 || nombre == null || photo == -1) {
            finish()
            return
        }

        // Mostrar la bandera y el nombre actual
        binding.ivBandera.setImageResource(photo)
        binding.etNombre.hint = nombre

        // Botón Cambiar
        binding.btnGuardar.setOnClickListener {
            val nuevoNombre = binding.etNombre.text.toString().ifEmpty { nombre }
            val resultIntent = Intent().apply {
                putExtra("nuevo_nombre", nuevoNombre)
                putExtra("posicion", position)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        // Botón Cancelar
        binding.btnCancelar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}