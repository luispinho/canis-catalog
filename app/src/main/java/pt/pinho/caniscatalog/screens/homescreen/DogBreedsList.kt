package pt.pinho.caniscatalog.screens.homescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import pt.pinho.caniscatalog.data.model.DogBreed

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun DogBreedsList(dogBreedList: List<DogBreed>, navController: NavController) {
    //Normal List implementation
//    LazyColumn {
//        items(dogBreedList) { dogBreed ->
//            DogBreedListItem(dogBreed)
//        }
//    }

    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        items(dogBreedList) { dogBreed ->
            DogBreedListItem(dogBreed, navController)
        }
    }
}