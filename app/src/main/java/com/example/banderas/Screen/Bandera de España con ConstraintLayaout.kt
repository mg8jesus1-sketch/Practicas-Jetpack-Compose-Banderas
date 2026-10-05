package com.example.banderas.Screen

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

        // Pantalla (raíz) y contenedor de la bandera
        val raiz = ConstraintLayout(this).apply { id = View.generateViewId() }
        val bandera = ConstraintLayout(this).apply { id = View.generateViewId() }

        // Franjas
        val franjaSuperior = View(this).apply {
            id = View.generateViewId()
            setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.espana_rojo))
        }
        val franjaCentral = View(this).apply {
            id = View.generateViewId()
            setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.espana_amarillo))
        }
        val franjaInferior = View(this).apply {
            id = View.generateViewId()
            setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.espana_rojo))
        }

        // Escudo
        val escudo = ImageView(this).apply {
            id = View.generateViewId()
            adjustViewBounds = true
            scaleType = ImageView.ScaleType.FIT_CENTER
            setImageResource(R.drawable.espana)
            contentDescription = "Escudo de España"
        }

        bandera.addView(franjaSuperior)
        bandera.addView(franjaCentral)
        bandera.addView(franjaInferior)
        bandera.addView(escudo)
        raiz.addView(bandera)

        // ---- Constraints de la bandera: franjas 1:2:1 con cadena vertical ----
        ConstraintSet().apply {
            clone(bandera)

            for (franja in listOf(franjaSuperior, franjaCentral, franjaInferior)) {
                constrainWidth(franja.id, ConstraintSet.MATCH_CONSTRAINT)
                constrainHeight(franja.id, ConstraintSet.MATCH_CONSTRAINT)
                connect(franja.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
                connect(franja.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            }

            createVerticalChain(
                ConstraintSet.PARENT_ID, ConstraintSet.TOP,
                ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM,
                intArrayOf(franjaSuperior.id, franjaCentral.id, franjaInferior.id),
                floatArrayOf(1f, 2f, 1f), // proporción 1:2:1
                ConstraintSet.CHAIN_SPREAD
            )

            // Escudo: dentro de la franja amarilla, desplazado hacia el asta (izquierda)
            constrainWidth(escudo.id, ConstraintSet.WRAP_CONTENT)
            constrainHeight(escudo.id, ConstraintSet.MATCH_CONSTRAINT)
            constrainPercentHeight(escudo.id, 0.4f)
            connect(escudo.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(escudo.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            setHorizontalBias(escudo.id, 0.10f)
            connect(escudo.id, ConstraintSet.TOP, franjaCentral.id, ConstraintSet.TOP)
            connect(escudo.id, ConstraintSet.BOTTOM, franjaCentral.id, ConstraintSet.BOTTOM)

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