package pt.pinho.caniscatalog.screens.homescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import kotlinx.coroutines.flow.Flow
import pt.pinho.caniscatalog.R
import pt.pinho.caniscatalog.component.CenteredCircularLoader
import pt.pinho.caniscatalog.data.model.DogBreed

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun DogBreedsList(dogBreedList: Flow<PagingData<DogBreed>>, navController: NavController) {

    val lazyDogBreedList = dogBreedList.collectAsLazyPagingItems()
    val showListAsGrid = remember { mutableStateOf(false) }

    Column {
        ListTypeSelectorHeader(showListAsGrid)

        if (showListAsGrid.value)
        {
            DogBreedsGridView(lazyDogBreedList, navController)
        }
        else
        {
            DogBreedsListView(lazyDogBreedList, navController)
        }
    }
}

@Composable
fun ListTypeSelectorHeader(switchValue: MutableState<Boolean>)
{
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Text(text = stringResource(R.string.show_list_as_grid))
        Spacer(modifier = Modifier.width(12.dp))
        Switch(checked = switchValue.value, onCheckedChange = { switchValue.value = it })
    }
}

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
            dogBreed?.let { DogBreedListItem(it, navController) }
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

@ExperimentalCoilApi
@Composable
fun DogBreedsListView(lazyDogBreedList: LazyPagingItems<DogBreed>, navController: NavController)
{
    LazyColumn {
        items(lazyDogBreedList) { dogBreed ->
            dogBreed?.let { DogBreedListItem(it, navController) }
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