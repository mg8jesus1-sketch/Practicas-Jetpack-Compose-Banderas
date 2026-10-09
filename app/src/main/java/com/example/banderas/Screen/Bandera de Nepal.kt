package com.example.banderas.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banderas.R

@Composable
fun BanderaNepal(modifier: Modifier = Modifier) {
    val carmesi = colorResource(R.color.carmesi)
    val azul = colorResource(R.color.azul)
    val blanco = colorResource(R.color.blanco)

    val formaBandera = GenericShape { size, _ ->
        moveTo(0f, 0f)
        lineTo(size.width * 0.80f, size.height * 0.46f)
        lineTo(size.width * 0.05f, size.height * 0.46f)
        lineTo(size.width, size.height)
        lineTo(0f, size.height)
        close()
    }

    val formaLuna = GenericShape { size, _ ->
        val m = size.width * 0.035f
        val x = m + 0.27f * (size.width - 2f * m)
        val y = m + 0.31f * (size.height - 2f * m)
        val r = size.height * 0.08f

        addOval(Rect(x - r, y - r, x + r, y + r))
    }

    val formaLunaHueco = GenericShape { size, _ ->
        val m = size.width * 0.035f
        val x = m + 0.27f * (size.width - 2f * m)
        val y = m + 0.31f * (size.height - 2f * m)
        val rLuna = size.height * 0.08f
        val r = rLuna * 0.85f
        val cy = y - rLuna * 0.4f

        addOval(Rect(x - r, cy - r, x + r, cy + r))
    }

    val formaEstrella8 = GenericShape { size, _ ->
        val m = size.width * 0.035f
        val cx = m + 0.27f * (size.width - 2f * m)
        val rLuna = size.height * 0.08f
        val cy = m + 0.31f * (size.height - 2f * m) - rLuna * 0.55f
        val r = rLuna * 0.38f

        moveTo(cx, cy - r)
        lineTo(cx + 0.201f * r, cy - 0.486f * r)
        lineTo(cx + 0.707f * r, cy - 0.707f * r)
        lineTo(cx + 0.486f * r, cy - 0.201f * r)
        lineTo(cx + r, cy)
        lineTo(cx + 0.486f * r, cy + 0.201f * r)
        lineTo(cx + 0.707f * r, cy + 0.707f * r)
        lineTo(cx + 0.201f * r, cy + 0.486f * r)
        lineTo(cx, cy + r)
        lineTo(cx - 0.201f * r, cy + 0.486f * r)
        lineTo(cx - 0.707f * r, cy + 0.707f * r)
        lineTo(cx - 0.486f * r, cy + 0.201f * r)
        lineTo(cx - r, cy)
        lineTo(cx - 0.486f * r, cy - 0.201f * r)
        lineTo(cx - 0.707f * r, cy - 0.707f * r)
        lineTo(cx - 0.201f * r, cy - 0.486f * r)
        close()
    }

    val formaEstrella12 = GenericShape { size, _ ->
        val m = size.width * 0.035f
        val cx = m + 0.27f * (size.width - 2f * m)
        val cy = m + 0.78f * (size.height - 2f * m)
        val r = size.height * 0.095f

        moveTo(cx, cy - r)
        lineTo(cx + 0.186f * r, cy - 0.695f * r)
        lineTo(cx + 0.5f * r, cy - 0.866f * r)
        lineTo(cx + 0.509f * r, cy - 0.509f * r)
        lineTo(cx + 0.866f * r, cy - 0.5f * r)
        lineTo(cx + 0.695f * r, cy - 0.186f * r)
        lineTo(cx + r, cy)
        lineTo(cx + 0.695f * r, cy + 0.186f * r)
        lineTo(cx + 0.866f * r, cy + 0.5f * r)
        lineTo(cx + 0.509f * r, cy + 0.509f * r)
        lineTo(cx + 0.5f * r, cy + 0.866f * r)
        lineTo(cx + 0.186f * r, cy + 0.695f * r)
        lineTo(cx, cy + r)
        lineTo(cx - 0.186f * r, cy + 0.695f * r)
        lineTo(cx - 0.5f * r, cy + 0.866f * r)
        lineTo(cx - 0.509f * r, cy + 0.509f * r)
        lineTo(cx - 0.866f * r, cy + 0.5f * r)
        lineTo(cx - 0.695f * r, cy + 0.186f * r)
        lineTo(cx - r, cy)
        lineTo(cx - 0.695f * r, cy - 0.186f * r)
        lineTo(cx - 0.866f * r, cy - 0.5f * r)
        lineTo(cx - 0.509f * r, cy - 0.509f * r)
        lineTo(cx - 0.5f * r, cy - 0.866f * r)
        lineTo(cx - 0.186f * r, cy - 0.695f * r)
        close()
    }

    val formaSolAnillo = GenericShape { size, _ ->
        val m = size.width * 0.035f
        val x = m + 0.27f * (size.width - 2f * m)
        val y = m + 0.78f * (size.height - 2f * m)
        val r = size.height * 0.095f * 0.58f

        addOval(Rect(x - r, y - r, x + r, y + r))
    }

    val formaSolCentro = GenericShape { size, _ ->
        val m = size.width * 0.035f
        val x = m + 0.27f * (size.width - 2f * m)
        val y = m + 0.78f * (size.height - 2f * m)
        val r = size.height * 0.095f * 0.42f

        addOval(Rect(x - r, y - r, x + r, y + r))
    }

    Box(
        modifier = modifier
            .width(240.dp)
            .height(290.dp)
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(carmesi, formaBandera)
                .border(16.8.dp, azul, formaBandera)
        )

        Box(Modifier.fillMaxSize().background(blanco, formaLuna))
        Box(Modifier.fillMaxSize().background(carmesi, formaLunaHueco))
        Box(Modifier.fillMaxSize().background(blanco, formaEstrella8))

        Box(Modifier.fillMaxSize().background(blanco, formaEstrella12))
        Box(Modifier.fillMaxSize().background(carmesi, formaSolAnillo))
        Box(Modifier.fillMaxSize().background(blanco, formaSolCentro))
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaNepalPreview() {
    Surface { BanderaNepal(Modifier.padding(16.dp)) }
}