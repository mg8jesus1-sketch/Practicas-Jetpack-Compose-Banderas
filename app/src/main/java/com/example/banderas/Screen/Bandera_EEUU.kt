package com.example.banderascompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaEEUU(modifier: Modifier = Modifier) {
    val rojo = colorResource(id = R.color.rojo)
    val azul = colorResource(id = R.color.azul)
    val blanco = colorResource(id = R.color.blanco)

    Box(modifier = modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            repeat(13) { index ->
                Box(
                    Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(if (index % 2 == 0) rojo else blanco)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .fillMaxHeight(0.54f)
                .background(azul)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val cols = 6
                val rows = 5
                val starRadius = size.minDimension / (cols * 2.2f)

                for (row in 0 until rows) {
                    val starsInRow = if (row % 2 == 0) cols else cols - 1
                    val offsetX = if (row % 2 == 0) 0f else (size.width / cols) / 2f

                    for (col in 0 until starsInRow) {
                        val cx = offsetX + (size.width / cols) * col + (size.width / cols) / 2f
                        val cy = (size.height / rows) * row + (size.height / rows) / 2f
                        drawStar(center = Offset(cx, cy), radius = starRadius, color = blanco)
                    }
                }
            }
        }
    }
}

private fun DrawScope.drawStar(center: Offset, radius: Float, color: androidx.compose.ui.graphics.Color) {
    val path = Path()
    val innerRadius = radius * 0.4f
    val points = 5
    val angleStep = PI / points

    for (i in 0 until points * 2) {
        val r = if (i % 2 == 0) radius else innerRadius
        val angle = i * angleStep - PI / 2
        val x = center.x + (r * cos(angle)).toFloat()
        val y = center.y + (r * sin(angle)).toFloat()
        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
    }
    path.close()
    drawPath(path = path, color = color)
}

@Preview(showBackground = true)
@Composable
fun BanderaEEUUPreview() {
    Surface {
        BanderaEEUU(modifier = Modifier.fillMaxSize())
    }
}