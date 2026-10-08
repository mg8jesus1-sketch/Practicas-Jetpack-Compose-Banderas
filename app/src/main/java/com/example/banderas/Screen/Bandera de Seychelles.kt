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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

private fun poligono(puntos: List<Offset>): Path {
    val path = Path()
    path.moveTo(puntos[0].x, puntos[0].y)
    for (i in 1 until puntos.size) path.lineTo(puntos[i].x, puntos[i].y)
    path.close()
    return path
}

@Composable
fun BanderaSeychelles(modifier: Modifier = Modifier) {
    val azul = colorResource(R.color.azul)
    val amarillo = colorResource(R.color.amarillo)
    val rojo = colorResource(R.color.rojo)
    val blanco = colorResource(R.color.blanco)
    val verde = colorResource(R.color.verde)

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2f)
            .clipToBounds()
    ) {
        val w = size.width
        val h = size.height
        val origen = Offset(0f, h)

        drawPath(poligono(listOf(origen, Offset(0f, 0f), Offset(w / 3f, 0f))), azul)
        drawPath(poligono(listOf(origen, Offset(w / 3f, 0f), Offset(2f * w / 3f, 0f))), amarillo)
        drawPath(poligono(listOf(origen, Offset(2f * w / 3f, 0f), Offset(w, 0f))), rojo)
        drawPath(poligono(listOf(origen, Offset(w, 0f), Offset(w, h / 3f))), blanco)
        drawPath(poligono(listOf(origen, Offset(w, h / 3f), Offset(w, h))), verde)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSeychellesPreview() {
    Surface { BanderaSeychelles() }
}