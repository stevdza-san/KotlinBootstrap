package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.forms.BSRadioButton
import com.stevdza.san.kotlinbs.forms.BSRadioButtonGroup
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    Row(
        modifier = Modifier.fillMaxSize().margin(top = 250.px),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        BSRadioButtonGroup(
            modifier = Modifier.margin(right = 60.px),
            checkedValue = "Android"
        ) {
            BSRadioButton(label = "Android", onClick = {})
            BSRadioButton(label = "iOS", disabled = true, onClick = {})
            BSRadioButton(label = "Web", onClick = {})
        }
        BSRadioButtonGroup(
            modifier = Modifier.margin(right = 60.px),
            checkedValue = "Donation",
            reverse = true
        ) {
            BSRadioButton(label = "$1 USD", onClick = {})
            BSRadioButton(label = "$10 USD", onClick = {})
            BSRadioButton(label = "$50 USD", onClick = {})
        }
        BSRadioButtonGroup(
            modifier = Modifier.margin(right = 40.px),
            checkedValue = "Kotlin",
            inline = true
        ) {
            BSRadioButton(label = "Kotlin", onClick = {})
            BSRadioButton(label = "C++", onClick = {})
            BSRadioButton(label = "Python", onClick = {})
        }
        BSRadioButtonGroup(
            checkedValue = "Kotlin",
            inline = true,
            toggleButton = true
        ) {
            BSRadioButton(label = "Kotlin", onClick = {})
            BSRadioButton(label = "C++", onClick = {})
            BSRadioButton(label = "Python", onClick = {})
        }
    }
}