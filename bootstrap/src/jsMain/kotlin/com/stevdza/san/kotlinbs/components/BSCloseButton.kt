package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Button

/**
 * Pre-designed UI element that provides a visually identifiable button for closing
 * or dismissing a content block, alert, modal, or any other component that requires
 * user interaction to be closed.
 * @param disabled Whether this close button should be disabled.
 * @param dark Whether the color of this close button should be dark or not.
 * */
@Composable
fun BSCloseButton(
    modifier: Modifier = Modifier,
    disabled: Boolean = false,
    dark: Boolean = true
) {
    Button(attrs = modifier
        .classNames("btn-close")
        .thenIf(
            condition = !dark,
            other = Modifier.classNames("btn-close-white")
        )
        .toAttrs {
            attr("type", "button")
            attr("aria-label", "Close")
            if (disabled) disabled()
        }
    )
}