package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.*
import com.stevdza.san.kotlinbs.forms.BSTextArea
import com.stevdza.san.kotlinbs.models.InputValidation
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
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
    var value by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxSize().margin(top = 200.px),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        Column(modifier = Modifier.margin(right = 24.px)) {
            BSTextArea(
                modifier = Modifier.width(250.px).margin(bottom = 12.px),
                value = value,
                onValueChange = { value = it }
            )
            BSTextArea(
                modifier = Modifier.width(250.px).margin(bottom = 12.px),
                value = value,
                label = "Email Address",
                placeholder = "Type here...",
                floating = true,
                onValueChange = { value = it }
            )
            BSTextArea(
                modifier = Modifier.width(250.px).margin(bottom = 12.px),
                value = value,
                label = "Email Address",
                onValueChange = { value = it }
            )
            BSTextArea(
                modifier = Modifier.width(250.px).margin(bottom = 12.px),
                value = value,
                label = "Email Address",
                placeholder = "Type here...",
                onValueChange = { value = it }
            )
        }
        Column {
            BSTextArea(
                modifier = Modifier.width(250.px).margin(bottom = 12.px),
                value = value,
                label = "Email Address",
                placeholder = "Type here...",
                disabled = true,
                onValueChange = { value = it }
            )
            BSTextArea(
                modifier = Modifier.width(250.px).margin(bottom = 12.px),
                value = value,
                label = "Email Address",
                placeholder = "Type here...",
                validation = InputValidation(
                    isValid = true
                ),
                onValueChange = { value = it }
            )
            BSTextArea(
                modifier = Modifier.width(250.px).margin(bottom = 12.px),
                value = value,
                label = "Email Address",
                placeholder = "Type here...",
                validation = InputValidation(
                    isInvalid = true
                ),
                onValueChange = { value = it }
            )
        }
    }
}