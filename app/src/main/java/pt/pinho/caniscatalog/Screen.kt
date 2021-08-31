package pt.pinho.caniscatalog

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, @StringRes val titleResourceId: Int, val icon : ImageVector) {
    object Home : Screen(route = "home", titleResourceId = R.string.home, icon= Icons.Filled.Home)
    object BreedDetails : Screen(route = "breed_details/{breedId}", titleResourceId = R.string.breed_details, icon= Icons.Filled.Info)
    object Search : Screen( route = "search", titleResourceId = R.string.search, icon= Icons.Filled.Search)
}