package com.stevdza.san.kotlinbs.layouts

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.container.ContainerBehavior
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Div

/**
 * Containers are a fundamental building block of Bootstrap that contain, pad, and align your content within a given
 * device or viewport.
 *
 * There are 3 possible container behaviors:
 * - default: responsive, fixed-width container, meaning its max-width changes at each breakpoint
 * - fluid: full width container, spanning the entire width of the viewport
 * - responsive: allow you to specify a class that is 100% wide until the specified breakpoint is reached, after which
 *   we apply max-widths for each of the higher breakpoints
 *
 * @param behavior How the container resizes based on available width
 * @param content Container's content
 */
@Composable
fun BSContainer(
    modifier: Modifier = Modifier,
    behavior: ContainerBehavior = ContainerBehavior.Default,
    content: @Composable () -> Unit
) {
    Div(
        attrs = modifier
            .classNames(behavior.className)
            .toAttrs()
    ) {
        content()
    }
}