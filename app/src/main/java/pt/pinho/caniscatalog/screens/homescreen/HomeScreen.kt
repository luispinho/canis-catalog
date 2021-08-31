package pt.pinho.caniscatalog.screens.homescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import pt.pinho.caniscatalog.data.model.DogBreed
import androidx.compose.runtime.livedata.observeAsState

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel) {
    val breedList: List<DogBreed> by homeScreenViewModel.uiBreedList.observeAsState(emptyList())
    val uiState: UiState by homeScreenViewModel.uiState.observeAsState(UiState.NoData)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        if (uiState == UiState.Loaded)
        {
            DogBreedsList(breedList)
        }
        else if (uiState == UiState.Loading)
        {
            CircularProgressIndicator()
        }
    }
}
