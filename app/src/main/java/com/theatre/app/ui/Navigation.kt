package com.theatre.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.theatre.app.ExploreScreen
import com.theatre.app.HomeScreen
import com.theatre.app.data.model.NavigationRoute
import com.theatre.app.ui.screens.FavoriteScreen
import com.theatre.app.ui.screens.ProfileScreen
import com.theatre.app.ui.theme.BrightBlue
import com.theatre.app.ui.theme.DarkPastelBlue
import com.theatre.app.ui.theme.DeepBlue

@Composable
fun NavigationControl(navItems: List<NavigationRoute>) {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomNavigationBar(
            items = navItems,
            navigationController = navController,
            modifier = Modifier,
            onItemClick = {
                navController.navigate(it.route)
            }
        )
    }) {
        Box(modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()) {
            Navigation(navController = navController)
        }

    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home" ) {
        composable("home") { HomeScreen() }

        composable("explore") { ExploreScreen() }

        composable("favorite") { FavoriteScreen() }

        composable("profile") { ProfileScreen() }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<NavigationRoute>,
    navigationController: NavHostController,
    modifier: Modifier,
    onItemClick: (NavigationRoute) -> Unit
) {
    val backStackEntry = navigationController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = DeepBlue,
        elevation = 5.dp
    ) {
        items.forEach {
            val selected = it.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(it) },
                selectedContentColor = BrightBlue,
                unselectedContentColor = DarkPastelBlue,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(painter = painterResource(id = it.resource), contentDescription = it.name)
                        Spacer(modifier = Modifier.height(6.dp))
                        Box(
                            modifier = Modifier
                                .size(3.dp)
                                .clip(CircleShape)
                                .background(if (selected) BrightBlue else DeepBlue)
                        )
                    }
                }
            )
        }
    }
}
