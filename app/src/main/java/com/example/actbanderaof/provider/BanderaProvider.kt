package com.example.actbanderaof.provider

import com.example.actbanderaof.R
import com.example.actbanderaof.model.Bandera


public class BanderaProvider {

    companion object{
        //para que sea accesible esa funcion desde fuera???
        //proporcionar listado de banderas
        fun cargarLista():MutableList<Bandera> {
            return mutableListOf<Bandera>(
                Bandera(
                    "Andalucia",
                    "Tierra Sur",
                    R.drawable.andalucia

                ),
                Bandera(
                    "Aragon",
                    "Tierra Norte",
                    R.drawable.aragon

                ),
                Bandera(
                    "Asturias",
                    "Tierra Norte",
                    R.drawable.asturias

                ),
                Bandera(
                    "Baleares",
                    "Tierra Norte",
                    R.drawable.baleares

                ),
                Bandera(
                    "Canarias",
                    "Tierra Norte",
                    R.drawable.canarias

                ),
                Bandera(
                    "Cantabria",
                    "Tierra Norte",
                    R.drawable.cantabria

                ),
                Bandera(
                    "Castilla y Leon",
                    "Tierra Norte",
                    R.drawable.castillaleon

                ),
                Bandera(
                    "Castilla y la Mancha",
                    "Tierra Norte",
                    R.drawable.castillamancha

                ),
                Bandera(
                    "Catalunya",
                    "Tierra Norte",
                    R.drawable.catalunya

                ),
                Bandera(
                    "Ceuta",
                    "Tierra Norte",
                    R.drawable.ceuta

                ),
                Bandera(
                    "Extremadura",
                    "Tierra Norte",
                    R.drawable.extremadura

                ),
                Bandera(
                    "Galicia",
                    "Tierra Norte",
                    R.drawable.galicia

                ),
                Bandera(
                    "La Rioja",
                    "Tierra Norte",
                    R.drawable.larioja

                ),
                Bandera(
                    "Madrid",
                    "Tierra Norte",
                    R.drawable.madrid

                ),
                Bandera(
                    "Melilla",
                    "Tierra Norte",
                    R.drawable.melilla

                ),
                Bandera(
                    "Murcia",
                    "Tierra Norte",
                    R.drawable.murcia

                ),
                Bandera(
                    "Navarra",
                    "Tierra Norte",
                    R.drawable.navarra

                ),
                Bandera(
                    "Pais Vasco",
                    "Tierra Norte",
                    R.drawable.paisvasco

                ),
                Bandera(
                    "Valencia",
                    "Tierra Norte",
                    R.drawable.valencia

                ),

                )


        }
    }
}
