package com.example.workoutassistant.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.workoutassistant.AppNavItem
import com.example.workoutassistant.model.NewTrainingModel
import com.example.workoutassistant.vendor.activityViewModel

@Composable
fun SelectExerciseScreen(navController: NavController, viewModel: NewTrainingModel = activityViewModel()) {
    Column {
        Text("Select exercise screen")
        LazyColumn{
            items(viewModel.exercises, key = { it.id }) {
                Text(text = stringResource(it.title), modifier = Modifier.clickable {
                    navController.navigate("setup_exercise?exercise_id=${it.id}")
                })
            }
        }
    }
}
