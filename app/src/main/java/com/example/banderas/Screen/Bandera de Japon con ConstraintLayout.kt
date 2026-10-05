package com.example.banderas.Screen

import android.graphics.drawable.GradientDrawable
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

        // Pantalla (raíz) y contenedor de la bandera (fondo blanco)
        val raiz = ConstraintLayout(this).apply { id = View.generateViewId() }
        val bandera = ConstraintLayout(this).apply {
            id = View.generateViewId()
            setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.japon_blanco))
        }

        // Círculo rojo (Hinomaru)
        val circulo = View(this).apply {
            id = View.generateViewId()
            background = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(ContextCompat.getColor(this@MainActivity, R.color.japon_rojo))
            }
        }

        bandera.addView(circulo)
        raiz.addView(bandera)

        // ---- Constraints de la bandera: círculo centrado, diámetro = 3/5 de la altura ----
        ConstraintSet().apply {
            clone(bandera)

            constrainWidth(circulo.id, ConstraintSet.MATCH_CONSTRAINT)
            constrainHeight(circulo.id, ConstraintSet.MATCH_CONSTRAINT)
            constrainPercentHeight(circulo.id, 0.6f) // 3/5 de la altura de la bandera
            setDimensionRatio(circulo.id, "W,1:1")   // el ancho se calcula a partir de la altura (cuadrado)
            connect(circulo.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(circulo.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            connect(circulo.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
            connect(circulo.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)

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