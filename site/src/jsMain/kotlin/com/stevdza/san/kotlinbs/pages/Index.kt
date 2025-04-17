package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.*
import com.stevdza.san.kotlinbs.forms.BSSwitch
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    Column {
        var isChecked by remember { mutableStateOf(false) }

        BSSwitch(
            label = "Example Switch",
            checked = isChecked,
            onClick = {
                isChecked = it
            }
        )
    }
}