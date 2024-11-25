package com.example.composecomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun Screen1(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Cyan)
            .clickable { navController.navigate("pantalla2") }
    ) {
        Text(text = "Pantalla 1", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun Screen2(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green)
            .clickable { navController.navigate("pantalla3") }
    ) {
        Text(text = "Pantalla 2", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun Screen3(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Magenta)
            .clickable { navController.navigate("pantalla4/KevynMelo") }
    ) {
        Text(text = "Pantalla 3", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun Screen4(navController: NavHostController, name: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
    ) {
        Text(text = "Pantalla 4 ${name}", modifier = Modifier.align(Alignment.Center))
    }
}