package com.example.composecomponents

import android.app.AlertDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties


@Preview(showBackground = true)
@Composable
fun PreviewDialogs() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDialog(modifier: Modifier) {
//    Dialog(
//        properties = DialogProperties(usePlatformDefaultWidth = false),
//        onDismissRequest = {  }) {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = Color.Transparent
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.Black.copy(alpha = 0.75f))
//                    .padding(16.dp)
//            ) {
//
//            }
//        }
//    }

}

@Composable
fun AlertDialogDoc(modifier: Modifier = Modifier) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Documentación  de AlertDialog")
            },
            text = {
                Text(
                    "Descripción de la alerta de ejemplo de material 2."
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Salir")
                }
            }
        )
    }
}

@Composable
fun ConfirmationDialog(modifier: Modifier = Modifier, show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        AlertDialog(
            containerColor = Color.White,
            onDismissRequest = {},
            confirmButton = {},

            text = {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Phone Ringtone")
                    HorizontalDivider(Modifier.fillMaxWidth(), color = Color.LightGray)
                    var status by remember { mutableStateOf("") }
                    MyRadioButtonListHoistin(name = status, onItemSelected = { status = it })
                    HorizontalDivider(Modifier.fillMaxWidth(), color = Color.LightGray)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        TextButton(onClick = {}) { Text(text = "CANCEL") }
                        TextButton(onClick = {}) { Text(text = "OK") }
                    }
                }

            })


    }
}