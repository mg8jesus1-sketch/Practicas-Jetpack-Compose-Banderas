package com.example.banderas.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

@Composable
fun BanderaReinoUnido(modifier: Modifier = Modifier) {
    val azul = colorResource(R.color.azul)
    val rojo = colorResource(R.color.rojo)
    val blanco = colorResource(R.color.blanco)

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2f)
            .clipToBounds()
    ) {
        val u = size.width / 60f
        val w = size.width
        val h = size.height

        drawRect(color = azul)

        drawLine(blanco, Offset(0f, 0f), Offset(w, h), strokeWidth = 6f * u)
        drawLine(blanco, Offset(w, 0f), Offset(0f, h), strokeWidth = 6f * u)

        drawLine(rojo, Offset(0f, 0f), Offset(w, h), strokeWidth = 2f * u)
        drawLine(rojo, Offset(w, 0f), Offset(0f, h), strokeWidth = 2f * u)

        drawLine(blanco, Offset(w / 2, 0f), Offset(w / 2, h), strokeWidth = 10f * u)
        drawLine(blanco, Offset(0f, h / 2), Offset(w, h / 2), strokeWidth = 10f * u)

        drawLine(rojo, Offset(w / 2, 0f), Offset(w / 2, h), strokeWidth = 6f * u)
        drawLine(rojo, Offset(0f, h / 2), Offset(w, h / 2), strokeWidth = 6f * u)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaReinoUnidoPreview() {
    Surface { BanderaReinoUnido() }
}