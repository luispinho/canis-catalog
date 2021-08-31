package pt.pinho.caniscatalog.screens.homescreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import pt.pinho.caniscatalog.data.model.DogBreed

@ExperimentalCoilApi
@Composable
fun DogBreedListItem(dogBreed: DogBreed) {
    Card (
        shape = RoundedCornerShape(3.dp),
        backgroundColor = Color.LightGray,
        border = BorderStroke(0.5.dp, Color.Black),
        modifier = Modifier.padding(4.dp).fillMaxSize(),
    ) {
        Column(
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
                        .padding(start = 10.dp)
                )
            }
        }
    }
}