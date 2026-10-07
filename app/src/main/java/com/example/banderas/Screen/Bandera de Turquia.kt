package com.example.banderas.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

@Composable
fun PantallaTurquia() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            BanderaTurquia()
        }
    }
}

@Composable
fun BanderaTurquia(modifier: Modifier = Modifier) {
    val rojo = colorResource(R.color.rojo)
    val blanco = colorResource(R.color.white)

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .aspectRatio(3f / 2f)
            .background(rojo)
    ) {
        val h = maxHeight
        val w = maxWidth
        val cx = w * 0.355f
        val cy = h / 2

        Box(
            Modifier
                .offset(x = cx - h * 0.25f, y = cy - h * 0.25f)
                .size(h * 0.5f)
                .background(blanco, CircleShape)
        )

        Box(
            Modifier
                .offset(x = cx + h * 0.0625f - h * 0.2f, y = cy - h * 0.2f)
                .size(h * 0.4f)
                .background(rojo, CircleShape)
        )

        Box(
            modifier = Modifier
                .offset(x = cx + h * 0.34f - h * 0.15f, y = cy - h * 0.15f)
                .size(h * 0.3f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "★",
                color = blanco,
                fontSize = with(LocalDensity.current) { (h * 0.2f).toSp() },
                modifier = Modifier.rotate(-90f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaTurquiaPreview() {
    PantallaTurquia()
}