package com.example.workoutassistant.model

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.workoutassistant.data.ExerciseData
import com.example.workoutassistant.data.getAllExercises
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.*

class NewTrainingModel: ViewModel() {
    data class ExerciseItem(val id: UUID, val exerciseData: ExerciseData)
    val exercises = getAllExercises()

    private val _selectedExercises = MutableStateFlow(listOf<ExerciseItem>()) // private mutable state flow
    val selectedExercises = _selectedExercises.asStateFlow()

    init {
        Log.i("NewTrainingModel", "creating")
    }

    fun selectExercise(exerciseData: ExerciseData) {
        _selectedExercises.tryEmit(_selectedExercises.value + ExerciseItem(UUID.randomUUID(), exerciseData))
    }
}