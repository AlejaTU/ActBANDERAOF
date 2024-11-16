package com.example.actbanderaof.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.actbanderaof.databinding.ItemBanderaBinding
import com.example.actbanderaof.model.Bandera

class BanderaViewHolder(view:View): ViewHolder(view) {

    //dira como se pintan los elementos
    //recibe com parametro una vista que hereda de viewholder

    val binding = ItemBanderaBinding.bind(view)
    //asociar lo que hemos creado de itembandera ocn la vista

    lateinit var bandera: Bandera

    fun render(item: Bandera) {
        //decir donde y como pintarla
        binding.tvnombre.text = item.nombre
        binding.tvdescripcion.text = item.descripcion
        binding.ivbandera.setImageResource(item.photo)
    }


}