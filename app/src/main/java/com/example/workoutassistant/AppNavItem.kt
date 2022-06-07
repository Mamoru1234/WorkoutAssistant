package com.example.workoutassistant

enum class AppNavItem(val route: String, val title: String) {
    MAIN("main", "Main Screen"),
    NEW_TRAINING("new_training", "New Training"),
    SELECT_EXERCISE("select_exercise", "Select Exercise"),
    SETUP_EXERCISE("setup_exercise?exercise_id={exercise_id}", "Setup Exercise")
}
