package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Div

/**
 * Toggle the visibility of your content.
 * Given how CSS handles animations, you cannot use padding on a content that
 * is collapsing. Instead, use the class as an independent wrapping element.
 * This component comes with a [showCollapse] util function, that is used to
 * trigger/show this component.
 * @param id A unique identifier for the collapsing parent.
 * @param horizontal Whether the content should appear/disappear horizontally.
 * @param content The content that you're trying to hide.
 * */
@Composable
fun BSCollapse(
    modifier: Modifier = Modifier,
    id: String,
    horizontal: Boolean = false,
    content: @Composable () -> Unit
) {
    Div(
        attrs = modifier
            .id(id)
            .classNames("collapse")
            .thenIf(
                condition = horizontal,
                other = Modifier.classNames("collapse-horizontal")
            )
            .toAttrs()
    ) {
        content()
    }
}

/**
 * Util function which is used in a combination with [BSCollapse].
 * */
fun Modifier.showCollapse(id: String): Modifier = attrsModifier {
    attr("data-bs-toggle", "collapse")
    attr("data-bs-target", "#$id")
}