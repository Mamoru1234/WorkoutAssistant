package com.example.workoutassistant.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.workoutassistant.AppNavItem
import com.example.workoutassistant.data.getAllExercises
import com.example.workoutassistant.model.NewTrainingModel
import com.example.workoutassistant.vendor.activityViewModel
import java.util.*

@Composable
fun SetupExerciseScreen(navController: NavController, entry: NavBackStackEntry, viewModel: NewTrainingModel = activityViewModel()) {
    val exerciseId = entry.arguments?.getString("exercise_id")?.let(UUID::fromString)
    val exerciseData = getAllExercises().find { exerciseData -> exerciseData.id == exerciseId }!!
    Column {
        Text(text = "Setup exercise")
        Text(text = stringResource(id = exerciseData.title))
        Button(onClick = {
            viewModel.selectExercise(exerciseData)
            navController.navigate(AppNavItem.NEW_TRAINING.route) {
                popUpTo(AppNavItem.NEW_TRAINING.route) {
                    inclusive = true
                }
            }
        }) {
            Text(text = "Done")
        }
    }
}