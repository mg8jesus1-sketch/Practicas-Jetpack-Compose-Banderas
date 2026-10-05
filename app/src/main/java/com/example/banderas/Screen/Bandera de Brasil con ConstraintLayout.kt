package com.example.banderas.Screen

import android.graphics.Path
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.PathShape
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.banderas.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(crearBandera())
    }

    private fun crearBandera(): ConstraintLayout {
        val margen = (16 * resources.displayMetrics.density).toInt()

        // Pantalla (raíz) y contenedor de la bandera (fondo verde)
        val raiz = ConstraintLayout(this).apply { id = View.generateViewId() }
        val bandera = ConstraintLayout(this).apply {
            id = View.generateViewId()
            setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.brasil_verde))
        }

        // Rombo amarillo: vértices a 1.7 de los bordes, sobre una bandera de 20 x 14
        // (se dibuja en un lienzo de 200 x 140 y se escala al tamaño de la bandera)
        val rombo = View(this).apply {
            id = View.generateViewId()
            val path = Path().apply {
                moveTo(17f, 70f)    // izquierda
                lineTo(100f, 17f)   // arriba
                lineTo(183f, 70f)   // derecha
                lineTo(100f, 123f)  // abajo
                close()
            }
            background = ShapeDrawable(PathShape(path, 200f, 140f)).apply {
                paint.color = ContextCompat.getColor(this@MainActivity, R.color.brasil_amarillo)
            }
        }

        // Círculo azul: diámetro de 7 sobre 20 de ancho
        val circulo = View(this).apply {
            id = View.generateViewId()
            background = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(ContextCompat.getColor(this@MainActivity, R.color.brasil_azul))
            }
        }

        // Esfera (la imagen la agregas después, va encima del círculo azul)
        val esfera = ImageView(this).apply {
            id = View.generateViewId()
            scaleType = ImageView.ScaleType.FIT_CENTER
            // setImageResource(R.drawable.tu_imagen)
            contentDescription = "Esfera celeste de Brasil"
        }

        bandera.addView(rombo)
        bandera.addView(circulo)
        bandera.addView(esfera)
        raiz.addView(bandera)

        // ---- Constraints de la bandera ----
        ConstraintSet().apply {
            clone(bandera)

            // Rombo: ocupa toda la bandera (el dibujo ya trae las proporciones)
            constrainWidth(rombo.id, ConstraintSet.MATCH_CONSTRAINT)
            constrainHeight(rombo.id, ConstraintSet.MATCH_CONSTRAINT)
            connect(rombo.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(rombo.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            connect(rombo.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
            connect(rombo.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)

            // Círculo y esfera: centrados, 35% del ancho (7/20) y cuadrados
            for (vista in listOf(circulo, esfera)) {
                constrainWidth(vista.id, ConstraintSet.MATCH_CONSTRAINT)
                constrainHeight(vista.id, ConstraintSet.MATCH_CONSTRAINT)
                constrainPercentWidth(vista.id, 0.35f)
                setDimensionRatio(vista.id, "1:1")
                connect(vista.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
                connect(vista.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
                connect(vista.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
                connect(vista.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            }

            applyTo(bandera)
        }

        // ---- Constraints de la raíz: bandera 10:7 centrada ----
        ConstraintSet().apply {
            clone(raiz)
            constrainWidth(bandera.id, ConstraintSet.MATCH_CONSTRAINT)
            constrainHeight(bandera.id, ConstraintSet.MATCH_CONSTRAINT)
            setDimensionRatio(bandera.id, "10:7") // proporción 7:10 (alto:ancho)
            connect(bandera.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, margen)
            connect(bandera.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, margen)
            connect(bandera.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, margen)
            connect(bandera.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, margen)
            applyTo(raiz)
        }

        return raiz
    }
}