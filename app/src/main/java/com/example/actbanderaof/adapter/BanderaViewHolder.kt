package com.example.actbanderaof.adapter

import android.view.ContextMenu
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.actbanderaof.R
import com.example.actbanderaof.databinding.ItemBanderaBinding
import com.example.actbanderaof.model.Bandera

class BanderaViewHolder(view:View): ViewHolder(view), View.OnCreateContextMenuListener {

    //dira como se pintan los elementos
    //recibe com parametro una vista que hereda de viewholder

    val binding = ItemBanderaBinding.bind(view)
    //asociar lo que hemos creado de itembandera ocn la vista

    lateinit var bandera: Bandera

    init {
        // Registrar el ContextMenu para cada item
        itemView.setOnCreateContextMenuListener(this)
    }

    fun render(item: Bandera, onClickListener: (Bandera) -> Unit) {
        //decir donde y como pintarla
        binding.tvnombre.text = item.nombre
        binding.tvdescripcion.text = item.descripcion
        binding.ivbandera.setImageResource(item.photo)
       itemView.setOnClickListener {
          //para que sea a toda la celda

           onClickListener(item)
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        menu.add(adapterPosition, R.id.context_menu_edit, 0, "Editar")
        menu.add(adapterPosition, R.id.context_menu_delete, 1, "Eliminar")
    }


}