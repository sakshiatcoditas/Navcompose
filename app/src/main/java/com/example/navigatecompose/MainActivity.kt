package com.example.navigatecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1") { Screen1(navController) }
        composable("screen2") { Screen2(navController) }
    }
}

@Composable
fun Screen1(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Text indicating Screen 1
            Text(
                text = "This is Screen 1",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(24.dp)) // space between text and button

            // Button to navigate
            Button(onClick = { navController.navigate("screen2") }) {
                Text("Go to Screen 2")
            }
        }
    }
}

@Composable
fun Screen2(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Text indicating Screen 2
            Text(
                text = "This is Screen 2",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Button to navigate back
            Button(onClick = { navController.navigate("screen1") }) {
                Text("Back to Screen 1")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
