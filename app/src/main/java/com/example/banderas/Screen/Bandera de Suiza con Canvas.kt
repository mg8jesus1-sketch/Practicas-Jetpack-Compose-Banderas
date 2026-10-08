package com.example.banderas.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

@Composable
fun BanderaSuizaCanvas(modifier: Modifier = Modifier) {

    val rojo = colorResource(R.color.rojo)
    val blanco = colorResource(R.color.white)

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        val lado = size.width
        val grosor = lado * 6f / 32f
        val largo = lado * 20f / 32f


        drawRect(color = rojo)


        drawRect(
            color = blanco,
            topLeft = Offset((lado - grosor) / 2f, (lado - largo) / 2f),
            size = Size(grosor, largo)
        )

        drawRect(
            color = blanco,
            topLeft = Offset((lado - largo) / 2f, (lado - grosor) / 2f),
            size = Size(largo, grosor)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSuizaCanvasPreview() {
    Surface { BanderaSuizaCanvas() }
}