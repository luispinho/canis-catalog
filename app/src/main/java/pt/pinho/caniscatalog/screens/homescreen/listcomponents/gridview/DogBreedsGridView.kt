package pt.pinho.caniscatalog.screens.homescreen.listcomponents.gridview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.annotation.ExperimentalCoilApi
import pt.pinho.caniscatalog.component.CenteredCircularLoader
import pt.pinho.caniscatalog.data.model.DogBreed

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun DogBreedsGridView(lazyDogBreedList: LazyPagingItems<DogBreed>, navController: NavController)
{
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        items(lazyDogBreedList) { dogBreed ->
            dogBreed?.let { DogBreedGridItem(it, navController) }
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

@ExperimentalFoundationApi
fun <T: Any> LazyGridScope.items(
    lazyPagingItems: LazyPagingItems<T>,
    itemContent: @Composable LazyItemScope.(value: T?) -> Unit
) {
    items(lazyPagingItems.itemCount) { index ->
        itemContent(lazyPagingItems[index])
    }
}