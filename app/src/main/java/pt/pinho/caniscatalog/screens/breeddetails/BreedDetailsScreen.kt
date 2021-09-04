package pt.pinho.caniscatalog.screens.breeddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pt.pinho.caniscatalog.R
import pt.pinho.caniscatalog.shared.component.CenteredCircularLoader
import pt.pinho.caniscatalog.data.model.DogBreed
import pt.pinho.caniscatalog.screens.UiState

@Composable
fun BreedDetailsScreen(breedDetailsViewModel: BreedDetailsViewModel, breedId: Long?, navController: NavController) {

    val uiState: UiState by breedDetailsViewModel.uiState.observeAsState(UiState.Initial)
    val uiBreed: DogBreed by breedDetailsViewModel.uiBreed.observeAsState(DogBreed())

    LaunchedEffect(breedId) {
        if (breedId != null) {
            breedDetailsViewModel.getDogBreedById(breedId)
        }
    }

    Scaffold(topBar = { },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Localized description")
            }
        }, content = {
            if (uiState == UiState.Loaded) {
                Column {
                    Text(
                        text = "${stringResource(R.string.breed_name)}: ${uiBreed.name}",
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                    Text(
                        text = "${stringResource(R.string.breed_group)}: ${uiBreed.breedGroup}",
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                    Text(
                        text = "${stringResource(R.string.breed_origin)}: ${uiBreed.origin}",
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                    Text(
                        text = "${stringResource(R.string.breed_temperament)}: ${uiBreed.temperament}",
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
            } else if (uiState == UiState.Loading) {
                CenteredCircularLoader()
            } else if (uiState == UiState.Loading) {
                CenteredCircularLoader()
            }
        }
    )
}
