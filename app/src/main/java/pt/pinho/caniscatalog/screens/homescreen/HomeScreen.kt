package pt.pinho.caniscatalog.screens.homescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import pt.pinho.caniscatalog.screens.homescreen.listcomponents.DogBreedsList
import pt.pinho.caniscatalog.screens.homescreen.listcomponents.ListTypeSelectorHeader

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel, navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column {
            ListTypeSelectorHeader(homeScreenViewModel.showListAsGrid)

            DogBreedsList(homeScreenViewModel.breeds, homeScreenViewModel.showListAsGrid, navController)
        }
    }
}

