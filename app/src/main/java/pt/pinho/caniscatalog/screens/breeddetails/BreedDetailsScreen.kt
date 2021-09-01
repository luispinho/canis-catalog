package pt.pinho.caniscatalog.screens.breeddetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pt.pinho.caniscatalog.component.CenteredCircularLoader
import pt.pinho.caniscatalog.data.model.DogBreed
import pt.pinho.caniscatalog.screens.UiState

@Composable
fun BreedDetailsScreen(breedDetailsViewModel: BreedDetailsViewModel, breedId: Long?) {

    val uiState: UiState by breedDetailsViewModel.uiState.observeAsState(UiState.NoData)
    val uiBreed: DogBreed by breedDetailsViewModel.uiBreed.observeAsState(DogBreed())

    LaunchedEffect(breedId) {
        if (breedId != null) {
            breedDetailsViewModel.getDogBreedById(breedId)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        if (uiState == UiState.Loaded)
        {
            Column {
                Text(
                    text = uiBreed.name,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = uiBreed.breedGroup,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = uiBreed.origin,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = uiBreed.temperament,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
            }
        }
        else if (uiState == UiState.Loading)
        {
            CenteredCircularLoader()
        }
    }
}
