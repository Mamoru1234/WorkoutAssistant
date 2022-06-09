package com.example.workoutassistant.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workoutassistant.data.ExerciseDuration
import com.example.workoutassistant.data.ExerciseType
import com.example.workoutassistant.ui.theme.WorkoutAssistantTheme
import java.time.Duration

@Composable
fun ExerciseDurationView(duration: ExerciseDuration, type: ExerciseType, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.Bottom) {
        if (type !== ExerciseType.Timing) {
            Text(text = "X")
        }
        Text(text = duration.format(type))
        if (type === ExerciseType.DoubleCountable) {
            Text(
                text = "each side",
                style = MaterialTheme.typography.overline,
                modifier = Modifier.padding(PaddingValues(horizontal = 4.dp, vertical = 1.dp)))
        }
        if (type === ExerciseType.Timing) {
            Text(text = "seconds", Modifier.padding(horizontal = 2.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExerciseDurationViewCountable() {
    WorkoutAssistantTheme {
        ExerciseDurationView(duration = ExerciseDuration.fromCount(2), type = ExerciseType.Countable)
    }
}

@Preview(showBackground = true)
@Composable
fun ExerciseDurationViewDoubleCountable() {
    WorkoutAssistantTheme {
        ExerciseDurationView(duration = ExerciseDuration.fromCount(2), type = ExerciseType.DoubleCountable)
    }
}

@Preview(showBackground = true)
@Composable
fun ExerciseDurationViewTime() {
    WorkoutAssistantTheme {
        ExerciseDurationView(duration = ExerciseDuration.fromTime(Duration.ofSeconds(20)), type = ExerciseType.Timing)
    }
}
