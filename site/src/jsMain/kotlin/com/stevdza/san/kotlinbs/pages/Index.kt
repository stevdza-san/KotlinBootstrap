package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSAlert
import com.stevdza.san.kotlinbs.models.AlertIcon
import com.stevdza.san.kotlinbs.models.AlertStyle
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
    Column (
        modifier = Modifier.fillMaxSize().margin(left = 250.px),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        BSAlert(
            modifier = Modifier.margin(bottom = 24.px),
            message = "Visit my YouTube Channel: Stevdza-San",
            icon = AlertIcon.Info,
            bold = "Stevdza-San"
        )
        BSAlert(
            modifier = Modifier.margin(bottom = 24.px),
            message = "You're not allowed to access this page.",
            icon = AlertIcon.Warning,
            style = AlertStyle.Warning
        )
        BSAlert(
            modifier = Modifier.margin(bottom = 24.px),
            message = "Unexpected error occurred.",
            icon = AlertIcon.Warning,
            style = AlertStyle.Danger
        )
        BSAlert(
            message = "You have successfully purchased a book!",
            alertLink = Pair(first = "book", second = "https://google.com"),
            icon = AlertIcon.Checkmark,
            style = AlertStyle.Success
        )
        BSAlert(
            modifier = Modifier.margin(bottom = 24.px),
            message = "Secondary Style alert.",
            dismissible = true,
            style = AlertStyle.Secondary
        )
        BSAlert(
            modifier = Modifier.margin(bottom = 24.px),
            message = "Light Style alert.",
            dismissible = true,
            style = AlertStyle.Light
        )
        BSAlert(
            modifier = Modifier.margin(bottom = 24.px),
            message = "Dark Style alert.",
            dismissible = true,
            style = AlertStyle.Dark
        )
    }
}