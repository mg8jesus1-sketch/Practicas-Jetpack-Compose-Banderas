package com.example.banderas.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R
import kotlin.math.cos
import kotlin.math.sin

private fun estrellaPath(
    cx: Float, cy: Float, radioExt: Float, radioInt: Float,
    puntas: Int, rotacionGrados: Float = -90f
): Path {
    val path = Path()
    for (i in 0 until puntas * 2) {
        val r = if (i % 2 == 0) radioExt else radioInt
        val ang = Math.toRadians(rotacionGrados + i * 180.0 / puntas)
        val x = cx + (r * cos(ang)).toFloat()
        val y = cy + (r * sin(ang)).toFloat()
        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
    }
    path.close()
    return path
}

@Composable
fun BanderaCuba(modifier: Modifier = Modifier) {
    val azul = colorResource(R.color.azul)
    val rojo = colorResource(R.color.rojo)
    val blanco = colorResource(R.color.blanco)

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2f)
            .clipToBounds()
    ) {
        val w = size.width
        val h = size.height

        drawRect(color = blanco)
        val franja = h / 5f
        for (i in 0 until 5) {
            if (i % 2 == 0) {
                drawRect(azul, topLeft = Offset(0f, i * franja), size = Size(w, franja))
            }
        }

        val triAncho = h * 0.866f
        val triangulo = Path().apply {
            moveTo(0f, 0f)
            lineTo(triAncho, h / 2f)
            lineTo(0f, h)
            close()
        }
        drawPath(triangulo, color = rojo)

        val rExt = h * 0.17f
        drawPath(
            path = estrellaPath(triAncho / 3f, h / 2f, rExt, rExt * 0.382f, 5),
            color = blanco
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaCubaPreview() {
    Surface { BanderaCuba() }
}
