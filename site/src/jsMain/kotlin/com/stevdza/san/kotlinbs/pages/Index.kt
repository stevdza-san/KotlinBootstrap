package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.forms.BSCheckbox
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    Column(
        modifier = Modifier.fillMaxSize().margin(left = 250.px),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        BSCheckbox(
            modifier = Modifier.margin(bottom = 14.px),
            label = "Kotlin",
            onClick = {

            }
        )
        BSCheckbox(
            modifier = Modifier.margin(bottom = 14.px),
            label = "Python",
            disabled = true,
            onClick = {

            }
        )
        BSCheckbox(
            modifier = Modifier.margin(bottom = 14.px),
            label = "C++",
            reverse = true,
            onClick = {

            }
        )
        BSCheckbox(
            modifier = Modifier.margin(bottom = 14.px),
            label = "PHP",
            toggleButton = true,
            onClick = {

            }
        )
    }
}