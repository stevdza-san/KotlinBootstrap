package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BSButton(
            text = "Click me",
            icon = BSIcons.TRASH,
            onClick = { println("Clicked") }
        )
        BSDropdown(
            items = listOf("One", "Two", "Three"),
            selectedItem = "Two",
            placeholder = "Stevdza",
            onItemSelect = { index, item ->
                println("Item: $item at position: $index")
            }
        )
    }
}