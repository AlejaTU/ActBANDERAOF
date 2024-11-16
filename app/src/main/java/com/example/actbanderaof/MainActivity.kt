package com.example.actbanderaof

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
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
        listaBanderas = BanderaProvider.cargarLista()
        layoutManager = LinearLayoutManager(this)
        binding.rvbanderas.layoutManager = layoutManager

        //con el adapter
        adapter = BanderaAdapter(listaBanderas)
        //pasar ese adapter a recycler biew
        binding.rvbanderas.adapter = adapter


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
                listaBanderas.addAll(BanderaProvider.cargarLista())
                true
            }
            R.id.action_clear -> {
                // limpiar la lista
                listaBanderas.clear()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}