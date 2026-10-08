package com.example.banderas.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R
import kotlin.math.cos
import kotlin.math.sin

private fun triangleShape(rotationDeg: Float): Shape = GenericShape { size, _ ->
    val cx = size.width / 2f
    val cy = size.height / 2f
    val r = size.height / 2f
    for (i in 0..2) {
        val angle = Math.toRadians((rotationDeg + i * 120).toDouble())
        val x = cx + r * cos(angle).toFloat()
        val y = cy + r * sin(angle).toFloat()
        if (i == 0) moveTo(x, y) else lineTo(x, y)
    }
    close()
}

@Composable
fun BanderaIsrael(modifier: Modifier = Modifier) {
    val azul = colorResource(R.color.azul)
    val blanco = colorResource(R.color.white)

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(11f / 8f)
            .clipToBounds()
            .background(blanco)
    ) {
        val alto = maxHeight

        Column(Modifier.fillMaxSize()) {
            Spacer(Modifier.weight(15f))
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(25f)
                    .background(azul)
            )
            Spacer(Modifier.weight(80f))
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(25f)
                    .background(azul)
            )
            Spacer(Modifier.weight(15f))
        }

        val diametro = alto * 0.38f
        val trazo = alto * 0.03f

        Box(
            Modifier
                .align(Alignment.Center)
                .size(diametro)
                .border(trazo, azul, triangleShape(-90f))
        )
        Box(
            Modifier
                .align(Alignment.Center)
                .size(diametro)
                .border(trazo, azul, triangleShape(90f))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaIsraelPreview() {
    Surface { BanderaIsrael() }
}