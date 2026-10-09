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
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

@Composable
fun BanderaSudafrica(modifier: Modifier = Modifier) {
    val rojo = colorResource(R.color.rojo)
    val azul = colorResource(R.color.azul)
    val verde = colorResource(R.color.verde)
    val dorado = colorResource(R.color.dorado)
    val negro = colorResource(R.color.negro)
    val blanco = colorResource(R.color.blanco)


    val formaYBlanca = GenericShape { size, _ ->
        val u = size.height
        moveTo(-0.1f * u, -0.297f * u)
        lineTo(0.599f * u, 0.35f * u)
        lineTo(1.6f * u, 0.35f * u)
        lineTo(1.6f * u, 0.65f * u)
        lineTo(0.599f * u, 0.65f * u)
        lineTo(-0.1f * u, 1.297f * u)
        lineTo(-0.1f * u, 0.888f * u)
        lineTo(0.319f * u, 0.5f * u)
        lineTo(-0.1f * u, 0.112f * u)
        close()
    }

    val formaYVerde = GenericShape { size, _ ->
        val u = size.height
        moveTo(-0.1f * u, -0.229f * u)
        lineTo(0.579f * u, 0.4f * u)
        lineTo(1.6f * u, 0.4f * u)
        lineTo(1.6f * u, 0.6f * u)
        lineTo(0.579f * u, 0.6f * u)
        lineTo(-0.1f * u, 1.229f * u)
        lineTo(-0.1f * u, 0.956f * u)
        lineTo(0.393f * u, 0.5f * u)
        lineTo(-0.1f * u, 0.044f * u)
        close()
    }

    val formaDorado = GenericShape { size, _ ->
        val u = size.height
        moveTo(0f, 0.136f * u)
        lineTo(0f, 0.864f * u)
        lineTo(0.393f * u, 0.5f * u)
        close()
    }

    val formaNegro = GenericShape { size, _ ->
        val u = size.height
        moveTo(0f, 0.191f * u)
        lineTo(0f, 0.809f * u)
        lineTo(0.335f * u, 0.5f * u)
        close()
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(3f / 2f)
            .clipToBounds()
    ) {

        Box(
            Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(rojo)
        )

        Box(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(azul)
        )

        Box(Modifier.fillMaxSize().background(blanco, formaYBlanca))
        Box(Modifier.fillMaxSize().background(verde, formaYVerde))

        Box(Modifier.fillMaxSize().background(dorado, formaDorado))
        Box(Modifier.fillMaxSize().background(negro, formaNegro))
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSudafricaPreview() {
    Surface { BanderaSudafrica() }
}