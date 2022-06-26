package com.example.workoutassistant

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.workoutassistant.data.getAllExercises
import com.example.workoutassistant.ui.components.AppTopBar
import com.example.workoutassistant.ui.screen.MainScreen
import com.example.workoutassistant.ui.screen.NewTrainingScreen
import com.example.workoutassistant.ui.screen.SelectExerciseScreen
import com.example.workoutassistant.ui.screen.SetupExerciseScreen
import com.example.workoutassistant.ui.theme.WorkoutAssistantTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutAssistantTheme {
                val navController = rememberNavController()
                Scaffold (
                    topBar = { AppTopBar(navController = navController) },
                ){
                    NavHost(
                        navController = navController,
                        startDestination = AppNavItem.MAIN.route,
                        modifier = Modifier.padding(it)
                    ) {
                        composable(AppNavItem.MAIN.route) {
                            MainScreen(navController)
                        }
                        composable(AppNavItem.NEW_TRAINING.route) {
                            NewTrainingScreen(navController = navController)
                        }
                        composable(AppNavItem.SELECT_EXERCISE.route) {
                            SelectExerciseScreen(navController = navController)
                        }
                        composable(AppNavItem.SETUP_EXERCISE.route, listOf(navArgument("exercise_id") { type = NavType.StringType })) { entry ->
                            SetupExerciseScreen(navController = navController, entry)
                        }
                    }
                }
            }
        }
    }
}