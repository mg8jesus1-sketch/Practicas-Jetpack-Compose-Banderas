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
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R
import kotlin.math.cos
import kotlin.math.sin

private fun trianglePath(cx: Float, cy: Float, r: Float, rotationDeg: Float): Path {
    val path = Path()
    for (i in 0..2) {
        val angle = Math.toRadians((rotationDeg + i * 120).toDouble())
        val x = cx + r * cos(angle).toFloat()
        val y = cy + r * sin(angle).toFloat()
        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
    }
    path.close()
    return path
}

@Composable
fun BanderaIsrael(modifier: Modifier = Modifier) {
    val azul = colorResource(R.color.azul)
    val blanco = colorResource(R.color.white)

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(11f / 8f)
            .clipToBounds()
    ) {
        val w = size.width
        val h = size.height

        drawRect(color = blanco)

        val alto = h * 0.15625f
        val margen = h * 0.09375f
        drawRect(azul, topLeft = Offset(0f, margen), size = Size(w, alto))
        drawRect(azul, topLeft = Offset(0f, h - margen - alto), size = Size(w, alto))

        val cx = w / 2f
        val cy = h / 2f
        val r = h * 0.19f
        val trazo = Stroke(width = h * 0.03f, join = StrokeJoin.Miter)
        drawPath(trianglePath(cx, cy, r, -90f), color = azul, style = trazo)
        drawPath(trianglePath(cx, cy, r, 90f), color = azul, style = trazo)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaIsraelPreview() {
    Surface { BanderaIsrael() }
}
