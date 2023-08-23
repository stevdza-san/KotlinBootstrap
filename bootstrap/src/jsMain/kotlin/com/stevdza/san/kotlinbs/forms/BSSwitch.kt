package com.stevdza.san.kotlinbs.forms

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.toAttrs
import kotlinx.browser.document
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLInputElement

/**
 * UI component used for binary on/off or true/false selections. It provides a visually
 * appealing toggle button that can be toggled between two states.
 * @param id Unique identifier of the component.
 * @param label The label of this component.
 * @param defaultChecked Whether this switch should be checked by default.
 * @param disabled Whether this switch should be disabled or not.
 * @param onClick Lambda that is triggered when a user clicks the switch. It holds the
 * boolean value that represents a checked state.
 * */
@Composable
fun BSSwitch(
    modifier: Modifier = Modifier,
    id: String,
    label: String,
    defaultChecked: Boolean = false,
    disabled: Boolean = false,
    onClick: (Boolean) -> Unit
) {
    Div(
        attrs = modifier
            .classNames("form-check", "form-switch")
            .toAttrs()
    ) {
        Input(
            attrs = Modifier
                .id(id)
                .classNames("form-check-input")
                .toAttrs {
                    attr("role", "switch")
                    if (defaultChecked) defaultChecked()
                    if (disabled) disabled()
                    onClick {
                        onClick((document.getElementById(id) as HTMLInputElement).checked)
                    }
                },
            type = InputType.Checkbox
        )
        Label(
            attrs = Modifier
                .classNames("form-check-label")
                .toAttrs(),
            forId = id
        ) {
            Text(value = label)
        }
    }
}