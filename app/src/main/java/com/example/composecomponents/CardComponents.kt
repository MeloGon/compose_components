package com.example.composecomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    MyBadgeBox()
}

@Composable
fun MyCard(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(

            containerColor = Color.White
        ),
        shape = MaterialTheme.shapes.extraSmall,
        border = BorderStroke(5.dp, color = Color.Green)

    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
        }
    }
}

@Composable
fun MyBadgeBox(modifier: Modifier = Modifier) {
    Column() {
        BadgedBox(modifier = Modifier.padding(16.dp),
            badge = {
                Badge(containerColor = Color.Green){
                    Text("3000")
                }

            },
            content = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "estrella")
            })
    }

}