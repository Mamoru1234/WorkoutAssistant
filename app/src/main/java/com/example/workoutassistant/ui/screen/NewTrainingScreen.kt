package com.example.workoutassistant.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.workoutassistant.AppNavItem

@Composable
fun NewTrainingScreen(navController: NavController) {
    Column {
        Text("New train screen")
        Button(onClick = { navController.navigate(AppNavItem.SELECT_EXERCISE.route) }) {
            Text("Select exercise")
        }
    }
}
