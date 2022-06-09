package com.example.workoutassistant.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.workoutassistant.AppNavItem
import com.example.workoutassistant.data.ExerciseData
import com.example.workoutassistant.data.ExerciseDuration
import com.example.workoutassistant.model.NewTrainingModel
import com.example.workoutassistant.ui.components.ExerciseDurationView
import com.example.workoutassistant.vendor.activityViewModel

@Composable
fun NewTrainingScreen(navController: NavController, viewModel: NewTrainingModel = activityViewModel()) {
    Column {
        Text("New train screen")
        val selectedExercises by viewModel.selectedExercises.collectAsState()
        LazyColumn{
            items(selectedExercises, key = { it.id }) {
                TrainingExerciseItemView(exerciseData = it.exerciseData, duration = it.duration)
            }
        }
        Button(onClick = { navController.navigate(AppNavItem.SELECT_EXERCISE.route) }) {
            Text("Add exercise")
        }
    }
}

@Composable
fun TrainingExerciseItemView(exerciseData: ExerciseData, duration: ExerciseDuration) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(PaddingValues(all = 8.dp))) {
            Text(text = stringResource(exerciseData.title))
            Spacer(modifier = Modifier.padding(4.dp))
            ExerciseDurationView(duration = duration, type = exerciseData.type)
        }
    }
}
