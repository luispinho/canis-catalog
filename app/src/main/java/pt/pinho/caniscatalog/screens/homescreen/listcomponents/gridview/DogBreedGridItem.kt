package pt.pinho.caniscatalog.screens.homescreen.listcomponents.gridview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import pt.pinho.caniscatalog.data.model.DogBreed

@ExperimentalCoilApi
@Composable
fun DogBreedGridItem(dogBreed: DogBreed, navController: NavController) {
    Card (
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.LightGray,
        border = BorderStroke(0.5.dp, Color.Black),
        modifier = Modifier.padding(4.dp).height(190.dp),
    ) {
        Column(modifier = Modifier.clickable(
            onClick = { navController.navigate("breed_details/${dogBreed.id}")
            }
        ).padding(2.dp)
        ) {
            dogBreed.name.let {
                Image(
                    painter = rememberImagePainter(dogBreed.image.url),
                    contentDescription = null,
                    modifier = Modifier.size(128.dp)
                )
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 10.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}