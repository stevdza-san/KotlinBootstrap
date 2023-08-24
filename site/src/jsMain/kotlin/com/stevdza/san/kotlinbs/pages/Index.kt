package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSProgress
import com.stevdza.san.kotlinbs.models.BackgroundStyle
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BSProgress(
            modifier = Modifier.margin(bottom = 20.px),
            percentage = 85.percent,
        )
        BSProgress(
            modifier = Modifier.margin(bottom = 20.px),
            percentage = 75.percent,
            striped = true
        )
        BSProgress(
            modifier = Modifier.margin(bottom = 20.px),
            striped = true,
            percentage = 65.percent,
            stripedAnimated = true
        )
        BSProgress(
            modifier = Modifier.margin(bottom = 20.px),
            percentage = 55.percent,
            style = BackgroundStyle.Secondary
        )
        BSProgress(
            modifier = Modifier.margin(bottom = 20.px),
            percentage = 60.percent,
            style = BackgroundStyle.Success
        )
        BSProgress(
            modifier = Modifier.margin(bottom = 20.px),
            percentage = 65.percent,
            style = BackgroundStyle.Danger
        )
        BSProgress(
            modifier = Modifier.margin(bottom = 20.px),
            percentage = 70.percent,
            style = BackgroundStyle.Warning
        )
        BSProgress(
            modifier = Modifier.margin(bottom = 20.px),
            percentage = 75.percent,
            style = BackgroundStyle.Dark
        )
        BSProgress(
            modifier = Modifier.margin(bottom = 20.px),
            percentage = 80.percent,
            style = BackgroundStyle.Light
        )
        BSProgress(
            modifier = Modifier.margin(bottom = 20.px),
            percentage = 85.percent,
            style = BackgroundStyle.Info
        )
    }
}