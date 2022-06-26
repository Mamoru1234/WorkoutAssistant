package com.example.workoutassistant.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "training")
data class TrainingEntity(
    @PrimaryKey val id: String,
    @ColumnInfo() val name: String
)