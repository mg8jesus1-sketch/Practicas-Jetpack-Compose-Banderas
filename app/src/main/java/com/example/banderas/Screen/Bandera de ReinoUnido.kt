package com.example.banderas.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

@Composable
fun BanderaReinoUnido(modifier: Modifier = Modifier) {
    val azul = colorResource(R.color.azul)
    val rojo = colorResource(R.color.rojo)
    val blanco = colorResource(R.color.blanco)

    val diagonalBlanca1 = GenericShape { size, _ ->
        val u = size.width / 60f
        moveTo(0f, 0f)
        lineTo(6.7f * u, 0f)
        lineTo(60f * u, 26.6f * u)
        lineTo(60f * u, 30f * u)
        lineTo(53.3f * u, 30f * u)
        lineTo(0f, 3.4f * u)
        close()
    }

    val diagonalBlanca2 = GenericShape { size, _ ->
        val u = size.width / 60f
        moveTo(60f * u, 0f)
        lineTo(53.3f * u, 0f)
        lineTo(0f, 26.6f * u)
        lineTo(0f, 30f * u)
        lineTo(6.7f * u, 30f * u)
        lineTo(60f * u, 3.4f * u)
        close()
    }

    val diagonalRoja1 = GenericShape { size, _ ->
        val u = size.width / 60f
        moveTo(0f, 0f)
        lineTo(2.2f * u, 0f)
        lineTo(60f * u, 28.9f * u)
        lineTo(60f * u, 30f * u)
        lineTo(57.8f * u, 30f * u)
        lineTo(0f, 1.1f * u)
        close()
    }

    val diagonalRoja2 = GenericShape { size, _ ->
        val u = size.width / 60f
        moveTo(60f * u, 0f)
        lineTo(57.8f * u, 0f)
        lineTo(0f, 28.9f * u)
        lineTo(0f, 30f * u)
        lineTo(2.2f * u, 30f * u)
        lineTo(60f * u, 1.1f * u)
        close()
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2f)
            .background(azul)
    ) {
        Box(Modifier.fillMaxSize().background(blanco, diagonalBlanca1))
        Box(Modifier.fillMaxSize().background(blanco, diagonalBlanca2))

        Box(Modifier.fillMaxSize().background(rojo, diagonalRoja1))
        Box(Modifier.fillMaxSize().background(rojo, diagonalRoja2))

        Box(
            Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .fillMaxHeight(1f / 3f)
                .background(blanco)
        )
        Box(
            Modifier
                .align(Alignment.Center)
                .fillMaxHeight()
                .fillMaxWidth(1f / 6f)
                .background(blanco)
        )

        Box(
            Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .background(rojo)
        )
        Box(
            Modifier
                .align(Alignment.Center)
                .fillMaxHeight()
                .fillMaxWidth(0.1f)
                .background(rojo)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaReinoUnidoPreview() {
    Surface { BanderaReinoUnido() }
}