package pt.pinho.caniscatalog.screens.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pt.pinho.caniscatalog.R
import pt.pinho.caniscatalog.shared.component.CenteredCircularLoader
import pt.pinho.caniscatalog.data.model.DogBreed
import pt.pinho.caniscatalog.screens.UiState
import pt.pinho.caniscatalog.screens.search.searchresults.SearchResultList

@ExperimentalFoundationApi
@Composable
fun SearchScreen(searchScreenViewModel: SearchScreenViewModel, navController: NavController) {
    val breedList: List<DogBreed> by searchScreenViewModel.uiBreedList.observeAsState(emptyList())
    val uiState: UiState by searchScreenViewModel.uiState.observeAsState(UiState.Initial)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
                ) {
                OutlinedTextField(
                    value = searchScreenViewModel.searchQuery.value,
                    onValueChange = { searchScreenViewModel.searchQuery.value = it },
                    label = { Text(stringResource(id = R.string.search_text_input_label)) },
                    shape = RoundedCornerShape(50),
                    trailingIcon = {
                        OutlinedButton(
                            onClick = { searchScreenViewModel.getBreedsBySearch(searchScreenViewModel.searchQuery.value) },
                            colors = ButtonDefaults.outlinedButtonColors(),
                            shape = RoundedCornerShape(50),
                            modifier = Modifier.padding(horizontal = 8.dp)
                        ){
                            Icon(Icons.Filled.Search, contentDescription = null)
                        }
                    }
                )
            }

            when (uiState) {
                UiState.Initial -> {}
                UiState.Loaded -> {
                    SearchResultList(breedList, navController)
                }
                UiState.Loading -> {
                    CenteredCircularLoader()
                }
                UiState.NoData -> {
                    Text(stringResource(id = R.string.no_results_found))
                }
                UiState.LoadingError -> {
                    Text(stringResource(id = R.string.loading_data_generic_error_message))
                }
            }
        }

    }
}
