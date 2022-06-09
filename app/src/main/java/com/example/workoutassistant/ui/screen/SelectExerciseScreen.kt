package com.example.workoutassistant.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.workoutassistant.data.ExerciseData
import com.example.workoutassistant.data.ExerciseDuration
import com.example.workoutassistant.data.getAllExercises
import com.example.workoutassistant.model.NewTrainingModel
import com.example.workoutassistant.ui.components.ExerciseDurationView
import com.example.workoutassistant.ui.theme.WorkoutAssistantTheme
import com.example.workoutassistant.vendor.activityViewModel

@Composable
fun SelectExerciseScreen(navController: NavController, viewModel: NewTrainingModel = activityViewModel()) {
    Column {
        Text("Select exercise screen")
        LazyColumn(Modifier.padding(PaddingValues(all= 4.dp))){
            items(viewModel.exercises, key = { it.id }) {
                ExerciseItemView(exerciseData = it, duration = it.defaultDuration) {
                    navController.navigate("setup_exercise?exercise_id=${it.id}")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExerciseItemView(exerciseData: ExerciseData, duration: ExerciseDuration, onClick: () -> Unit = {}) {
    Card(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(PaddingValues(all = 8.dp))) {
            Text(text = stringResource(exerciseData.title))
            Spacer(modifier = Modifier.padding(4.dp))
            ExerciseDurationView(duration = duration, type = exerciseData.type)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExerciseItemPreView() {
    WorkoutAssistantTheme {
        val exerciseData = getAllExercises()[0]
        ExerciseItemView(exerciseData = exerciseData, exerciseData.defaultDuration) {}
    }
}
