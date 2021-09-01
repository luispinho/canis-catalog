package pt.pinho.caniscatalog.screens.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import pt.pinho.caniscatalog.data.model.DogBreed
import pt.pinho.caniscatalog.screens.UiState
import pt.pinho.caniscatalog.screens.homescreen.DogBreedsList

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun SearchScreen(searchScreenViewModel: SearchScreenViewModel, navController: NavController) {
    val breedList: List<DogBreed> by searchScreenViewModel.uiBreedList.observeAsState(emptyList())
    val uiState: UiState by searchScreenViewModel.uiState.observeAsState(UiState.NoData)

    var text by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column {
            Row {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Search") }
                )

                Button(onClick = { }, colors = ButtonDefaults.textButtonColors(
                )) {
                    Icon(Icons.Filled.Search, contentDescription = null)
                }
            }

        }
        if (uiState == UiState.Loaded)
        {
            DogBreedsList(breedList, navController)
        }
        else if (uiState == UiState.Loading)
        {
            CircularProgressIndicator()
        }
    }
}
