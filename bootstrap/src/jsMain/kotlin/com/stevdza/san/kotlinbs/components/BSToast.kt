package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.*
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.browser.document
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * Scope which is used to place only Toast components within the [BSToastGroup].
 * */
class ToastGroupScope

private val toastGroupScopeImpl = ToastGroupScope()

/**
 * Lightweight and unobtrusive UI element used to display temporary messages or
 * notifications to users. It is typically used to show non-disruptive information that
 * can be easily dismissed or will automatically disappear after a short period.
 *
 * This composable represents a group that can contain single or multiple different
 * toast components. Call a [showToast] function with specified [BSToast] id in
 * order to display it.
 * @param placement Where should be this Toast displayed.
 * @param content Content that should contain single, or multiple different Toast
 * components, that when displayed, should be stacked on top of each other.
 * */
@Composable
fun BSToastGroup(
    modifier: Modifier = Modifier,
    placement: ToastPlacement = ToastPlacement.BottomRight,
    content: @Composable ToastGroupScope.() -> Unit
) {
    Div(
        attrs = modifier
            .classNames("position-static")
            .toAttrs()
    ) {
        Div(
            attrs = Modifier
                .padding(all = 16.px)
                .classNames(*placement.classes.toTypedArray(), "toast-container")
                .styleModifier {
                    property("pointer-events", "none")
                }
                .toAttrs()
        ) {
            content(toastGroupScopeImpl)
        }
    }
}

/**
 * Lightweight and unobtrusive UI element used to display temporary messages or
 * notifications to users. It is typically used to show non-disruptive information that
 * can be easily dismissed or will automatically disappear after a short period.
 * Call a [showToast] function with specified [BSToast] id in order to display it.
 * @param id Unique identifier of the toast component.
 * @param title Title of the toast.
 * @param body Body of the toast.
 * @param autoHide Whether to autohide the toast after a certain delay or not.
 * @param indicatorStyle Background color.
 * @param onCloseClick Lambda that is triggered when close button is clicked.
 * */
@Composable
fun ToastGroupScope.BSToast(
    modifier: Modifier = Modifier,
    id: String,
    title: String,
    body: String,
    autoHide: Boolean = true,
    indicatorStyle: BackgroundStyle = BackgroundStyle.Primary,
    onCloseClick: () -> Unit
) {
    Div(
        attrs = modifier
            .id(id)
            .zIndex(9)
            .classNames("toast")
            .styleModifier {
                property("pointer-events", "auto")
            }
            .toAttrs {
                attr("role", "alert")
                attr("aria-live", "assertive")
                attr("aria-atomic", "true")
                attr("data-bs-autohide", autoHide.toString())
            }
    ) {
        Row(
            modifier = Modifier.classNames("toast-header"),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .size(16.px)
                    .borderRadius(50.percent)
                    .margin(right = 8.px)
                    .classNames(indicatorStyle.value))
                SpanText(text = title)
            }
            BSCloseButton(
                modifier = Modifier
                    .onClick { onCloseClick() }
                    .attrsModifier {
                        attr("data-bs-dismiss", "toast")
                    }
            )
        }
        Div(
            attrs = Modifier
                .classNames("toast-body")
                .toAttrs()
        ) {
            SpanText(text = body)
        }
    }
}

/**
 * Toast variant that contains just a text and a close button.
 * Lightweight and unobtrusive UI element used to display temporary
 * messages or notifications to users. It is typically used to show non-disruptive
 * information that can be easily dismissed or will automatically disappear after a short
 * period.
 * Call a [showToast] function with specified [BSToast] id in order to display it.
 * @param id Unique identifier of the toast component.
 * @param text Toast text.
 * @param style The style of the toast.
 * @param autoHide Whether to autohide the toast after a certain delay or not.
 * @param closeButtonDark Whether a close icon should have a dark color or not.
 * @param onCloseClick Lambda that is triggered when close button is clicked.
 * */
@Composable
fun ToastGroupScope.BSToastBasic(
    modifier: Modifier = Modifier,
    id: String,
    text: String,
    style: ToastStyle = ToastStyle.Primary,
    autoHide: Boolean = true,
    closeButtonDark: Boolean = true,
    onCloseClick: () -> Unit
) {
    Div(
        attrs = modifier
            .id(id)
            .zIndex(9)
            .classNames("toast", style.value, "border-0")
            .styleModifier {
                property("pointer-events", "auto")
            }
            .toAttrs {
                attr("role", "alert")
                attr("aria-live", "assertive")
                attr("aria-atomic", "true")
                attr("data-bs-autohide", autoHide.toString())
            }
    ) {
        Row(
            modifier = Modifier.classNames("toast-body"),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SpanText(text = text)
            BSCloseButton(
                modifier = Modifier
                    .onClick { onCloseClick() }
                    .attrsModifier {
                        attr("data-bs-dismiss", "toast")
                    },
                dark = closeButtonDark
            )
        }
    }
}

/**
 * Toast variant that contains two action buttons.
 * Lightweight and unobtrusive UI element used to display temporary
 * messages or notifications to users. It is typically used to show non-disruptive
 * information that can be easily dismissed or will automatically disappear after a short
 * period.
 * Call a [showToast] function with specified [BSToast] id in order to display it.
 * @param id Unique identifier of the toast component.
 * @param text Toast text.
 * @param positiveButtonText The text of the positive button.
 * @param negativeButtonText The text of the negative button.
 * @param autoHide Whether to autohide the toast after a certain delay or not.
 * @param onPositiveButtonClick A lambda that is triggered when a user clicks a positive
 * button.
 * @param onNegativeButtonClick A lambda that is triggered when a user clicks a negative
 * button.
 * @param style The style of the toast.
 * @param borderColor The color of the border.
 * @param positiveButtonStyle The style of the positive button.
 * @param negativeButtonStyle The style of the negative button.
 *
 * */
@Composable
fun ToastGroupScope.BSToastAction(
    modifier: Modifier = Modifier,
    id: String,
    text: String,
    positiveButtonText: String = "Take Action",
    negativeButtonText: String = "Close",
    autoHide: Boolean = false,
    onPositiveButtonClick: () -> Unit,
    onNegativeButtonClick: () -> Unit,
    style: ToastStyle = ToastStyle.Link,
    borderColor: BorderColor? = null,
    positiveButtonStyle: ButtonStyle = ButtonStyle.Primary,
    negativeButtonStyle: ButtonStyle = ButtonStyle.Secondary,
) {
    Div(
        attrs = modifier
            .id(id)
            .zIndex(9)
            .classNames("toast", style.value)
            .styleModifier {
                property("pointer-events", "auto")
            }
            .toAttrs {
                attr("role", "alert")
                attr("aria-live", "assertive")
                attr("aria-atomic", "true")
                attr("data-bs-autohide", autoHide.toString())
            }
    ) {
        Div(
            attrs = Modifier.classNames("toast-body").toAttrs(),
        ) {
            SpanText(text = text)
            Row(
                modifier = Modifier
                    .classNames("mt-2", "pt-2", "border-top")
                    .thenIf(
                        condition = borderColor != null,
                        other = Modifier.classNames(borderColor?.value ?: "")
                    )
            ) {
                BSButton(
                    text = positiveButtonText,
                    size = ButtonSize.Small,
                    style = positiveButtonStyle,
                    onClick = onPositiveButtonClick
                )
                BSButton(
                    modifier = Modifier
                        .margin(left = 8.px)
                        .attrsModifier {
                            attr("data-bs-dismiss", "toast")
                        },
                    text = negativeButtonText,
                    size = ButtonSize.Small,
                    style = negativeButtonStyle,
                    onClick = onNegativeButtonClick
                )
            }
        }
    }
}

/**
 * A function which is used to trigger/show a Toast component which you have already
 * declared somewhere within your composable hierarchy.
 * @param toastId The ID of the Toast component that you've already declared, and want to show.
 * */
fun showToast(toastId: String) {
    try {
        val toastElement = (document.getElementById(toastId) as HTMLDivElement)
        val jsCode = """
            const toast = new bootstrap.Toast(toastElement);
            toast.show();
        """.trimIndent()
        js("eval(jsCode)") as Unit
    } catch (e: Exception) {
        println("showToast: ${e.message}")
    }
}