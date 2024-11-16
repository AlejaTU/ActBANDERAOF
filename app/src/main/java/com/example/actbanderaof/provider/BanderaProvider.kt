package com.example.actbanderaof.provider

import android.content.Context
import com.example.actbanderaof.R
import com.example.actbanderaof.model.Bandera


class BanderaProvider {

    companion object {
        fun cargarLista(context: Context): MutableList<Bandera> {
            return mutableListOf(
                Bandera(
                    "Andalucia",
                    context.getString(R.string.andalucia_frase),
                    R.drawable.andalucia
                ),
                Bandera(
                    "Aragon",
                    context.getString(R.string.aragon_frase),
                    R.drawable.aragon
                ),
                Bandera(
                    "Asturias",
                    context.getString(R.string.asturias_frase),
                    R.drawable.asturias
                ),
                Bandera(
                    "Baleares",
                    context.getString(R.string.baleares_frase),
                    R.drawable.baleares
                ),
                Bandera(
                    "Canarias",
                    context.getString(R.string.canarias_frase),
                    R.drawable.canarias
                ),
                Bandera(
                    "Cantabria",
                    context.getString(R.string.cantabria_frase),
                    R.drawable.cantabria
                ),
                Bandera(
                    "Castilla y Leon",
                    context.getString(R.string.castilla_leon_frase),
                    R.drawable.castillaleon
                ),
                Bandera(
                    "Castilla y la Mancha",
                    context.getString(R.string.castilla_mancha_frase),
                    R.drawable.castillamancha
                ),
                Bandera(
                    "Catalunya",
                    context.getString(R.string.catalunya_frase),
                    R.drawable.catalunya
                ),
                Bandera(
                    "Ceuta",
                    context.getString(R.string.ceuta_frase),
                    R.drawable.ceuta
                ),
                Bandera(
                    "Extremadura",
                    context.getString(R.string.extremadura_frase),
                    R.drawable.extremadura
                ),
                Bandera(
                    "Galicia",
                    context.getString(R.string.galicia_frase),
                    R.drawable.galicia
                ),
                Bandera(
                    "La Rioja",
                    context.getString(R.string.la_rioja_frase),
                    R.drawable.larioja
                ),
                Bandera(
                    "Madrid",
                    context.getString(R.string.madrid_frase),
                    R.drawable.madrid
                ),
                Bandera(
                    "Melilla",
                    context.getString(R.string.melilla_frase),
                    R.drawable.melilla
                ),
                Bandera(
                    "Murcia",
                    context.getString(R.string.murcia_frase),
                    R.drawable.murcia
                ),
                Bandera(
                    "Navarra",
                    context.getString(R.string.navarra_frase),
                    R.drawable.navarra
                ),
                Bandera(
                    "Pais Vasco",
                    context.getString(R.string.pais_vasco_frase),
                    R.drawable.paisvasco
                ),
                Bandera(
                    "Valencia",
                    context.getString(R.string.valencia_frase),
                    R.drawable.valencia
                ),
            )
        }
    }
}