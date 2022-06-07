package com.example.workoutassistant.data

import androidx.annotation.StringRes
import com.example.workoutassistant.R
import java.util.*

data class ExerciseData(
    val id: UUID,
    @StringRes val title: Int
)

fun getAllExercises(): List<ExerciseData> {
    return listOf(
        ExerciseData(
            UUID.fromString("f213779c-6cdd-47ea-9cd6-9f8fa74ea367"),
            R.string.push_up,
        )
    )
}
