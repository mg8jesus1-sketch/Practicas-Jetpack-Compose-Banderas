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
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

private fun ola(fy: Float): Shape = GenericShape { size, _ ->
    val w = size.width
    val h = size.height
    val banda = h / 12f
    val a = h * 0.022f
    val y1 = h * fy
    val y2 = y1 + banda

    moveTo(0f, y1)
    quadraticTo(w * 0.05f, y1 - 2f * a, w * 0.10f, y1)
    quadraticTo(w * 0.15f, y1 + 2f * a, w * 0.20f, y1)
    quadraticTo(w * 0.25f, y1 - 2f * a, w * 0.30f, y1)
    quadraticTo(w * 0.35f, y1 + 2f * a, w * 0.40f, y1)
    quadraticTo(w * 0.45f, y1 - 2f * a, w * 0.50f, y1)
    quadraticTo(w * 0.55f, y1 + 2f * a, w * 0.60f, y1)
    quadraticTo(w * 0.65f, y1 - 2f * a, w * 0.70f, y1)
    quadraticTo(w * 0.75f, y1 + 2f * a, w * 0.80f, y1)
    quadraticTo(w * 0.85f, y1 - 2f * a, w * 0.90f, y1)
    quadraticTo(w * 0.95f, y1 + 2f * a, w, y1)

    lineTo(w, y2)
    quadraticTo(w * 0.95f, y2 + 2f * a, w * 0.90f, y2)
    quadraticTo(w * 0.85f, y2 - 2f * a, w * 0.80f, y2)
    quadraticTo(w * 0.75f, y2 + 2f * a, w * 0.70f, y2)
    quadraticTo(w * 0.65f, y2 - 2f * a, w * 0.60f, y2)
    quadraticTo(w * 0.55f, y2 + 2f * a, w * 0.50f, y2)
    quadraticTo(w * 0.45f, y2 - 2f * a, w * 0.40f, y2)
    quadraticTo(w * 0.35f, y2 + 2f * a, w * 0.30f, y2)
    quadraticTo(w * 0.25f, y2 - 2f * a, w * 0.20f, y2)
    quadraticTo(w * 0.15f, y2 + 2f * a, w * 0.10f, y2)
    quadraticTo(w * 0.05f, y2 - 2f * a, 0f, y2)
    close()
}

private fun agregarRayo(path: Path, cx: Float, cy: Float, c: Float, s: Float, largo: Float, g: Float) {
    path.moveTo(cx - g * s, cy + g * c)
    path.lineTo(cx + largo * c, cy + largo * s)
    path.lineTo(cx + g * s, cy - g * c)
    path.close()
}

@Composable
fun BanderaKiribati(modifier: Modifier = Modifier) {
    val rojo = colorResource(R.color.rojo)
    val azul = colorResource(R.color.azul)
    val amarillo = colorResource(R.color.amarillo)
    val blanco = colorResource(R.color.blanco)

    val formaSol = GenericShape { size, _ ->
        val cx = size.width / 2f
        val cy = size.height / 2f
        val r = size.height * 0.15f

        moveTo(cx - r, cy)
        arcTo(Rect(cx - r, cy - r, cx + r, cy + r), 180f, 180f, false)
        close()
    }

    val formaRayos = GenericShape { size, _ ->
        val cx = size.width / 2f
        val cy = size.height / 2f
        val largo = size.height * 0.27f
        val g = size.height * 0.024f

        agregarRayo(this, cx, cy, -1f, 0f, largo, g)
        agregarRayo(this, cx, cy, -0.9808f, -0.1951f, largo, g)
        agregarRayo(this, cx, cy, -0.9239f, -0.3827f, largo, g)
        agregarRayo(this, cx, cy, -0.8315f, -0.5556f, largo, g)
        agregarRayo(this, cx, cy, -0.7071f, -0.7071f, largo, g)
        agregarRayo(this, cx, cy, -0.5556f, -0.8315f, largo, g)
        agregarRayo(this, cx, cy, -0.3827f, -0.9239f, largo, g)
        agregarRayo(this, cx, cy, -0.1951f, -0.9808f, largo, g)
        agregarRayo(this, cx, cy, 0f, -1f, largo, g)
        agregarRayo(this, cx, cy, 0.1951f, -0.9808f, largo, g)
        agregarRayo(this, cx, cy, 0.3827f, -0.9239f, largo, g)
        agregarRayo(this, cx, cy, 0.5556f, -0.8315f, largo, g)
        agregarRayo(this, cx, cy, 0.7071f, -0.7071f, largo, g)
        agregarRayo(this, cx, cy, 0.8315f, -0.5556f, largo, g)
        agregarRayo(this, cx, cy, 0.9239f, -0.3827f, largo, g)
        agregarRayo(this, cx, cy, 0.9808f, -0.1951f, largo, g)
        agregarRayo(this, cx, cy, 1f, 0f, largo, g)
    }

    val formaAve = GenericShape { size, _ ->
        val ax = size.width / 2f
        val ay = size.height * 0.12f
        val u = size.height * 0.09f
        val k = u * 1.6f

        moveTo(ax - k, ay + 0.25f * u)
        lineTo(ax - 0.45f * k, ay - 0.20f * u)
        lineTo(ax - 0.10f * k, ay - 0.05f * u)
        lineTo(ax, ay - 0.30f * u)
        lineTo(ax + 0.10f * k, ay - 0.05f * u)
        lineTo(ax + 0.45f * k, ay - 0.20f * u)
        lineTo(ax + k, ay + 0.25f * u)
        lineTo(ax + 0.45f * k, ay + 0.10f * u)
        lineTo(ax + 0.15f * k, ay + 0.15f * u)
        lineTo(ax + 0.25f * k, ay + 0.55f * u)
        lineTo(ax, ay + 0.38f * u)
        lineTo(ax - 0.25f * k, ay + 0.55f * u)
        lineTo(ax - 0.15f * k, ay + 0.15f * u)
        lineTo(ax - 0.45f * k, ay + 0.10f * u)
        close()
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2f)
            .background(rojo)
    ) {
        Box(Modifier.fillMaxSize().background(amarillo, formaSol))
        Box(Modifier.fillMaxSize().background(amarillo, formaRayos))

        Box(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(azul)
        )

        Box(Modifier.fillMaxSize().background(blanco, ola(0.5f)))
        Box(Modifier.fillMaxSize().background(blanco, ola(0.6667f)))
        Box(Modifier.fillMaxSize().background(blanco, ola(0.8333f)))

        Box(Modifier.fillMaxSize().background(amarillo, formaAve))
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaKiribatiPreview() {
    Surface { BanderaKiribati() }
}