package pt.pinho.caniscatalog.screens.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import pt.pinho.caniscatalog.data.model.DogBreed

@ExperimentalFoundationApi
@Composable
fun SearchResultList(dogBreedList: List<DogBreed>, navController: NavController) {
    LazyColumn {
        items(dogBreedList) { dogBreed ->
            SearchResultListItem(dogBreed, navController)
        }
    }
}