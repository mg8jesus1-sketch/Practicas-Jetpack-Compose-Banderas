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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

@Composable
fun BanderaSudafrica(modifier: Modifier = Modifier) {
    val rojo = colorResource(R.color.rojo)
    val azul = colorResource(R.color.azul)
    val verde = colorResource(R.color.verde)
    val dorado = colorResource(R.color.dorado)
    val negro = colorResource(R.color.negro)
    val blanco = colorResource(R.color.blanco)

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(3f / 2f)
            .clipToBounds()
    ) {
        val w = size.width
        val h = size.height

        drawRect(rojo, size = Size(w, h / 2f))
        drawRect(azul, topLeft = Offset(0f, h / 2f), size = Size(w, h / 2f))

        val esquinaSup = Offset(0f, 0f)
        val esquinaInf = Offset(0f, h)
        val apice = Offset(w * 0.36f, h / 2f)
        val bordeDer = Offset(w, h / 2f)

        drawLine(blanco, esquinaSup, apice, h * 0.30f, StrokeCap.Round)
        drawLine(blanco, esquinaInf, apice, h * 0.30f, StrokeCap.Round)
        drawLine(blanco, apice, bordeDer, h * 0.30f, StrokeCap.Round)

        drawLine(verde, esquinaSup, apice, h * 0.20f, StrokeCap.Round)
        drawLine(verde, esquinaInf, apice, h * 0.20f, StrokeCap.Round)
        drawLine(verde, apice, bordeDer, h * 0.20f, StrokeCap.Round)

        val dorado1 = Path()
        dorado1.moveTo(0f, h * 0.136f)
        dorado1.lineTo(0f, h * 0.864f)
        dorado1.lineTo(w * 0.262f, h / 2f)
        dorado1.close()
        drawPath(dorado1, dorado)

        val negro1 = Path()
        negro1.moveTo(0f, h * 0.191f)
        negro1.lineTo(0f, h * 0.809f)
        negro1.lineTo(w * 0.223f, h / 2f)
        negro1.close()
        drawPath(negro1, negro)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSudafricaPreview() {
    Surface { BanderaSudafrica() }
}