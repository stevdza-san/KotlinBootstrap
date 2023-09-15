package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSButton
import com.stevdza.san.kotlinbs.models.BSBorderRadius
import com.stevdza.san.kotlinbs.models.button.ButtonBadge
import com.stevdza.san.kotlinbs.models.button.ButtonCustomization
import com.stevdza.san.kotlinbs.models.button.ButtonSize
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb

@Page
@Composable
fun HomePage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BSButton(
            modifier = Modifier.margin(topBottom = 20.px),
            text = "Click me",
            customization = ButtonCustomization(
                color = rgb(255, 255, 255),
                disabledColor = rgb(255, 255, 255),
                borderColor = Colors.White,
                borderRadius = BSBorderRadius(all = 50.px),
                gradient = linearGradient(
                    from = rgb(0, 84, 152),
                    to = rgb(30, 154, 255),
                    dir = LinearGradient.Direction.ToTopRight
                )
            ),
            loadingText = "Loading...",
            loading = true,
            badge = ButtonBadge(
                text = "0"
            ),
            onClick = {}
        )
        BSButton(
            text = "Click me",
            size = ButtonSize.Small,
            onClick = {}
        )
        BSButton(
            text = "Click me",
            onClick = {}
        )
        BSButton(
            text = "Click me",
            size = ButtonSize.Large,
            onClick = {}
        )
    }
}