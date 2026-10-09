package com.example.banderas.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

private fun ola(w: Float, y: Float, a: Float): Path {
    val path = Path()
    path.moveTo(0f, y)
    path.quadraticTo(w * 0.05f, y - 2f * a, w * 0.10f, y)
    path.quadraticTo(w * 0.15f, y + 2f * a, w * 0.20f, y)
    path.quadraticTo(w * 0.25f, y - 2f * a, w * 0.30f, y)
    path.quadraticTo(w * 0.35f, y + 2f * a, w * 0.40f, y)
    path.quadraticTo(w * 0.45f, y - 2f * a, w * 0.50f, y)
    path.quadraticTo(w * 0.55f, y + 2f * a, w * 0.60f, y)
    path.quadraticTo(w * 0.65f, y - 2f * a, w * 0.70f, y)
    path.quadraticTo(w * 0.75f, y + 2f * a, w * 0.80f, y)
    path.quadraticTo(w * 0.85f, y - 2f * a, w * 0.90f, y)
    path.quadraticTo(w * 0.95f, y + 2f * a, w, y)
    return path
}

@Composable
fun BanderaKiribati(modifier: Modifier = Modifier) {
    val rojo = colorResource(R.color.rojo)
    val azul = colorResource(R.color.azul)
    val amarillo = colorResource(R.color.amarillo)
    val blanco = colorResource(R.color.blanco)

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2f)
            .clipToBounds()
    ) {
        val w = size.width
        val h = size.height

        drawRect(rojo, size = Size(w, h / 2f))
        drawRect(azul, topLeft = Offset(0f, h / 2f), size = Size(w, h / 2f))

        val banda = h / 12f
        val amplitud = h * 0.022f
        drawPath(ola(w, h * 0.5417f, amplitud), blanco, style = Stroke(width = banda))
        drawPath(ola(w, h * 0.7083f, amplitud), blanco, style = Stroke(width = banda))
        drawPath(ola(w, h * 0.8750f, amplitud), blanco, style = Stroke(width = banda))

        val cx = w / 2f
        val cy = h / 2f
        val r = h * 0.15f
        val rayo = h * 0.27f
        drawArc(
            color = amarillo,
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(cx - r, cy - r),
            size = Size(2f * r, 2f * r)
        )

        val g = h * 0.012f
        drawLine(amarillo, Offset(cx, cy), Offset(cx - rayo, cy), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx - 0.9808f * rayo, cy - 0.1951f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx - 0.9239f * rayo, cy - 0.3827f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx - 0.8315f * rayo, cy - 0.5556f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx - 0.7071f * rayo, cy - 0.7071f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx - 0.5556f * rayo, cy - 0.8315f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx - 0.3827f * rayo, cy - 0.9239f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx - 0.1951f * rayo, cy - 0.9808f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx, cy - rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx + 0.1951f * rayo, cy - 0.9808f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx + 0.3827f * rayo, cy - 0.9239f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx + 0.5556f * rayo, cy - 0.8315f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx + 0.7071f * rayo, cy - 0.7071f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx + 0.8315f * rayo, cy - 0.5556f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx + 0.9239f * rayo, cy - 0.3827f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx + 0.9808f * rayo, cy - 0.1951f * rayo), g)
        drawLine(amarillo, Offset(cx, cy), Offset(cx + rayo, cy), g)

        val ax = w / 2f
        val ay = h * 0.12f
        val u = h * 0.09f
        val k = u * 1.6f

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
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaKiribatiPreview() {
    Surface { BanderaKiribati() }
}