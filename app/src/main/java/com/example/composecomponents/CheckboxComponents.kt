package com.example.composecomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecomponents.data.CheckInfo

@Preview(showBackground = true)
@Composable
fun PreviewCheckbox() {
    MyCheckboxWithText()
}

@Composable
fun MyCheckbox(modifier: Modifier = Modifier) {
    var state by rememberSaveable { mutableStateOf(true) }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Green
        )
    )
}

@Composable
fun MyCheckboxWithText(modifier: Modifier = Modifier){
    var state by rememberSaveable { mutableStateOf(true) }
    Row (Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically){
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Blue
            )
        )
        Spacer(Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyCheckboxWithTextCompleted(modifier: Modifier = Modifier, checkInfo: CheckInfo){
    Row (Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically){
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Blue
            )
        )
        Spacer(Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyTriStatusCheckbox(modifier: Modifier = Modifier){
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when(status){
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

