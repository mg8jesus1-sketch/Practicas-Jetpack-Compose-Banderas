package com.example.banderas.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

@Composable
fun BanderaSeychelles(modifier: Modifier = Modifier) {
    val azul = colorResource(R.color.azul)
    val amarillo = colorResource(R.color.amarillo)
    val rojo = colorResource(R.color.rojo)
    val blanco = colorResource(R.color.blanco)
    val verde = colorResource(R.color.verde)

    val formaAzul = GenericShape { size, _ ->
        moveTo(0f, size.height)
        lineTo(0f, 0f)
        lineTo(size.width / 3, 0f)
        close()
    }

    val formaAmarilla = GenericShape { size, _ ->
        moveTo(0f, size.height)
        lineTo(size.width / 3, 0f)
        lineTo(size.width * 2 / 3, 0f)
        close()
    }

    val formaRoja = GenericShape { size, _ ->
        moveTo(0f, size.height)
        lineTo(size.width * 2 / 3, 0f)
        lineTo(size.width, 0f)
        close()
    }

    val formaBlanca = GenericShape { size, _ ->
        moveTo(0f, size.height)
        lineTo(size.width, 0f)
        lineTo(size.width, size.height / 3)
        close()
    }

    val formaVerde = GenericShape { size, _ ->
        moveTo(0f, size.height)
        lineTo(size.width, size.height / 3)
        lineTo(size.width, size.height)
        close()
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2f)
    ) {
        Box(Modifier.fillMaxSize().background(azul, formaAzul))
        Box(Modifier.fillMaxSize().background(amarillo, formaAmarilla))
        Box(Modifier.fillMaxSize().background(rojo, formaRoja))
        Box(Modifier.fillMaxSize().background(blanco, formaBlanca))
        Box(Modifier.fillMaxSize().background(verde, formaVerde))
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSeychellesPreview() {
    Surface { BanderaSeychelles() }
}