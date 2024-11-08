package com.example.composecomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecomponents.data.CheckInfo
import com.example.composecomponents.ui.theme.ComposeComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    var myText by remember { mutableStateOf("") }
//                    MyTextField(
//                        modifier = Modifier.padding(innerPadding),
//                        name = "Holi"
//
//                    ) {
//                        myText = it
//                    }
//                    MyIcon(modifier = Modifier.padding(innerPadding))
//                    MyCheckboxWithText(modifier = Modifier.padding(innerPadding))
//                    var status by rememberSaveable { mutableStateOf(false) }
//                    val checkInfo = CheckInfo(
//                        title = "Este es el bueno",
//                        selected = status,
//                        onCheckedChange = { myNewStatus -> status = myNewStatus })
//                    MyCheckboxWithTextCompleted(checkInfo = checkInfo)
                    val myOptions = getOptions(listOf("Kevyn","Ejemplo","Pokemon"))
                    Column {
                        myOptions.forEach{
                            MyCheckboxWithTextCompleted(checkInfo = it)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeComponentsTheme {
        TestComponent()
    }
}

@Composable
fun TestComponent() {
    MyTextField(name = "Holi2") { }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus })
    }

}

