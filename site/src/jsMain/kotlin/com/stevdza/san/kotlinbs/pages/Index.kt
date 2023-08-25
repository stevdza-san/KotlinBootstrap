package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.stevdza.san.kotlinbs.components.BSTooltip
import com.stevdza.san.kotlinbs.components.initializeTooltips
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.dom.A

@Page
@Composable
fun HomePage() {
    LaunchedEffect(Unit) {
        initializeTooltips()
    }
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BSTooltip(
            text = "https://stevdza-san.com",
            content = {
                A(href = "https://stevdza-san.com") {
                    SpanText(text = "Online Courses")
                }
            }
        )
    }
}