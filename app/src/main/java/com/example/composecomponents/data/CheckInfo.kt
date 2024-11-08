package com.example.composecomponents.data

data class CheckInfo(
    val title: String, var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
) {

}