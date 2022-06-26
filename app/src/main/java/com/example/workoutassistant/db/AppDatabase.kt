package com.example.workoutassistant.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.workoutassistant.db.dao.TrainingDao
import com.example.workoutassistant.db.entity.TrainingEntity

@Database(entities = [TrainingEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trainingDao(): TrainingDao
}
