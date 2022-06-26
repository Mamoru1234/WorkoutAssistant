package com.example.workoutassistant.db

import android.content.Context
import androidx.room.Room
import com.example.workoutassistant.db.dao.TrainingDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext app: Context
    ): AppDatabase = Room
        .databaseBuilder(
            app,
            AppDatabase::class.java,
            "workout_assistant"
        )
        .fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideTrainingDao(db: AppDatabase): TrainingDao = db.trainingDao()
}