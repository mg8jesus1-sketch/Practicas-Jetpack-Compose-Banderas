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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(crearBandera())
    }

    // Medidas oficiales (altura de la bandera = 2, largo = 3)
    private val anchoCanton = 1f / 3f   // el cantón mide 1 de los 3 de ancho
    private val altoMitad = 0.5f        // cada franja y el cantón miden la mitad del alto
    private val estrellaEnCanton = 0.5f // diámetro de la estrella = 1/2 del lado del cantón

    private fun crearBandera(): ConstraintLayout {
        val margen = (16 * resources.displayMetrics.density).toInt()

        val rojo = ContextCompat.getColor(this, R.color.chile_rojo)
        val blanco = ContextCompat.getColor(this, R.color.chile_blanco)
        val azul = ContextCompat.getColor(this, R.color.chile_azul)

        // Pantalla (raíz) y contenedor de la bandera
        val raiz = ConstraintLayout(this).apply { id = View.generateViewId() }
        val bandera = ConstraintLayout(this).apply { id = View.generateViewId() }

        // Franjas
        val franjaBlanca = View(this).apply {
            id = View.generateViewId()
            setBackgroundColor(blanco)
        }
        val franjaRoja = View(this).apply {
            id = View.generateViewId()
            setBackgroundColor(rojo)
        }

        // Cantón azul (contenedor de la estrella)
        val canton = ConstraintLayout(this).apply {
            id = View.generateViewId()
            setBackgroundColor(azul)
        }

        // Estrella blanca de 5 puntas
        val estrella = View(this).apply {
            id = View.generateViewId()
            background = ShapeDrawable(PathShape(trazadoEstrella(), 100f, 100f)).apply {
                paint.color = blanco
            }
        }

        canton.addView(estrella)
        bandera.addView(franjaRoja)
        bandera.addView(franjaBlanca)
        bandera.addView(canton) // al final para quedar encima de las franjas
        raiz.addView(bandera)

        // ---- Estrella centrada dentro del cantón ----
        ConstraintSet().apply {
            clone(canton)
            val id = estrella.id
            constrainWidth(id, ConstraintSet.MATCH_CONSTRAINT)
            constrainHeight(id, ConstraintSet.MATCH_CONSTRAINT)
            constrainDefaultWidth(id, ConstraintSet.MATCH_CONSTRAINT_PERCENT)
            constrainDefaultHeight(id, ConstraintSet.MATCH_CONSTRAINT_PERCENT)
            constrainPercentWidth(id, estrellaEnCanton)
            constrainPercentHeight(id, estrellaEnCanton)
            connect(id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            connect(id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
            connect(id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            setHorizontalBias(id, 0.5f)
            setVerticalBias(id, 0.5f)
            applyTo(canton)
        }

        // ---- Franjas y cantón dentro de la bandera ----
        ConstraintSet().apply {
            clone(bandera)

            // Franja roja: mitad inferior, todo el ancho
            var id = franjaRoja.id
            constrainWidth(id, ConstraintSet.MATCH_CONSTRAINT)
            constrainHeight(id, ConstraintSet.MATCH_CONSTRAINT)
            constrainDefaultHeight(id, ConstraintSet.MATCH_CONSTRAINT_PERCENT)
            constrainPercentHeight(id, altoMitad)
            connect(id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            connect(id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)

            // Franja blanca: mitad superior, a la derecha del cantón (2/3 del ancho)
            id = franjaBlanca.id
            constrainWidth(id, ConstraintSet.MATCH_CONSTRAINT)
            constrainHeight(id, ConstraintSet.MATCH_CONSTRAINT)
            constrainDefaultWidth(id, ConstraintSet.MATCH_CONSTRAINT_PERCENT)
            constrainDefaultHeight(id, ConstraintSet.MATCH_CONSTRAINT_PERCENT)
            constrainPercentWidth(id, 1f - anchoCanton)
            constrainPercentHeight(id, altoMitad)
            connect(id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            connect(id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)

            // Cantón: esquina superior izquierda, 1/3 del ancho y 1/2 del alto (cuadrado)
            id = canton.id
            constrainWidth(id, ConstraintSet.MATCH_CONSTRAINT)
            constrainHeight(id, ConstraintSet.MATCH_CONSTRAINT)
            constrainDefaultWidth(id, ConstraintSet.MATCH_CONSTRAINT_PERCENT)
            constrainDefaultHeight(id, ConstraintSet.MATCH_CONSTRAINT_PERCENT)
            constrainPercentWidth(id, anchoCanton)
            constrainPercentHeight(id, altoMitad)
            connect(id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)

            applyTo(bandera)
        }

        // ---- Constraints de la raíz: bandera 3:2 centrada ----
        ConstraintSet().apply {
            clone(raiz)
            constrainWidth(bandera.id, ConstraintSet.MATCH_CONSTRAINT)
            constrainHeight(bandera.id, ConstraintSet.MATCH_CONSTRAINT)
            setDimensionRatio(bandera.id, "3:2") // ancho:alto
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