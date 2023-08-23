package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.ButtonBadge
import com.stevdza.san.kotlinbs.models.ButtonSize
import com.stevdza.san.kotlinbs.models.ButtonStyle
import com.stevdza.san.kotlinbs.models.ButtonType
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

/**
 * Buttons are used to trigger actions or events when clicked or tapped.
 * They are an essential part of any user interface as they provide a way for users
 * to interact with and control the application or website.
 * @param id A unique identifier of the button.
 * @param text Text that will appear on top of the button.
 * @param style This one is used to stylize your button with a different color.
 * @param type Determine the behavior of the button when clicked or activated.
 * @param size The overall size of the button.
 * @param disabled Whether a button is clickable or not.
 * @param loading When set to true, a loading indicator will appear. It's often used
 * with the other [loadingText] parameter.
 * @param loadingText Here you specify the text that will be shown, when the loading
 * state of the button changes to true.
 * @param badge Small badge or label, providing additional information or indicating
 * a specific status or count associated with the button.
 * @param onClick Lambda which is triggered everytime a user clicks on a button.
 * */
@Composable
fun BSButton(
    modifier: Modifier = Modifier,
    id: String? = null,
    text: String,
    style: ButtonStyle = ButtonStyle.Primary,
    type: ButtonType = ButtonType.Button,
    size: ButtonSize = ButtonSize.Default,
    disabled: Boolean = false,
    loading: Boolean = false,
    loadingText: String? = null,
    badge: ButtonBadge? = null,
    onClick: () -> Unit
) {
    Button(attrs = Modifier
        .then(modifier)
        .onClick { onClick() }
        .classNames(
            *style.classes.toTypedArray(),
            size.value,
            "d-flex",
            "align-items-center",
        )
        .thenIf(
            condition = !id.isNullOrEmpty(),
            other = id?.let { Modifier.id(it) } ?: Modifier
        )
        .thenIf(
            condition = badge != null,
            other = Modifier.classNames("position-relative")
        )
        .toAttrs {
            attr("type", type.value)
            if (disabled || loading) disabled()
        }
    ) {
        if (badge != null) {
            BSBadge(
                modifier = badge.modifier
                    .classNames(
                        "position-absolute",
                        "top-0",
                        "start-100",
                        "translate-middle"
                    ),
                text = badge.text,
                style = badge.style,
                variant = badge.variant,
            )
        }
        if (loading) {
            if (loadingText != null) {
                Span(attrs = Modifier
                    .margin(right = 6.px)
                    .classNames("spinner-border", "spinner-border-sm")
                    .toAttrs {
                        attr("role", "status")
                        attr("aria-hidden", "true")
                    }
                )
                Text(value = loadingText)
            } else {
                Span(attrs = Modifier
                    .classNames("spinner-border", "spinner-border-sm")
                    .toAttrs {
                        attr("role", "status")
                        attr("aria-hidden", "true")
                    }
                )
                Span(
                    attrs = Modifier
                        .classNames("visually-hidden")
                        .toAttrs()
                ) {
                    Text(value = "Loading...")
                }
            }
        } else {
            SpanText(text = text)
        }
    }
}