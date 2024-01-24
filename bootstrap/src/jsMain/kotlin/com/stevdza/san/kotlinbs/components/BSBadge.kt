package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.BackgroundStyle
import com.stevdza.san.kotlinbs.models.BadgeVariant
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span

/**
 * Badge is a small element used to highlight or display additional information related
 * to content. Badges are typically used to indicate the count of items,
 * notifications, statuses, or any other relevant information.
 * @param text Text that appears on top of the Badge.
 * @param fontFamily Font family of the text.
 * @param fontSize Size of the text.
 * @param fontWeight Font weight of the text.
 * @param style Different style that you can apply on this element.
 * @param variant Different variants of this component.
 * */
@Composable
fun BSBadge(
    modifier: Modifier = Modifier,
    text: String,
    fontFamily: String? = null,
    fontSize: CSSLengthOrPercentageNumericValue? = null,
    fontWeight: FontWeight? = null,
    style: BackgroundStyle = BackgroundStyle.Primary,
    variant: BadgeVariant = BadgeVariant.Regular
) {
    Span(
        attrs = modifier
            .classNames(style.value)
            .thenIf(
                condition = variant != BadgeVariant.Regular && variant != BadgeVariant.Straight,
                other = variant.classes?.let { Modifier.classNames(*it.toTypedArray()) } ?: Modifier
            )
            .thenIf(
                condition = variant != BadgeVariant.Empty,
                other = Modifier.classNames("badge")
            )
            .thenIf(
                condition = variant == BadgeVariant.Straight,
                other = Modifier.borderRadius(0.px)
            )
            .toAttrs()
    ) {
        if (variant != BadgeVariant.Empty) {
            SpanText(
                modifier = Modifier
                    .thenIf(
                        condition = fontFamily != null,
                        other = fontFamily?.let { Modifier.fontFamily(it) } ?: Modifier
                    )
                    .thenIf(
                        condition = fontSize != null,
                        other = fontSize?.let { Modifier.fontSize(it) } ?: Modifier
                    )
                    .thenIf(
                        condition = fontWeight != null,
                        other = fontWeight?.let { Modifier.fontWeight(it) } ?: Modifier
                    ),
                text = text
            )
        }
    }
}