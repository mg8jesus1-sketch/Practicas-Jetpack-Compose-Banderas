package com.example.banderas.Screen

import android.os.Bundle
import android.view.View
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

        // Pantalla (raíz) y contenedor de la bandera
        val raiz = ConstraintLayout(this).apply { id = View.generateViewId() }
        val bandera = ConstraintLayout(this).apply { id = View.generateViewId() }

        // Franjas
        val franjaAmarilla = View(this).apply {
            id = View.generateViewId()
            setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.colombia_amarillo))
        }
        val franjaAzul = View(this).apply {
            id = View.generateViewId()
            setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.colombia_azul))
        }
        val franjaRoja = View(this).apply {
            id = View.generateViewId()
            setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.colombia_rojo))
        }

        bandera.addView(franjaAmarilla)
        bandera.addView(franjaAzul)
        bandera.addView(franjaRoja)
        raiz.addView(bandera)

        // ---- Constraints de la bandera: franjas 2:1:1 con cadena vertical ----
        ConstraintSet().apply {
            clone(bandera)

            for (franja in listOf(franjaAmarilla, franjaAzul, franjaRoja)) {
                constrainWidth(franja.id, ConstraintSet.MATCH_CONSTRAINT)
                constrainHeight(franja.id, ConstraintSet.MATCH_CONSTRAINT)
                connect(franja.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
                connect(franja.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            }

            createVerticalChain(
                ConstraintSet.PARENT_ID, ConstraintSet.TOP,
                ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM,
                intArrayOf(franjaAmarilla.id, franjaAzul.id, franjaRoja.id),
                floatArrayOf(2f, 1f, 1f), // proporción 2:1:1
                ConstraintSet.CHAIN_SPREAD
            )

            applyTo(bandera)
        }

        // ---- Constraints de la raíz: bandera 3:2 centrada ----
        ConstraintSet().apply {
            clone(raiz)
            constrainWidth(bandera.id, ConstraintSet.MATCH_CONSTRAINT)
            constrainHeight(bandera.id, ConstraintSet.MATCH_CONSTRAINT)
            setDimensionRatio(bandera.id, "3:2") // proporción 2:3 (alto:ancho)
            connect(bandera.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, margen)
            connect(bandera.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, margen)
            connect(bandera.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, margen)
            connect(bandera.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, margen)
            applyTo(raiz)
        }

        return raiz
    }
}