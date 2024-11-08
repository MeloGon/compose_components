package com.example.composecomponents

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PreviewButtons() {
    MyButtonExample()
}

@Composable
fun MyButtonExample(modifier: Modifier = Modifier) {
    //saveable soluciona el problema de la perdida de estado
    //en la rotacion
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = {
                Log.i("Kev", "Esto es un ejemplo")
                enabled = false
            },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.Blue
            ),
            border = BorderStroke(width = 5.dp, color = Color.Gray)
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            enabled = enabled,
            onClick = { enabled = false }, modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green,
                contentColor = Color.Red,
            ),
        ) {
            Text(text = "Hola")
        }

        TextButton(onClick = {}, modifier = Modifier.padding(top = 8.dp)) {
            Text(text = "Hola")
        }
    }
}