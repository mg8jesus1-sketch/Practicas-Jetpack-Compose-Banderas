package com.example.banderas.Screen

import android.graphics.Path
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.PathShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.banderas.R
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : AppCompatActivity() {

    private data class Estrella(val vista: View, val fila: Int, val columna: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(crearBandera())
    }

    // Medidas oficiales (altura de la bandera = 1.0, largo = 1.9)
    private val anchoCanton = 0.76f
    private val altoCanton = 7f / 13f   // 7 franjas de 13
    private val diametro = 0.0616f      // diámetro de cada estrella
    private val pasoX = 0.063f          // separación horizontal entre columnas
    private val pasoY = 0.054f          // separación vertical entre filas

    private fun crearBandera(): ConstraintLayout {
        val margen = (16 * resources.displayMetrics.density).toInt()

        val rojo = ContextCompat.getColor(this, R.color.eeuu_rojo)
        val blanco = ContextCompat.getColor(this, R.color.eeuu_blanco)
        val azul = ContextCompat.getColor(this, R.color.eeuu_azul)

        // Pantalla (raíz) y contenedor de la bandera
        val raiz = ConstraintLayout(this).apply { id = View.generateViewId() }
        val bandera = ConstraintLayout(this).apply { id = View.generateViewId() }

        // 13 franjas: la primera y la última son rojas
        val franjas = List(13) { i ->
            View(this).apply {
                id = View.generateViewId()
                setBackgroundColor(if (i % 2 == 0) rojo else blanco)
            }
        }

        // Cantón azul (contenedor de las estrellas)
        val canton = ConstraintLayout(this).apply {
            id = View.generateViewId()
            setBackgroundColor(azul)
        }

        // 50 estrellas: filas impares con 6, filas pares con 5
        val trazado = trazadoEstrella()
        val estrellas = mutableListOf<Estrella>()
        for (fila in 1..9) {
            val columnas = if (fila % 2 == 1) (1..11 step 2) else (2..10 step 2)
            for (columna in columnas) {
                val vista = View(this).apply {
                    id = View.generateViewId()
                    background = ShapeDrawable(PathShape(trazado, 100f, 100f)).apply {
                        paint.color = blanco
                    }
                }
                estrellas.add(Estrella(vista, fila, columna))
            }
        }

        franjas.forEach { bandera.addView(it) }
        estrellas.forEach { canton.addView(it.vista) }
        bandera.addView(canton) // se agrega al final para quedar encima de las franjas
        raiz.addView(bandera)

        // ---- Estrellas dentro del cantón ----
        ConstraintSet().apply {
            clone(canton)
            for (e in estrellas) {
                val id = e.vista.id
                constrainWidth(id, ConstraintSet.MATCH_CONSTRAINT)
                constrainHeight(id, ConstraintSet.MATCH_CONSTRAINT)
                constrainDefaultWidth(id, ConstraintSet.MATCH_CONSTRAINT_PERCENT)
                constrainDefaultHeight(id, ConstraintSet.MATCH_CONSTRAINT_PERCENT)
                constrainPercentWidth(id, diametro / anchoCanton)
                constrainPercentHeight(id, diametro / altoCanton)

                connect(id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
                connect(id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
                connect(id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
                connect(id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)

                // Centro de la estrella -> bias dentro del cantón
                val centroX = pasoX * e.columna
                val centroY = pasoY * e.fila
                setHorizontalBias(id, (centroX - diametro / 2) / (anchoCanton - diametro))
                setVerticalBias(id, (centroY - diametro / 2) / (altoCanton - diametro))
            }
            applyTo(canton)
        }

        // ---- Franjas (cadena vertical 13 x 1) y cantón dentro de la bandera ----
        ConstraintSet().apply {
            clone(bandera)

            for (franja in franjas) {
                constrainWidth(franja.id, ConstraintSet.MATCH_CONSTRAINT)
                constrainHeight(franja.id, ConstraintSet.MATCH_CONSTRAINT)
                connect(franja.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
                connect(franja.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            }

            createVerticalChain(
                ConstraintSet.PARENT_ID, ConstraintSet.TOP,
                ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM,
                franjas.map { it.id }.toIntArray(),
                FloatArray(13) { 1f }, // 13 franjas iguales
                ConstraintSet.CHAIN_SPREAD
            )

            // Cantón: esquina superior izquierda, 40% del ancho y 7/13 del alto
            val id = canton.id
            constrainWidth(id, ConstraintSet.MATCH_CONSTRAINT)
            constrainHeight(id, ConstraintSet.MATCH_CONSTRAINT)
            constrainDefaultWidth(id, ConstraintSet.MATCH_CONSTRAINT_PERCENT)
            constrainDefaultHeight(id, ConstraintSet.MATCH_CONSTRAINT_PERCENT)
            constrainPercentWidth(id, anchoCanton / 1.9f)
            constrainPercentHeight(id, altoCanton)
            connect(id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            connect(id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
            connect(id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            setHorizontalBias(id, 0f)
            setVerticalBias(id, 0f)

            applyTo(bandera)
        }

        // ---- Constraints de la raíz: bandera 19:10 centrada ----
        ConstraintSet().apply {
            clone(raiz)
            constrainWidth(bandera.id, ConstraintSet.MATCH_CONSTRAINT)
            constrainHeight(bandera.id, ConstraintSet.MATCH_CONSTRAINT)
            setDimensionRatio(bandera.id, "19:10") // proporción 10:19 (alto:ancho)
            connect(bandera.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, margen)
            connect(bandera.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, margen)
            connect(bandera.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, margen)
            connect(bandera.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, margen)
            applyTo(raiz)
        }

        return raiz
    }

    // Estrella de 5 puntas dibujada en un lienzo de 100 x 100
    private fun trazadoEstrella(): Path {
        val path = Path()
        for (i in 0 until 10) {
            val radio = if (i % 2 == 0) 50f else 19.1f // radio exterior e interior
            val angulo = Math.toRadians(-90.0 + i * 36.0)
            val x = (50 + radio * cos(angulo)).toFloat()
            val y = (50 + radio * sin(angulo)).toFloat()
            if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
        }
        path.close()
        return path
    }
}