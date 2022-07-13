package com.theatre.app

import androidx.compose.runtime.Composable
import com.theatre.app.data.model.NavigationRoute
import com.theatre.app.ui.NavigationControl

@Composable
fun TheatreApp() {
    val navigationItems = listOf(
        NavigationRoute("Home", "home", R.drawable.ic_baseline_home_24),
        NavigationRoute("Explore", "explore", R.drawable.ic_baseline_explore_24),
        NavigationRoute("Favorite", "favorite", R.drawable.ic_baseline_favorite_24),
        NavigationRoute("Profile", "profile", R.drawable.ic_baseline_person_24),
    )
    NavigationControl(navigationItems)

}