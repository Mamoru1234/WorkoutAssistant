package com.example.workoutassistant.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workoutassistant.data.ExerciseData
import com.example.workoutassistant.data.ExerciseDuration
import com.example.workoutassistant.data.getAllExercises
import com.example.workoutassistant.db.dao.TrainingDao
import com.example.workoutassistant.db.entity.TrainingEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class NewTrainingModel @Inject constructor(
    private val trainingDao: TrainingDao
) : ViewModel() {
    data class ExerciseItem(val id: UUID, val exerciseData: ExerciseData, val duration: ExerciseDuration)
    val exercises = getAllExercises()

    private val _selectedExercises = MutableStateFlow(listOf<ExerciseItem>())
    val selectedExercises = _selectedExercises.asStateFlow()

    private val _trainingName = MutableStateFlow("")
    val trainingName = _trainingName.asStateFlow()

    suspend fun selectExercise(exerciseData: ExerciseData, duration: ExerciseDuration) {
        _selectedExercises.emit(_selectedExercises.value + ExerciseItem(UUID.randomUUID(), exerciseData, duration))
    }

    suspend fun setup() {
        _selectedExercises.emit(emptyList())
        _trainingName.emit("")
    }

    suspend fun changeTrainingName(newName: String) {
        _trainingName.emit(newName)
    }

    fun save() {
        viewModelScope.launch(Dispatchers.IO){
            trainingDao.insertAll(TrainingEntity(
                id = UUID.randomUUID().toString(),
                name = trainingName.value
            ))
            delay(1000)
            setup()
        }
    }
}