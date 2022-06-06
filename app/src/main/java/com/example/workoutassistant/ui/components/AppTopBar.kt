package com.example.workoutassistant.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.workoutassistant.AppNavItem

@Composable
fun AppTopBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentNavItem by remember {
        derivedStateOf { AppNavItem.values().find { navBackStackEntry?.destination?.route == it.route } }
    }
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },
        title = { Text(currentNavItem?.title ?: "App Top bar") },
        backgroundColor = MaterialTheme.colors.primary)
}
