package edu.tec.dreamdrink.Activities.activity.activities


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.Navigation.findNavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.findNavController
import edu.tec.dreamdrink.R
import java.io.Console
import java.lang.reflect.*


@Composable
private fun Titulo(name: String) {

    Text(
        text = name,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(124.dp)
    )
}

@Preview
@Composable
fun InicioSesionDescription() {
    val navController = rememberNavController()
    Surface {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(start = 55.dp, top = 130.dp, bottom = 15.dp,end=25.dp)){
            Column {
                Text("Dream Drink", fontSize = 60.sp,color=Color(229,109,142))
                Image(painterResource(R.drawable.iconoprincipaltermo),
                    "content description",
                    modifier = Modifier
                        .width(374.dp)
                        .height(320.dp))
                Text("¿Por qué ir a un lugar a personalizar un termo si lo puedes hacer desde la comodidad de tu casa? La nueva forma de comprar y personalizar tu termos es mediante DreamDrink!", fontSize = 20.sp,color = Color(25,164,205)
                , textAlign = TextAlign.Center, modifier = Modifier.width(355.dp))
            }
        }
    }
}