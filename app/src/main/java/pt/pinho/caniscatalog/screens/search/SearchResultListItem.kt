package pt.pinho.caniscatalog.screens.search

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import pt.pinho.caniscatalog.R
import pt.pinho.caniscatalog.data.model.DogBreed

@Composable
fun SearchResultListItem(dogBreed: DogBreed, navController: NavController) {
    Card (
        shape = RoundedCornerShape(3.dp),
        backgroundColor = Color.LightGray,
        border = BorderStroke(0.5.dp, Color.Black),
        modifier = Modifier.padding(4.dp).fillMaxSize(),
    ) {
        Column(modifier = Modifier.clickable(
            onClick = { navController.navigate("breed_details/${dogBreed.id}") }
        ).fillMaxWidth()
        ) {

            Text(
                text = "${stringResource(R.string.breed_name)}: ${dogBreed.name}",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp)
            )
            Text(
                text = "${stringResource(R.string.breed_group)}: ${dogBreed.breedGroup}",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp)
            )
            Text(
                text = "${stringResource(R.string.breed_origin)}: ${dogBreed.origin}",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp)
            )
        }
    }
}