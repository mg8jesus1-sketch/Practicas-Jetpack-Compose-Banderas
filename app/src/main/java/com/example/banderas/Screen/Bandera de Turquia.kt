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
fun BanderaTurquia(modifier: Modifier = Modifier) {
    val rojo = colorResource(R.color.rojo)
    val blanco = colorResource(R.color.white)

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(3f / 2f)
            .clipToBounds()
    ) {
        val w = size.width
        val h = size.height

        drawRect(color = rojo)

        val cx = w * 0.355f
        val cy = h / 2f

        drawCircle(color = blanco, radius = h * 0.25f, center = Offset(cx, cy))
        drawCircle(color = rojo, radius = h * 0.20f, center = Offset(cx + h * 0.0625f, cy))

        val rExt = h * 0.125f
        drawPath(
            path = estrellaPath(cx + h * 0.34f, cy, rExt, rExt * 0.382f, 5, 180f),
            color = blanco
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaTurquiaPreview() {
    Surface { BanderaTurquia() }
}
