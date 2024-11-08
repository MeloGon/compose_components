package com.example.composecomponents

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun PreviewSwitch() {
    MySwitch()
}

@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    var state by rememberSaveable { mutableStateOf(true) }
    Switch(checked = state, onCheckedChange = {
        state = !state
    })
}