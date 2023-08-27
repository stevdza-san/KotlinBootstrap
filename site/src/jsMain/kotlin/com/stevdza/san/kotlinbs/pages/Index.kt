package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSBadge
import com.stevdza.san.kotlinbs.models.BadgeVariant
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Row(
                modifier = Modifier.margin(bottom = 16.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpanText(
                    modifier = Modifier.margin(right = 8.px),
                    text = "Fitness Tracker"
                )
                BSBadge(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "New",
                    variant = BadgeVariant.Straight
                )
            }
            Row(
                modifier = Modifier.margin(bottom = 16.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpanText(
                    modifier = Modifier.margin(right = 8.px),
                    text = "Smart Glasses"
                )
                BSBadge(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "New",
                )
            }
            Row(
                modifier = Modifier.margin(bottom = 16.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpanText(
                    modifier = Modifier.margin(right = 8.px),
                    text = "Travel Backpack"
                )
                BSBadge(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "New",
                    variant = BadgeVariant.Rounded,
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                SpanText(
                    modifier = Modifier.margin(right = 8.px),
                    text = "Home Security System"
                )
                BSBadge(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "New",
                    variant = BadgeVariant.Empty
                )
            }
        }
    }
}