package com.example.workoutassistant.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.workoutassistant.AppNavItem
import com.example.workoutassistant.data.ExerciseData
import com.example.workoutassistant.data.ExerciseDuration
import com.example.workoutassistant.model.NewTrainingModel
import com.example.workoutassistant.ui.components.ExerciseDurationView
import com.example.workoutassistant.vendor.activityViewModel
import kotlinx.coroutines.launch

@Composable
fun NewTrainingScreen(navController: NavController, viewModel: NewTrainingModel = activityViewModel()) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(PaddingValues(8.dp)),
        floatingActionButton = {
            Row {
                FloatingActionButton(onClick = {}) {
                    Icon(Icons.Filled.Add,"Add exercise")
                }
                FloatingActionButton(onClick = {}) {
                    Icon(Icons.Filled.Add,"Add exercise")
                }
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            val selectedExercises by viewModel.selectedExercises.collectAsState()
            val trainingName by viewModel.trainingName.collectAsState();
            OutlinedTextField(
                value = trainingName,
                onValueChange = { viewModel.viewModelScope.launch {
                    viewModel.changeTrainingName(it)
                } },
                label = { Text("Training name") }
            )
            LazyColumn {
                items(selectedExercises, key = { it.id }) {
                    TrainingExerciseItemView(exerciseData = it.exerciseData, duration = it.duration)
                }
            }
            Button(onClick = { navController.navigate(AppNavItem.SELECT_EXERCISE.route) }) {
                Text("Add exercise")
            }
            Button(
                onClick = { viewModel.save() }
            ) {
                Text("save")
            }
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
