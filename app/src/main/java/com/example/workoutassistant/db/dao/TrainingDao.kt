package com.example.workoutassistant.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.workoutassistant.db.entity.TrainingEntity

@Dao
interface TrainingDao {
    @Insert
    suspend fun insertAll(vararg users: TrainingEntity)
}
