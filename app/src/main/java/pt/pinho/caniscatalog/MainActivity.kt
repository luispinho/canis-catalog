package pt.pinho.caniscatalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.*
import dagger.hilt.android.AndroidEntryPoint
import pt.pinho.caniscatalog.screens.search.SearchScreen
import pt.pinho.caniscatalog.screens.breeddetails.BreedDetailsScreen
import pt.pinho.caniscatalog.screens.breeddetails.BreedDetailsViewModel
import pt.pinho.caniscatalog.screens.homescreen.HomeScreen
import pt.pinho.caniscatalog.screens.homescreen.HomeScreenViewModel
import pt.pinho.caniscatalog.screens.search.SearchScreenViewModel
import pt.pinho.caniscatalog.ui.theme.CanisCatalogTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeScreenViewModel: HomeScreenViewModel by viewModels()
    private val breedDetailsScreenViewModel: BreedDetailsViewModel by viewModels()
    private val searchScreenScreenViewModel: SearchScreenViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen(homeScreenViewModel, breedDetailsScreenViewModel, searchScreenScreenViewModel)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MainScreen(homeScreenViewModel: HomeScreenViewModel,
               breedDetailsScreenViewModel: BreedDetailsViewModel,
               searchScreenScreenViewModel: SearchScreenViewModel
) {

    CanisCatalogTheme {
        val items = listOf(
            Screen.Home,
            Screen.Search
        )
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                if (currentDestination?.route != Screen.BreedDetails.route) {
                    BottomNavigation {
                        items.forEach { screen ->
                            BottomNavigationItem(
                                icon = { Icon(screen.icon, contentDescription = null) },
                                label = { Text(stringResource(screen.titleResourceId)) },
                                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                onClick = {
                                    navController.navigate(screen.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            NavHost(navController, startDestination = Screen.Home.route, Modifier.padding(innerPadding)) {
                composable(Screen.Home.route) { HomeScreen(homeScreenViewModel, navController) }
                composable(Screen.BreedDetails.route, arguments = listOf(navArgument("breedId") { type = NavType.LongType })) { backStackEntry -> BreedDetailsScreen(breedDetailsScreenViewModel, backStackEntry.arguments?.getLong("breedId")) }
                composable(Screen.Search.route) { SearchScreen(searchScreenScreenViewModel, navController) }
            }
        }
    }
}