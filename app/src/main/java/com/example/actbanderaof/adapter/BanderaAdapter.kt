package com.example.actbanderaof.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.actbanderaof.R
import com.example.actbanderaof.model.Bandera

class BanderaAdapter (private val lista: List<Bandera>, private val onClickListener: (Bandera) -> Unit): RecyclerView.Adapter<BanderaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BanderaViewHolder {
//definir la celda
    val layoutInflater = LayoutInflater.from(parent.context)
    return BanderaViewHolder(layoutInflater.inflate(R.layout.item_bandera, parent, false))


    }

    override fun onBindViewHolder(holder: BanderaViewHolder, position: Int) {
       //en la posicion de la lista va a pasar el elemento que tenga en esa posicoin y decirle al holder que ponte esa celda
        val item = lista[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}


