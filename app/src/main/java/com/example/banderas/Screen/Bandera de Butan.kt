package com.example.banderas.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

@Composable
fun BanderaButan(modifier: Modifier = Modifier) {
    val amarillo = colorResource(R.color.amarillo)
    val naranja = colorResource(R.color.naranja)
    val blanco = colorResource(R.color.blanco)

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(3f / 2f)
            .clipToBounds()
    ) {
        val w = size.width
        val h = size.height

        drawRect(color = naranja)

        val triangulo = Path()
        triangulo.moveTo(0f, 0f)
        triangulo.lineTo(w, 0f)
        triangulo.lineTo(0f, h)
        triangulo.close()
        drawPath(triangulo, amarillo)

        val cuerpo = Path()
        cuerpo.moveTo(w * 0.20f, h * 0.74f)
        cuerpo.cubicTo(w * 0.30f, h * 0.40f, w * 0.42f, h * 0.78f, w * 0.52f, h * 0.52f)
        cuerpo.cubicTo(w * 0.60f, h * 0.30f, w * 0.66f, h * 0.55f, w * 0.72f, h * 0.40f)
        drawPath(
            path = cuerpo,
            color = blanco,
            style = Stroke(width = h * 0.07f, cap = StrokeCap.Round, join = StrokeJoin.Round)
        )

        val hx = w * 0.73f
        val hy = h * 0.38f
        val s = h * 0.07f

        val cabeza = Path()
        cabeza.moveTo(hx - 0.6f * s, hy + 0.4f * s)
        cabeza.lineTo(hx - 0.2f * s, hy - 0.6f * s)
        cabeza.lineTo(hx + 0.5f * s, hy - 0.7f * s)
        cabeza.lineTo(hx + 1.3f * s, hy - 0.2f * s)
        cabeza.lineTo(hx + 1.6f * s, hy + 0.2f * s)
        cabeza.lineTo(hx + 0.9f * s, hy + 0.15f * s)
        cabeza.lineTo(hx + 0.4f * s, hy + 0.7f * s)
        cabeza.close()
        drawPath(cabeza, blanco)

        drawCircle(naranja, radius = s * 0.18f, center = Offset(hx + 0.4f * s, hy - 0.2f * s))

        val garra = h * 0.05f

        val garra1 = Path()
        garra1.moveTo(w * 0.32f, h * 0.60f)
        garra1.lineTo(w * 0.32f + garra, h * 0.60f + garra * 1.4f)
        garra1.lineTo(w * 0.32f - garra, h * 0.60f + garra * 1.4f)
        garra1.close()
        drawPath(garra1, blanco)

        val garra2 = Path()
        garra2.moveTo(w * 0.50f, h * 0.60f)
        garra2.lineTo(w * 0.50f + garra, h * 0.60f + garra * 1.4f)
        garra2.lineTo(w * 0.50f - garra, h * 0.60f + garra * 1.4f)
        garra2.close()
        drawPath(garra2, blanco)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaButanPreview() {
    Surface { BanderaButan() }
}