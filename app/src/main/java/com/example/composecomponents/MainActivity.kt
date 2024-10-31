package com.example.composecomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecomponents.ui.theme.ComposeComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyTextFieldOutlined(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeComponentsTheme {
        MyTextFieldOutlined()
    }
}

@Composable
fun MyText(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Este es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.Underline, TextDecoration.LineThrough
                    )
                )
            )
        )
    }
}

@Composable
fun MyTextField(modifier: Modifier = Modifier) {
    var myText by remember { mutableStateOf("") }
    TextField(value = myText, onValueChange = { myText = it })
}

@Composable
fun MyTextFieldAdvance(modifier: Modifier = Modifier) {
    var myText by remember { mutableStateOf("") }
    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a","")
            } else {
                it
            }

        },
        label = { Text(text = "Introduce tu nombre") })
}

@Composable
fun MyTextFieldOutlined(modifier: Modifier = Modifier){
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(value = myText, onValueChange = { myText = it })
}