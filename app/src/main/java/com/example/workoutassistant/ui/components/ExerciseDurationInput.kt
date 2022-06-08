package com.example.workoutassistant.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workoutassistant.data.ExerciseDuration
import com.example.workoutassistant.data.ExerciseType
import com.example.workoutassistant.data.getAllExercises
import com.example.workoutassistant.ui.theme.WorkoutAssistantTheme

@Composable
fun ExerciseDurationInput(
    value: ExerciseDuration,
    type: ExerciseType,
    onChange: (type: ExerciseDuration) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        if (type === ExerciseType.DoubleCountable) {
            Text(text = "Each side")
        }
        Row {
            Icon(Icons.Filled.Remove, "decrease", Modifier.clickable {
                onChange(value.decrease(type))
            })
            Text(text = formatDuration(value, type), modifier = Modifier
                .padding(PaddingValues(horizontal = 4.dp)))
            Icon(Icons.Filled.Add, "increase", Modifier.clickable {
                onChange(value.increase(type))
            })
        }   
    }
}

fun formatDuration(value: ExerciseDuration, type: ExerciseType): String {
    return when(type) {
        ExerciseType.Timing -> value.time.seconds.toString()
        ExerciseType.DoubleCountable -> (value.count / 2).toString()
        ExerciseType.Countable -> value.count.toString()
    }
}

@Preview(showBackground = true)
@Composable
fun ExerciseDurationInputPreview() {
    WorkoutAssistantTheme {
        val exerciseData = getAllExercises()[0]
        ExerciseDurationInput(value = exerciseData.defaultDuration, exerciseData.type, onChange = {})
    }
}