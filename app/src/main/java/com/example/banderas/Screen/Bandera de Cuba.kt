package com.example.banderas.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R
import kotlin.math.cos
import kotlin.math.sin

private val TrianguloDerecha = GenericShape { size, _ ->
    moveTo(0f, 0f)
    lineTo(size.width, size.height / 2f)
    lineTo(0f, size.height)
    close()
}

private val Estrella5Puntas = GenericShape { size, _ ->
    val cx = size.width / 2f
    val cy = size.height / 2f
    val radioExt = size.width / 2f
    val radioInt = radioExt * 0.382f
    val puntas = 5
    for (i in 0 until puntas * 2) {
        val r = if (i % 2 == 0) radioExt else radioInt
        val ang = Math.toRadians(-90.0 + i * 180.0 / puntas)
        val x = cx + (r * cos(ang)).toFloat()
        val y = cy + (r * sin(ang)).toFloat()
        if (i == 0) moveTo(x, y) else lineTo(x, y)
    }
    close()
}
@Composable
fun BanderaCuba(modifier: Modifier = Modifier) {
    val azul = colorResource(R.color.azul)
    val rojo = colorResource(R.color.rojo)
    val blanco = colorResource(R.color.blanco)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2f)
            .clipToBounds()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            repeat(5) { i ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(if (i % 2 == 0) azul else blanco)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(0.866f)
                .clip(TrianguloDerecha)
                .background(rojo)
        ) {
            Box(
                modifier = Modifier
                    .align(BiasAlignment(horizontalBias = -0.5487f, verticalBias = 0f))
                    .fillMaxHeight(0.34f)
                    .aspectRatio(1f)
                    .clip(Estrella5Puntas)
                    .background(blanco)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaCubaPreview() {
    Surface { BanderaCuba() }
}