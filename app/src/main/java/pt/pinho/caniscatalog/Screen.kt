package pt.pinho.caniscatalog

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, @StringRes val titleResourceId: Int, val icon : ImageVector) {
    object Home : Screen(route = "home", titleResourceId = R.string.home, icon= Icons.Filled.Home)
    object Search : Screen( route = "search", titleResourceId = R.string.search, icon= Icons.Filled.Search)
}