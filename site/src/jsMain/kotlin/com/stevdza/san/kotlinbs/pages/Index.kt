package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSSpinner
import com.stevdza.san.kotlinbs.models.SpinnerVariant
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
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
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.margin(right = 40.px)) {
            BSSpinner(
                modifier = Modifier.margin(bottom = 20.px),
                variant = SpinnerVariant.Small
            )
            BSSpinner(
                modifier = Modifier.margin(bottom = 20.px),
                variant = SpinnerVariant.SmallGrow
            )
        }
        Column(modifier = Modifier.margin(right = 40.px)) {
            BSSpinner(modifier = Modifier.margin(bottom = 20.px))
            BSSpinner(
                modifier = Modifier.margin(bottom = 20.px),
                variant = SpinnerVariant.DefaultGrow
            )
        }
        Column {
            BSSpinner(
                modifier = Modifier.margin(bottom = 20.px),
                variant = SpinnerVariant.Large
            )
            BSSpinner(
                modifier = Modifier.margin(bottom = 20.px),
                variant = SpinnerVariant.LargeGrow
            )
        }
    }
}