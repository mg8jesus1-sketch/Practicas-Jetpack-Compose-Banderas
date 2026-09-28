package com.example.banderas.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.R

@Composable
fun Bandera_Mexico_ConstraintLayout() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(7f / 4f)   // proporción oficial de la bandera
        ) {
            val (verde, blanco, rojo, escudo) = createRefs()

            // Guía vertical al 33% y 66% para dividir en tres franjas
            val guia1 = createGuidelineFromStart(0.3333f)
            val guia2 = createGuidelineFromStart(0.6666f)

            // Franja verde
            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.mexico_verde))
                    .constrainAs(verde) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(guia1)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
            )

            // Franja blanca
            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.mexico_blanco))
                    .constrainAs(blanco) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(guia1)
                        end.linkTo(guia2)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
            )

            // Franja roja
            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.mexico_rojo))
                    .constrainAs(rojo) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(guia2)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
            )

            // Escudo centrado sobre la franja blanca
            Image(
                painter = painterResource(id = R.drawable.aguila),
                contentDescription = "Escudo de México",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(110.dp)
                    .constrainAs(escudo) {
                        top.linkTo(blanco.top)
                        bottom.linkTo(blanco.bottom)
                        start.linkTo(blanco.start)
                        end.linkTo(blanco.end)
                    }
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 420, heightDp = 300)
@Composable
fun BanderaMexicoConstraintPreview() {
    Bandera_Mexico_ConstraintLayout()
}