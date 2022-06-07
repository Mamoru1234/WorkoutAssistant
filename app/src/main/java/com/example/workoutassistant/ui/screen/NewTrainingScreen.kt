package com.example.workoutassistant.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.workoutassistant.AppNavItem
import com.example.workoutassistant.model.NewTrainingModel
import com.example.workoutassistant.vendor.activityViewModel

@Composable
fun NewTrainingScreen(navController: NavController, viewModel: NewTrainingModel = activityViewModel()) {
    Column {
        Text("New train screen")
        val selectedExercises by viewModel.selectedExercises.collectAsState()
        LazyColumn{
            items(selectedExercises, key = { it.id }) {
                Text(text = stringResource(id = it.exerciseData.title))
            }
        }
        Button(onClick = { navController.navigate(AppNavItem.SELECT_EXERCISE.route) }) {
            Text("Select exercise")
        }
    }
}
