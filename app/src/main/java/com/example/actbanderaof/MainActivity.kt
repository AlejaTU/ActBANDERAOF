package com.example.actbanderaof

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.actbanderaof.activities.EditarBanderaActivity
import com.example.actbanderaof.adapter.BanderaAdapter
import com.example.actbanderaof.databinding.ActivityMainBinding
import com.example.actbanderaof.model.Bandera
import com.example.actbanderaof.provider.BanderaProvider

class MainActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityMainBinding

    //lista con banderas
    private lateinit var listaBanderas: MutableList<Bandera>

    //layoutmanager
    private lateinit var layoutManager: LinearLayoutManager

    private lateinit var adapter: BanderaAdapter
    private  val EDITAR_BANDERA_REQUEST_CODE = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //lista cargarla
        listaBanderas = BanderaProvider.cargarLista(this)
        layoutManager = LinearLayoutManager(this)
        binding.rvbanderas.layoutManager = layoutManager

        //con el adapter
        adapter = BanderaAdapter(listaBanderas){bandera -> onMenuItemSelected(bandera)}
        //pasar ese adapter a recycler biew
        binding.rvbanderas.adapter = adapter


    }

    private fun onMenuItemSelected(bandera: Bandera) {

        Toast.makeText(this, "Yo soy de ${bandera.nombre}", Toast.LENGTH_SHORT).show()
    }

    //menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_reload -> {
                // recargar
                listaBanderas.clear()
                listaBanderas.addAll(BanderaProvider.cargarLista(this))
                adapter.notifyDataSetChanged() // Notificar cambios al adaptador
                true
            }
            R.id.action_clear -> {
                // limpiar la lista
                listaBanderas.clear()
                adapter.notifyDataSetChanged() // Notificar cambios al adaptador
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val position = item.groupId // Recupera la posición del ítem seleccionado
        return when (item.itemId) {
            R.id.context_menu_edit -> {
                editarBandera(position)
                true
            }
            R.id.context_menu_delete -> {
                eliminarBandera(position)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
    private fun eliminarBandera(position: Int) {
        val bandera = listaBanderas[position]

        // Crear el AlertDialog
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmación")
        builder.setMessage("¿Estás seguro de que quieres eliminar la bandera de ${bandera.nombre}?")

        // Botón "Sí"
        builder.setPositiveButton("Sí") { _, _ ->
            // Eliminar la bandera si se confirma
            listaBanderas.removeAt(position)
            adapter.notifyItemRemoved(position)
            Toast.makeText(this, "Bandera eliminada", Toast.LENGTH_SHORT).show()
        }

        // Botón "No"
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss() // Cerrar el diálogo sin hacer nada
        }

        // Mostrar el diálogo
        builder.show()
    }


    private fun editarBandera(position: Int) {
        val bandera = listaBanderas[position]
        val intent = Intent(this, EditarBanderaActivity::class.java).apply {
            putExtra("nombre", bandera.nombre)
            putExtra("photo", bandera.photo)
            putExtra("posicion", position)
        }
        startActivityForResult(intent, EDITAR_BANDERA_REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == EDITAR_BANDERA_REQUEST_CODE && resultCode == RESULT_OK) {
            val nuevoNombre = data?.getStringExtra("nuevo_nombre") ?: return
            val position = data.getIntExtra("posicion", -1)

            if (position != -1) {
                listaBanderas[position] = listaBanderas[position].copy(nombre = nuevoNombre)
                adapter.notifyItemChanged(position)
            }
        }
    }

}