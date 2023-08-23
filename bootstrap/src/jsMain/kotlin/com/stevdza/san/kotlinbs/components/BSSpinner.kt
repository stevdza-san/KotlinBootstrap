package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.SpinnerStyle
import com.stevdza.san.kotlinbs.models.SpinnerVariant
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

/**
 * Indicate that content is loading or processing. It provides an animated spinner that
 * rotates continuously, giving users a visual cue that an operation is in progress, and
 * they need to wait for the result.
 * @param style The visual style of the spinner.
 * @param variant A different variant of the spinner.
 * */
@Composable
fun BSSpinner(
    modifier: Modifier = Modifier,
    style: SpinnerStyle = SpinnerStyle.Primary,
    variant: SpinnerVariant = SpinnerVariant.Default
) {
    Div(attrs = modifier
        .classNames(
            style.value,
            *variant.classes.toTypedArray()
        )
        .thenIf(
            condition = variant is SpinnerVariant.Large || variant is SpinnerVariant.LargeGrow,
            other = Modifier.size(3.cssRem)
        )
        .toAttrs {
            attr("role", "status")
        }
    ) {
        Span(attrs = Modifier.classNames("visually-hidden").toAttrs()) {
            Text(value = "Loading...")
        }
    }
}