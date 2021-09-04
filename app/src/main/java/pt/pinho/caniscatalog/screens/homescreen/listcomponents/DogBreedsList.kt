package pt.pinho.caniscatalog.screens.homescreen.listcomponents

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import kotlinx.coroutines.flow.Flow
import pt.pinho.caniscatalog.data.model.DogBreed
import pt.pinho.caniscatalog.screens.homescreen.listcomponents.columnview.DogBreedsColumnView
import pt.pinho.caniscatalog.screens.homescreen.listcomponents.gridview.DogBreedsGridView

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun DogBreedsList(dogBreedList: Flow<PagingData<DogBreed>>, showListAsGrid: MutableState<Boolean>, navController: NavController) {

    val lazyDogBreedList = dogBreedList.collectAsLazyPagingItems()

    if (showListAsGrid.value)
    {
        DogBreedsGridView(lazyDogBreedList, navController)
    }
    else
    {
        DogBreedsColumnView(lazyDogBreedList, navController)
    }
}