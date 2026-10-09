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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

private fun estrella(fx: Float, fy: Float, fr: Float): Shape = GenericShape { size, _ ->
    val cx = size.width * fx
    val cy = size.height * fy
    val r = size.height * fr

    moveTo(cx, cy - r)
    lineTo(cx + 0.225f * r, cy - 0.309f * r)
    lineTo(cx + 0.951f * r, cy - 0.309f * r)
    lineTo(cx + 0.363f * r, cy + 0.118f * r)
    lineTo(cx + 0.588f * r, cy + 0.809f * r)
    lineTo(cx, cy + 0.382f * r)
    lineTo(cx - 0.588f * r, cy + 0.809f * r)
    lineTo(cx - 0.363f * r, cy + 0.118f * r)
    lineTo(cx - 0.951f * r, cy - 0.309f * r)
    lineTo(cx - 0.225f * r, cy - 0.309f * r)
    close()
}

@Composable
fun BanderaPapuaNuevaGuinea(modifier: Modifier = Modifier) {
    val rojo = colorResource(R.color.rojo)
    val negro = colorResource(R.color.negro)
    val amarillo = colorResource(R.color.amarillo)
    val blanco = colorResource(R.color.blanco)

    val formaTriangulo = GenericShape { size, _ ->
        moveTo(0f, 0f)
        lineTo(size.width, 0f)
        lineTo(size.width, size.height)
        close()
    }

    val formaAve = GenericShape { size, _ ->
        val ax = size.width * 0.67f
        val ay = size.height * 0.30f
        val u = size.height * 0.15f
        val k = u * 1.3f

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
            .aspectRatio(4f / 3f)
            .background(negro)
    ) {
        Box(Modifier.fillMaxSize().background(rojo, formaTriangulo))

        Box(Modifier.fillMaxSize().background(amarillo, formaAve))

        Box(Modifier.fillMaxSize().background(blanco, estrella(0.20f, 0.52f, 0.055f)))
        Box(Modifier.fillMaxSize().background(blanco, estrella(0.20f, 0.88f, 0.055f)))
        Box(Modifier.fillMaxSize().background(blanco, estrella(0.10f, 0.72f, 0.055f)))
        Box(Modifier.fillMaxSize().background(blanco, estrella(0.31f, 0.70f, 0.055f)))
        Box(Modifier.fillMaxSize().background(blanco, estrella(0.26f, 0.79f, 0.025f)))
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaPapuaNuevaGuineaPreview() {
    Surface { BanderaPapuaNuevaGuinea() }
}