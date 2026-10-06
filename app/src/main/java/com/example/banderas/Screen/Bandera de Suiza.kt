package com.example.banderas.Screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaSuiza()
        }
    }
}

// Pantalla: fondo blanco y la bandera centrada
@Composable
fun PantallaSuiza() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            BanderaSuiza()
        }
    }
}

// Suiza: bandera CUADRADA (aspectRatio 1f) con una cruz blanca centrada
@Composable
fun BanderaSuiza(modifier: Modifier = Modifier) {
    val rojo = colorResource(R.color.suiza_rojo)
    val blanco = colorResource(R.color.suiza_blanco)

    Box(
        modifier = modifier
            .fillMaxWidth(0.8f)   // 80% del ancho de la pantalla
            .aspectRatio(1f)      // siempre cuadrada
            .background(rojo)
    ) {
        // Brazo vertical de la cruz
        Box(
            Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.2f)
                .fillMaxHeight(0.62f)
                .background(blanco)
        )
        // Brazo horizontal de la cruz
        Box(
            Modifier
                .align(Alignment.Center)
                .fillMaxHeight(0.2f)
                .fillMaxWidth(0.62f)
                .background(blanco)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSuizaPreview() {
    PantallaSuiza()
}