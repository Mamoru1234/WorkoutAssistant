package com.example.workoutassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.workoutassistant.ui.screen.MainScreen
import com.example.workoutassistant.ui.theme.WorkoutAssistantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutAssistantTheme {
                val navController = rememberNavController()
                Scaffold {
                    NavHost(
                        navController = navController,
                        startDestination = "main",
                        modifier = Modifier.padding(it)
                    ) {
                        composable("main") {
                            MainScreen(navController)
                        }
                        composable("new_training") {
                            Text(text = "New training")
                        }
                    }
                }
            }
        }
    }
}