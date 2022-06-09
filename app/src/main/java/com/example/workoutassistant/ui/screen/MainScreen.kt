package com.example.workoutassistant.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.workoutassistant.AppNavItem
import com.example.workoutassistant.model.NewTrainingModel
import com.example.workoutassistant.vendor.activityViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: NewTrainingModel = activityViewModel()) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            Text("Main screen")
            Button(onClick = {
                viewModel.setup()
                navController.navigate(AppNavItem.NEW_TRAINING.route)
            }) {
                Text("New training")
            }
        }
    }
}