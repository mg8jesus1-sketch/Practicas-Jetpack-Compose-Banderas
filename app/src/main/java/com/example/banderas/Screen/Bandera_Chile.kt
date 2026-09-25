package com.example.banderas.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun BanderaChile(modifier: Modifier = Modifier) {
    val azul = colorResource(id = R.color.azul)
    val rojo = colorResource(id = R.color.rojo)
    val blanco = colorResource(id = R.color.blanco)

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(3f / 2f)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(blanco)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.35f)
                            .fillMaxHeight()
                            .align(Alignment.CenterStart)
                            .background(azul),
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(modifier = Modifier.fillMaxSize(0.55f)) {
                            drawStar(
                                center = Offset(size.width / 2f, size.height / 2f),
                                radius = size.minDimension / 2f,
                                color = blanco
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(rojo)
                )
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
fun BanderaChilePreview() {
    Surface {
        BanderaChile(modifier = Modifier.fillMaxSize())
    }
}