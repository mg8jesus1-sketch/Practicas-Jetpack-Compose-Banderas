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
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

@Composable
fun BanderaButan(modifier: Modifier = Modifier) {
    val amarillo = colorResource(R.color.amarillo)
    val naranja = colorResource(R.color.naranja)
    val blanco = colorResource(R.color.blanco)

    val formaTriangulo = GenericShape { size, _ ->
        moveTo(0f, 0f)
        lineTo(size.width, 0f)
        lineTo(0f, size.height)
        close()
    }

    val formaCuerpo = GenericShape { size, _ ->
        val w = size.width
        val h = size.height
        val d = h * 0.035f

        moveTo(w * 0.20f, h * 0.74f - d)
        cubicTo(w * 0.30f, h * 0.40f - d, w * 0.42f, h * 0.78f - d, w * 0.52f, h * 0.52f - d)
        cubicTo(w * 0.60f, h * 0.30f - d, w * 0.66f, h * 0.55f - d, w * 0.72f, h * 0.40f - d)

        lineTo(w * 0.72f, h * 0.40f + d)
        cubicTo(w * 0.66f, h * 0.55f + d, w * 0.60f, h * 0.30f + d, w * 0.52f, h * 0.52f + d)
        cubicTo(w * 0.42f, h * 0.78f + d, w * 0.30f, h * 0.40f + d, w * 0.20f, h * 0.74f + d)
        close()
    }

    val formaCabeza = GenericShape { size, _ ->
        val hx = size.width * 0.73f
        val hy = size.height * 0.38f
        val s = size.height * 0.07f

        moveTo(hx - 0.6f * s, hy + 0.4f * s)
        lineTo(hx - 0.2f * s, hy - 0.6f * s)
        lineTo(hx + 0.5f * s, hy - 0.7f * s)
        lineTo(hx + 1.3f * s, hy - 0.2f * s)
        lineTo(hx + 1.6f * s, hy + 0.2f * s)
        lineTo(hx + 0.9f * s, hy + 0.15f * s)
        lineTo(hx + 0.4f * s, hy + 0.7f * s)
        close()
    }

    val formaOjo = GenericShape { size, _ ->
        val hx = size.width * 0.73f
        val hy = size.height * 0.38f
        val s = size.height * 0.07f
        val cx = hx + 0.4f * s
        val cy = hy - 0.2f * s
        val r = s * 0.18f

        addOval(Rect(cx - r, cy - r, cx + r, cy + r))
    }

    val formaGarra1 = GenericShape { size, _ ->
        val garra = size.height * 0.05f
        moveTo(size.width * 0.32f, size.height * 0.60f)
        lineTo(size.width * 0.32f + garra, size.height * 0.60f + garra * 1.4f)
        lineTo(size.width * 0.32f - garra, size.height * 0.60f + garra * 1.4f)
        close()
    }

    val formaGarra2 = GenericShape { size, _ ->
        val garra = size.height * 0.05f
        moveTo(size.width * 0.50f, size.height * 0.60f)
        lineTo(size.width * 0.50f + garra, size.height * 0.60f + garra * 1.4f)
        lineTo(size.width * 0.50f - garra, size.height * 0.60f + garra * 1.4f)
        close()
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(3f / 2f)
            .background(naranja)
    ) {
        Box(Modifier.fillMaxSize().background(amarillo, formaTriangulo))

        Box(Modifier.fillMaxSize().background(blanco, formaCuerpo))
        Box(Modifier.fillMaxSize().background(blanco, formaCabeza))
        Box(Modifier.fillMaxSize().background(blanco, formaGarra1))
        Box(Modifier.fillMaxSize().background(blanco, formaGarra2))

        Box(Modifier.fillMaxSize().background(naranja, formaOjo))
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaButanPreview() {
    Surface { BanderaButan() }
}