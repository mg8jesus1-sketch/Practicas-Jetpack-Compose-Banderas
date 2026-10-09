package com.example.banderas.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

private fun estrella(cx: Float, cy: Float, r: Float): Path {
    val path = Path()
    path.moveTo(cx, cy - r)
    path.lineTo(cx + 0.225f * r, cy - 0.309f * r)
    path.lineTo(cx + 0.951f * r, cy - 0.309f * r)
    path.lineTo(cx + 0.363f * r, cy + 0.118f * r)
    path.lineTo(cx + 0.588f * r, cy + 0.809f * r)
    path.lineTo(cx, cy + 0.382f * r)
    path.lineTo(cx - 0.588f * r, cy + 0.809f * r)
    path.lineTo(cx - 0.363f * r, cy + 0.118f * r)
    path.lineTo(cx - 0.951f * r, cy - 0.309f * r)
    path.lineTo(cx - 0.225f * r, cy - 0.309f * r)
    path.close()
    return path
}

@Composable
fun BanderaPapuaNuevaGuinea(modifier: Modifier = Modifier) {
    val rojo = colorResource(R.color.rojo)
    val negro = colorResource(R.color.negro)
    val amarillo = colorResource(R.color.amarillo)
    val blanco = colorResource(R.color.blanco)

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(4f / 3f)
    ) {
        val w = size.width
        val h = size.height

        drawRect(color = negro)

        val triangulo = Path()
        triangulo.moveTo(0f, 0f)
        triangulo.lineTo(w, 0f)
        triangulo.lineTo(w, h)
        triangulo.close()
        drawPath(triangulo, rojo)

        val ax = w * 0.67f
        val ay = h * 0.30f
        val u = h * 0.15f
        val k = u * 1.3f

        val ave = Path()
        ave.moveTo(ax - k, ay + 0.25f * u)
        ave.lineTo(ax - 0.45f * k, ay - 0.20f * u)
        ave.lineTo(ax - 0.10f * k, ay - 0.05f * u)
        ave.lineTo(ax, ay - 0.30f * u)
        ave.lineTo(ax + 0.10f * k, ay - 0.05f * u)
        ave.lineTo(ax + 0.45f * k, ay - 0.20f * u)
        ave.lineTo(ax + k, ay + 0.25f * u)
        ave.lineTo(ax + 0.45f * k, ay + 0.10f * u)
        ave.lineTo(ax + 0.15f * k, ay + 0.15f * u)
        ave.lineTo(ax + 0.25f * k, ay + 0.55f * u)
        ave.lineTo(ax, ay + 0.38f * u)
        ave.lineTo(ax - 0.25f * k, ay + 0.55f * u)
        ave.lineTo(ax - 0.15f * k, ay + 0.15f * u)
        ave.lineTo(ax - 0.45f * k, ay + 0.10f * u)
        ave.close()
        drawPath(ave, amarillo)

        val grande = h * 0.055f
        val chica = h * 0.025f

        drawPath(estrella(w * 0.20f, h * 0.52f, grande), blanco)
        drawPath(estrella(w * 0.20f, h * 0.88f, grande), blanco)
        drawPath(estrella(w * 0.10f, h * 0.72f, grande), blanco)
        drawPath(estrella(w * 0.31f, h * 0.70f, grande), blanco)
        drawPath(estrella(w * 0.26f, h * 0.79f, chica), blanco)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaPapuaNuevaGuineaPreview() {
    Surface { BanderaPapuaNuevaGuinea() }
}