package com.example.composecomponents

import android.widget.RadioButton
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true)
@Composable
fun PreviewRadioButton() {
    MyRadioButtonList()
}


@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = false, onClick = {}, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green
            )
        )
        Text(text = "Ejemplo")
    }

}

@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {
    var selected by rememberSaveable { mutableStateOf("Kevyn") }
    Column(modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selected == "Kevyn",
                onClick = {
                    selected = "Kevyn"
                },
            )
            Text(text = "Kevyn")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selected == "Pancho",
                onClick = {
                    selected = "Pancho"
                },
            )
            Text(text = "Pancho")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selected == "Sara",
                onClick = {
                    selected = "Sara"
                },
            )
            Text(text = "Sara")
        }
    }
}

//statehoisting
@Composable
fun MyRadioButtonListHoistin(
    modifier: Modifier = Modifier,
    name: String,
    onItemSelected: (String) -> Unit
) {

    Column(modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Kevyn",
                onClick = {
                    onItemSelected("Kevyn")
                },
            )
            Text(text = "Kevyn")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Pancho",
                onClick = {
                    onItemSelected("Pancho")
                },
            )
            Text(text = "Pancho")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Sara",
                onClick = {
                    onItemSelected("Sara")
                },
            )
            Text(text = "Sara")
        }
    }
}