package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.AlertIcon
import com.stevdza.san.kotlinbs.models.AlertStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

/**
 * UI element that provides a way to display important messages, notifications,
 * or alerts to users. It is commonly used to convey information, warnings, errors,
 * or success messages in a visually prominent and attention-grabbing manner.
 * @param message A simple text that will be displayed inside an Alert dialog.
 * @param icon An [AlertIcon] that is used to give a specific context to the message.
 * @param dismissible Parameter that indicates whether an Alert can be dismissed or not.
 * @param style [AlertStyle] can change the look of the Alert itself.
 * */
@Composable
fun BSAlert(
    modifier: Modifier = Modifier,
    message: String,
    icon: AlertIcon? = null,
    dismissible: Boolean = false,
    style: AlertStyle = AlertStyle.Primary
) {
    Div(attrs = modifier
        .classNames(
            *style.classes.toTypedArray(),
            "d-flex",
            "align-items-center"
        )
        .thenIf(
            condition = dismissible,
            other = Modifier.classNames("alert-dismissible", "fade", "show")
        )
        .toAttrs {
            attr("role", "alert")
        }
    ) {
        if (icon != null) {
            Svg(attrs = Modifier
                .width(24.px)
                .height(24.px)
                .classNames(
                    "bi",
                    icon.classes,
                    "flex-shrink-0",
                    "me-2"
                )
                .toAttrs {
                    attr("fill", "currentColor")
                    attr("viewBox", "0 0 16 16")
                    attr("role", "img")
                    attr("aria-label", icon.label)
                }
            ) {
                Path(attrs = Modifier.toAttrs {
                    attr("d", icon.path)
                })
            }
        }
        Div {
            Text(value = message)
        }
        if (dismissible) {
            BSCloseButton(
                modifier = Modifier
                    .attrsModifier {
                        attr("data-bs-dismiss", "alert")
                    }
            )
        }
    }
}

/**
 * UI element that provides a way to display important messages, notifications,
 * or alerts to users. It is commonly used to convey information, warnings, errors,
 * or success messages in a visually prominent and attention-grabbing manner.
 * @param message A simple text that will be displayed inside an Alert dialog.
 * @param icon An [AlertIcon] that is used to give a specific context to the message.
 * @param dismissible Parameter that indicates whether an Alert can be dismissed or not.
 * @param style [AlertStyle] can change the look of the Alert itself.
 * @param alertLink This parameter allows you to add and mark a text from the message parameter
 * as a link [A]. The first string in the [Pair] represents the actual text from the message
 * that you want to link. While the second string in the [Pair] represents href/link which
 * you want to open when a user clicks on it.
 * */
@Composable
fun BSAlert(
    modifier: Modifier = Modifier,
    message: String,
    icon: AlertIcon? = null,
    dismissible: Boolean = false,
    alertLink: Pair<String, String>? = null,
    style: AlertStyle = AlertStyle.Primary
) {
    Div(attrs = modifier
        .classNames(*style.classes.toTypedArray())
        .thenIf(
            condition = dismissible,
            other = Modifier.classNames("alert-dismissible", "fade", "show")
        )
        .toAttrs {
            attr("role", "alert")
        }
    ) {
        if (icon != null) {
            Svg(attrs = Modifier
                .width(24.px)
                .height(24.px)
                .classNames(
                    "bi",
                    icon.classes,
                    "flex-shrink-0",
                    "me-2"
                )
                .toAttrs {
                    attr("fill", "currentColor")
                    attr("viewBox", "0 0 16 16")
                    attr("role", "img")
                    attr("aria-label", icon.label)
                }
            ) {
                Path(attrs = Modifier.toAttrs {
                    attr("d", icon.path)
                })
            }
        }
        if (alertLink == null) {
            Text(value = message)
        } else {
            val messageParts = message.split(alertLink.first, ignoreCase = true)
            SpanText(text = messageParts.first())
            A(
                attrs = Modifier.classNames("alert-link").toAttrs(),
                href = alertLink.second
            ) {
                SpanText(text = alertLink.first)
            }
            SpanText(text = messageParts.last())
        }
        if (dismissible) {
            Button(
                attrs = Modifier
                    .classNames("btn-close")
                    .toAttrs {
                        attr("type", "button")
                        attr("data-bs-dismiss", "alert")
                        attr("aria-label", "Close")
                    }
            )
        }
    }
}

/**
 * UI element that provides a way to display important messages, notifications,
 * or alerts to users. It is commonly used to convey information, warnings, errors,
 * or success messages in a visually prominent and attention-grabbing manner.
 * @param message A simple text that will be displayed inside an Alert dialog.
 * @param icon An [AlertIcon] that is used to give a specific context to the message.
 * @param dismissible Parameter that indicates whether an Alert can be dismissed or not.
 * @param bold Allows you to mark a specific text from a message parameter,
 * as a Bold.
 * @param style [AlertStyle] can change the look of the Alert itself.
 * */
@Composable
fun BSAlert(
    modifier: Modifier = Modifier,
    message: String,
    icon: AlertIcon? = null,
    dismissible: Boolean = false,
    bold: String? = null,
    style: AlertStyle = AlertStyle.Primary
) {
    Div(attrs = modifier
        .classNames(*style.classes.toTypedArray())
        .thenIf(
            condition = dismissible,
            other = Modifier.classNames("alert-dismissible", "fade", "show")
        )
        .toAttrs {
            attr("role", "alert")
        }
    ) {
        if (icon != null) {
            Svg(attrs = Modifier
                .width(24.px)
                .height(24.px)
                .classNames(
                    "bi",
                    icon.classes,
                    "flex-shrink-0",
                    "me-2"
                )
                .toAttrs {
                    attr("fill", "currentColor")
                    attr("viewBox", "0 0 16 16")
                    attr("role", "img")
                    attr("aria-label", icon.label)
                }
            ) {
                Path(attrs = Modifier.toAttrs {
                    attr("d", icon.path)
                })
            }
        }
        if (bold == null) {
            Text(value = message)
        } else {
            val messageParts = message.split(bold, ignoreCase = true)
            SpanText(text = messageParts.first())
            SpanText(
                modifier = Modifier.fontWeight(FontWeight.Bold),
                text = bold
            )
            SpanText(text = messageParts.last())
        }
        if (dismissible) {
            Button(
                attrs = Modifier
                    .classNames("btn-close")
                    .toAttrs {
                        attr("type", "button")
                        attr("data-bs-dismiss", "alert")
                        attr("aria-label", "Close")
                    }
            )
        }
    }
}