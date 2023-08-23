package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.BackgroundStyle
import com.stevdza.san.kotlinbs.models.BadgeVariant
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

/**
 * Badge is a small element used to highlight or display additional information related
 * to content. Badges are typically used to indicate the count of items,
 * notifications, statuses, or any other relevant information.
 * @param text Text that appears on top of the Badge.
 * @param style Different style that you can apply on this element.
 * @param variant Different variants of this component.
 * */
@Composable
fun BSBadge(
    modifier: Modifier = Modifier,
    text: String,
    style: BackgroundStyle = BackgroundStyle.Primary,
    variant: BadgeVariant = BadgeVariant.Regular
) {
    Span(
        attrs = modifier
            .classNames(style.value)
            .thenIf(
                condition = variant != BadgeVariant.Regular,
                other = Modifier.classNames(*variant.classes.toTypedArray())
            )
            .thenIf(
                condition = variant != BadgeVariant.Empty,
                other = Modifier.classNames("badge")
            )
            .toAttrs()
    ) {
        if (variant != BadgeVariant.Empty) {
            Text(value = text)
        }
    }
}