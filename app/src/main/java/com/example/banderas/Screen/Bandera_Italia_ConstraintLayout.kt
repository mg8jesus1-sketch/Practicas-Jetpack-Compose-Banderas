package com.example.banderas.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.R

@Composable
fun Bandera_Italia_ConstraintLayout() {
    // Contenedor que centra la bandera en la pantalla
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Proporción oficial 3:2
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .aspectRatio(3f / 2f)
        ) {
            val (verde, blanco, rojo) = createRefs()

            // Las tres franjas se reparten el ancho en partes iguales
            createHorizontalChain(verde, blanco, rojo, chainStyle = ChainStyle.Spread)

            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.italia_verde))
                    .constrainAs(verde) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
            )

            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.italia_blanco))
                    .constrainAs(blanco) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
            )

            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.italia_rojo))
                    .constrainAs(rojo) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBanderaItalia() {
    Bandera_Italia_ConstraintLayout()
}