package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.*
import com.stevdza.san.kotlinbs.components.BSButton
import com.stevdza.san.kotlinbs.components.BSDropdown
import com.stevdza.san.kotlinbs.icons.BSIcons
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    var selectedItem by remember { mutableStateOf("Two") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BSButton(
            text = "Click me",
            icon = BSIcons.TRASH,
            onClick = { selectedItem = "Three" }
        )
        BSDropdown(
            items = listOf("One", "Two", "Three"),
            selectedItem = selectedItem,
            placeholder = "Stevdza",
            onItemSelect = { index, item ->
                println("Item: $item at position: $index")
                selectedItem = item
            }
        )
    }
}