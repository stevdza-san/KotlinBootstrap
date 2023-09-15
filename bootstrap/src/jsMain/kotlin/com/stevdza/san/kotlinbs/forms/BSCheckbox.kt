package com.stevdza.san.kotlinbs.forms

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.stevdza.san.kotlinbs.models.button.ButtonVariant
import com.stevdza.san.kotlinbs.util.UniqueIdGenerator
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.thenIf
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
 * UI component used for allowing users to make multiple selections from a predefined
 * set of options. It represents a checkbox input field with an associated label.
 * @param id Unique identifier of the parent.
 * @param label Checkbox label.
 * @param disabled Whether the checkbox is disabled or not.
 * @param defaultChecked Here you specify a default checked state of the checkbox.
 * @param reverse Whether you want to display the checkbox and the label in a reverse order.
 * @param toggleButton Whether you want to transform the checkbox into a toggle button.
 * @param toggleButtonVariant The style of the toggle button.
 * @param onClick Lambda that is triggered when a user clicks on a checkbox.
 * */
@Composable
fun BSCheckbox(
    modifier: Modifier = Modifier,
    id: String? = null,
    label: String,
    disabled: Boolean = false,
    defaultChecked: Boolean = false,
    reverse: Boolean = false,
    toggleButton: Boolean = false,
    toggleButtonVariant: ButtonVariant = ButtonVariant.PrimaryOutline,
    onClick: (Boolean) -> Unit
) {
    val randomId = remember {
        id ?: UniqueIdGenerator.generateUniqueId("checkbox")
    }
    Div(
        attrs = modifier
            .classNames("form-check")
            .thenIf(
                condition = reverse,
                other = Modifier.classNames("form-check-reverse")
            )
            .toAttrs()
    ) {
        Input(
            attrs = Modifier
                .id(randomId)
                .thenIf(
                    condition = toggleButton,
                    other = Modifier.classNames("btn-check")
                )
                .thenIf(
                    condition = !toggleButton,
                    other = Modifier.classNames("form-check-input")
                )
                .toAttrs {
                    if (defaultChecked) defaultChecked()
                    if (disabled) disabled()
                    onClick {
                        onClick((document.getElementById(randomId) as HTMLInputElement).checked)
                    }
                },
            type = InputType.Checkbox
        )
        Label(
            attrs = Modifier
                .thenIf(
                    condition = toggleButton,
                    other = Modifier.classNames(*toggleButtonVariant.classes.toTypedArray())
                )
                .thenIf(
                    condition = !toggleButton,
                    other = Modifier.classNames("form-check-label")
                )
                .toAttrs(),
            forId = randomId
        ) {
            Text(value = label)
        }
    }
}