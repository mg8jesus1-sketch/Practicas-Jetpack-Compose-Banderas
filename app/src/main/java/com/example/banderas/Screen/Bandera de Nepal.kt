package com.example.banderas.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banderas.R

// Estrella de 8 puntas con centro (cx, cy) y radio r
private fun estrella8(cx: Float, cy: Float, r: Float): Path {
    val path = Path()
    path.moveTo(cx, cy - r)
    path.lineTo(cx + 0.201f * r, cy - 0.486f * r)
    path.lineTo(cx + 0.707f * r, cy - 0.707f * r)
    path.lineTo(cx + 0.486f * r, cy - 0.201f * r)
    path.lineTo(cx + r, cy)
    path.lineTo(cx + 0.486f * r, cy + 0.201f * r)
    path.lineTo(cx + 0.707f * r, cy + 0.707f * r)
    path.lineTo(cx + 0.201f * r, cy + 0.486f * r)
    path.lineTo(cx, cy + r)
    path.lineTo(cx - 0.201f * r, cy + 0.486f * r)
    path.lineTo(cx - 0.707f * r, cy + 0.707f * r)
    path.lineTo(cx - 0.486f * r, cy + 0.201f * r)
    path.lineTo(cx - r, cy)
    path.lineTo(cx - 0.486f * r, cy - 0.201f * r)
    path.lineTo(cx - 0.707f * r, cy - 0.707f * r)
    path.lineTo(cx - 0.201f * r, cy - 0.486f * r)
    path.close()
    return path
}

// Estrella de 12 puntas con centro (cx, cy) y radio r
private fun estrella12(cx: Float, cy: Float, r: Float): Path {
    val path = Path()
    path.moveTo(cx, cy - r)
    path.lineTo(cx + 0.186f * r, cy - 0.695f * r)
    path.lineTo(cx + 0.5f * r, cy - 0.866f * r)
    path.lineTo(cx + 0.509f * r, cy - 0.509f * r)
    path.lineTo(cx + 0.866f * r, cy - 0.5f * r)
    path.lineTo(cx + 0.695f * r, cy - 0.186f * r)
    path.lineTo(cx + r, cy)
    path.lineTo(cx + 0.695f * r, cy + 0.186f * r)
    path.lineTo(cx + 0.866f * r, cy + 0.5f * r)
    path.lineTo(cx + 0.509f * r, cy + 0.509f * r)
    path.lineTo(cx + 0.5f * r, cy + 0.866f * r)
    path.lineTo(cx + 0.186f * r, cy + 0.695f * r)
    path.lineTo(cx, cy + r)
    path.lineTo(cx - 0.186f * r, cy + 0.695f * r)
    path.lineTo(cx - 0.5f * r, cy + 0.866f * r)
    path.lineTo(cx - 0.509f * r, cy + 0.509f * r)
    path.lineTo(cx - 0.866f * r, cy + 0.5f * r)
    path.lineTo(cx - 0.695f * r, cy + 0.186f * r)
    path.lineTo(cx - r, cy)
    path.lineTo(cx - 0.695f * r, cy - 0.186f * r)
    path.lineTo(cx - 0.866f * r, cy - 0.5f * r)
    path.lineTo(cx - 0.509f * r, cy - 0.509f * r)
    path.lineTo(cx - 0.5f * r, cy - 0.866f * r)
    path.lineTo(cx - 0.186f * r, cy - 0.695f * r)
    path.close()
    return path
}

@Composable
fun BanderaNepal(modifier: Modifier = Modifier) {
    val carmesi = colorResource(R.color.carmesi)
    val azul = colorResource(R.color.azul)
    val blanco = colorResource(R.color.blanco)

    Canvas(modifier = modifier.width(240.dp).height(290.dp)) {
        val w = size.width
        val h = size.height
        val m = w * 0.035f
        val ancho = w - 2f * m
        val alto = h - 2f * m

        val contorno = Path()
        contorno.moveTo(m, m)
        contorno.lineTo(m + 0.80f * ancho, m + 0.46f * alto)
        contorno.lineTo(m + 0.05f * ancho, m + 0.46f * alto)
        contorno.lineTo(m + ancho, m + alto)
        contorno.lineTo(m, m + alto)
        contorno.close()

        drawPath(contorno, color = carmesi)
        drawPath(contorno, color = azul, style = Stroke(width = m * 2f, join = StrokeJoin.Round))

        val lunaX = m + 0.27f * ancho
        val lunaY = m + 0.31f * alto
        val rLuna = h * 0.08f

        drawCircle(blanco, radius = rLuna, center = Offset(lunaX, lunaY))
        drawCircle(carmesi, radius = rLuna * 0.85f, center = Offset(lunaX, lunaY - rLuna * 0.4f))
        drawPath(estrella8(lunaX, lunaY - rLuna * 0.55f, rLuna * 0.38f), blanco)

        val solX = m + 0.27f * ancho
        val solY = m + 0.78f * alto
        val rSol = h * 0.095f

        drawPath(estrella12(solX, solY, rSol), blanco)
        drawCircle(carmesi, radius = rSol * 0.58f, center = Offset(solX, solY))
        drawCircle(blanco, radius = rSol * 0.42f, center = Offset(solX, solY))
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaNepalPreview() {
    Surface { BanderaNepal(Modifier.padding(16.dp)) }
}