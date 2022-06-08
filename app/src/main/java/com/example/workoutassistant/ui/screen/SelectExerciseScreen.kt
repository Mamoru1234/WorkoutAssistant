package com.example.workoutassistant.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.workoutassistant.data.getAllExercises
import com.example.workoutassistant.model.NewTrainingModel
import com.example.workoutassistant.ui.theme.WorkoutAssistantTheme
import com.example.workoutassistant.vendor.activityViewModel

@Composable
fun SelectExerciseScreen(navController: NavController, viewModel: NewTrainingModel = activityViewModel()) {
    Column {
        Text("Select exercise screen")
        LazyColumn(Modifier.padding(PaddingValues(all= 4.dp))){
            items(viewModel.exercises, key = { it.id }) {
                ExerciseItemView(exerciseData = it) {
                    navController.navigate("setup_exercise?exercise_id=${it.id}")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExerciseItemView(exerciseData: ExerciseData, onClick: () -> Unit) {
    Card(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Text(text = stringResource(exerciseData.title), Modifier.padding(PaddingValues(all = 8.dp)))
    }
}

@Preview(showBackground = true)
@Composable
fun ExerciseItemPreView() {
    WorkoutAssistantTheme {
        ExerciseItemView(exerciseData = getAllExercises()[0]) {}
    }
}
