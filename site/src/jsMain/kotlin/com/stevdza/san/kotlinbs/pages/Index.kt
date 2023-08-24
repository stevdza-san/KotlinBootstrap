package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.forms.BSSelect
import com.stevdza.san.kotlinbs.models.InputValidation
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BSSelect(
            modifier = Modifier.width(300.px).margin(bottom = 14.px),
            items = listOf("Android", "iOS", "Web", "Desktop"),
            placeholder = "Choose a Platform",
            onItemSelected = { index, value -> }
        )
        BSSelect(
            modifier = Modifier.width(300.px).margin(bottom = 14.px),
            items = listOf("Android", "iOS", "Web", "Desktop"),
            placeholder = "Choose a Platform",
            floating = true,
            onItemSelected = { index, value -> }
        )
        BSSelect(
            modifier = Modifier.width(300.px).margin(bottom = 14.px),
            items = listOf("Android", "iOS", "Web", "Desktop"),
            placeholder = "Choose a Platform",
            floating = true,
            validation = InputValidation(
                isValid = true
            ),
            onItemSelected = { index, value -> }
        )
        BSSelect(
            modifier = Modifier.width(300.px),
            items = listOf("Android", "iOS", "Web", "Desktop"),
            placeholder = "Choose a Platform",
            floating = true,
            validation = InputValidation(
                isInvalid = true
            ),
            onItemSelected = { index, value -> }
        )
    }
}