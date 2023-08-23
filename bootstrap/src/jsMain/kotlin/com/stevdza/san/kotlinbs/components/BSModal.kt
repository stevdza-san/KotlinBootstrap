package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.ButtonStyle
import com.stevdza.san.kotlinbs.models.ModalSize
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

/**
 * Powerful UI element used to display content, messages, or interactive forms in a popup
 * window that temporarily overlays the main content of a webpage. Modals are commonly used
 * to grab the user's attention and prompt them for an action, display additional information,
 * or confirm a choice.
 * This component comes with a [showModal] util function, that is used to trigger/show
 * this component.
 * @param id A unique identifier of a parent component.
 * @param title Modal title.
 * @param body Modal body.
 * @param negativeButtonText Text of the negative button.
 * @param positiveButtonText Text of the positive button.
 * @param closableOutside Whether we can close a Modal when clicking somewhere outside.
 * @param centered Whether to center the content of the Modal.
 * @param size The size of the Modal itself.
 * @param onNegativeButtonClick Lambda which is triggered when a negative button is clicked.
 * @param onPositiveButtonClick Lambda which is triggered when a positive button is clicked.
 * */
@Composable
fun BSModal(
    modifier: Modifier = Modifier,
    id: String,
    title: String,
    body: String,
    negativeButtonText: String = "Close",
    positiveButtonText: String = "Okay",
    closableOutside: Boolean = false,
    centered: Boolean = true,
    size: ModalSize = ModalSize.None,
    onNegativeButtonClick: () -> Unit,
    onPositiveButtonClick: () -> Unit,
) {
    Div(attrs = modifier
        .id(id)
        .classNames("modal", "fade")
        .thenIf(
            condition = !closableOutside,
            other = Modifier.attrsModifier {
                attr("data-bs-backdrop", "static")
            }
        )
        .toAttrs {
            attr("tabindex", "-1")
        }
    ) {
        Div(
            attrs = Modifier
                .classNames("modal-dialog")
                .thenIf(
                    condition = size != ModalSize.None,
                    other = Modifier.classNames(size.value)
                )
                .thenIf(
                    condition = centered,
                    other = Modifier.classNames("modal-dialog-centered")
                )
                .toAttrs()
        ) {
            Div(
                attrs = Modifier
                    .classNames("modal-content")
                    .toAttrs()
            ) {
                Div(
                    attrs = Modifier
                        .classNames("modal-header")
                        .toAttrs()
                ) {
                    H2(
                        attrs = Modifier
                            .classNames("modal-title")
                            .toAttrs()
                    ) {
                        Text(value = title)
                    }
                    BSCloseButton(modifier = Modifier.attrsModifier {
                        attr("data-bs-dismiss", "modal")
                    })
                }
                Div(
                    attrs = Modifier
                        .classNames("modal-body")
                        .toAttrs()
                ) {
                    P {
                        Text(value = body)
                    }
                }
                Div(
                    attrs = Modifier
                        .classNames("modal-footer")
                        .toAttrs()
                ) {
                    BSButton(
                        modifier = Modifier.attrsModifier {
                            attr("data-bs-dismiss", "modal")
                        },
                        text = negativeButtonText,
                        style = ButtonStyle.Secondary,
                        onClick = { onNegativeButtonClick() }
                    )
                    BSButton(
                        modifier = Modifier.attrsModifier {
                            attr("data-bs-dismiss", "modal")
                        },
                        text = positiveButtonText,
                        style = ButtonStyle.Primary,
                        onClick = { onPositiveButtonClick() }
                    )
                }
            }
        }
    }
}

/**
 * Util function which is used in a combination with [BSModal].
 * */
fun Modifier.showModal(id: String): Modifier = attrsModifier {
    attr("data-bs-toggle", "modal")
    attr("data-bs-target", "#$id")
}