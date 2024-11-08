package com.example.composecomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PreviewImages() {
    MyIcon()
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background), alpha = 0.5f,
        contentDescription = "ejemplo"
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier
            .clip(shape = RoundedCornerShape(25f))
            .border(width = 5.dp, color = Color.Red, shape = RoundedCornerShape(25f))
    )
}

@Composable
fun MyIcon(modifier: Modifier = Modifier){
    Icon(imageVector = Icons.Outlined.MailOutline, contentDescription = "Icono", tint = Color.Red)
}