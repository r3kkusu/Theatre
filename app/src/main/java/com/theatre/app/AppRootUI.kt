package com.theatre.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theatre.app.ui.theme.DeepBlue

@Composable
fun AppRootUI() {
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
        .padding(15.dp)) {
        HomeScreen()
    }
}
