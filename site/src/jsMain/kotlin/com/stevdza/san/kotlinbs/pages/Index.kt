package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.*
import com.stevdza.san.kotlinbs.forms.BSRange
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    var value by remember { mutableStateOf(0.0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpanText(
            modifier = Modifier
                .margin(bottom = 24.px)
                .fontSize(24.px),
            text = value.toString()
        )
        BSRange(
            modifier = Modifier.width(300.px).margin(bottom = 14.px),
            label = "Range (0-100)",
            onSelect = { value = it }
        )
        BSRange(
            modifier = Modifier.width(300.px).margin(bottom = 14.px),
            label = "Range (0-10)",
            min = 0,
            max = 10,
            onSelect = { value = it }
        )
        BSRange(
            modifier = Modifier.width(300.px),
            label = "Range (Disabled)",
            disabled = true,
            onSelect = { value = it }
        )
    }
}