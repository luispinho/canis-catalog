package pt.pinho.caniscatalog.screens.homescreen.listcomponents.columnview

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import pt.pinho.caniscatalog.component.CenteredCircularLoader
import pt.pinho.caniscatalog.data.model.DogBreed

@ExperimentalCoilApi
@Composable
fun DogBreedsColumnView(lazyDogBreedList: LazyPagingItems<DogBreed>, navController: NavController)
{
    LazyColumn {
        items(lazyDogBreedList) { dogBreed ->
            dogBreed?.let { DogBreedColumnItem(it, navController) }
        }

        lazyDogBreedList.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { CenteredCircularLoader() }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = lazyDogBreedList.loadState.refresh as LoadState.Error
                    item { Text(e.error.localizedMessage!!) }
                }
                loadState.append is LoadState.Error -> {
                    val e = lazyDogBreedList.loadState.append as LoadState.Error
                    item { Text(e.error.localizedMessage!!) }
                }
            }
        }
    }
}