package com.example.banderas.Screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.banderas.R
import com.example.banderas.ui.theme.BanderasTheme

class Bandera_Brasil : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanderasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        val verde = colorResource(id = R.color.verde_bandera)
                        val amarillo = colorResource(id = R.color.amarillo_bandera)

                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.9f)
                                .aspectRatio(3f / 2f)
                                .background(verde)
                        ) {
                            Canvas(modifier = Modifier.fillMaxSize()) {
                                val w = size.width
                                val h = size.height

                                val diamond = Path().apply {
                                    moveTo(w / 2f, h * 0.08f)   // arriba
                                    lineTo(w * 0.92f, h / 2f)   // derecha
                                    lineTo(w / 2f, h * 0.92f)   // abajo
                                    lineTo(w * 0.08f, h / 2f)   // izquierda
                                    close()
                                }
                                drawPath(path = diamond, color = amarillo)
                            }

                            Image(
                                painter = painterResource(id = R.drawable.brasil),
                                contentDescription = "Globo con estrellas",
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(340.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}