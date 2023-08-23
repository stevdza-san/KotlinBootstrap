package com.stevdza.san.kotlinbs.forms

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.InputSize
import com.stevdza.san.kotlinbs.models.InputValidation
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.readOnly
import org.jetbrains.compose.web.attributes.required
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextArea

/**
 * UI component used to capture multi-line text input from users. It provides a resizable
 * input field that allows users to enter and edit longer blocks of text.
 * @param id Unique identifier of the component
 * @param label Label of the component,
 * @param placeholder Placeholder of the component.
 * @param disabled Whether this component is disabled or not.
 * @param readOnly Whether to enable a read-only state of the component.
 * @param floating Whether to use a floating variant of the component.
 * @param required This field is particularly used inside a Form to indicate that
 * @param size The size of the TextArea component.
 * @param validation Here you can customize the look of the input component, in two
 * different states: Success and Error.
 * @param value A default value that will be included inside the input.
 * @param onValueChange Lambda that will be triggered when a user types something
 * inside the component.
 * */
@Composable
fun BSTextArea(
    modifier: Modifier = Modifier,
    id: String,
    label: String? = "Label",
    placeholder: String? = null,
    disabled: Boolean = false,
    readOnly: Boolean = false,
    floating: Boolean = false,
    required: Boolean = false,
    size: InputSize = InputSize.Default,
    validation: InputValidation = InputValidation(),
    value: String,
    onValueChange: (String) -> Unit
) {
    Div(
        attrs = modifier
            .thenIf(
                condition = floating,
                other = Modifier.classNames("form-floating")
            )
            .toAttrs()
    ) {
        if (!floating) {
            Label(
                attrs = Modifier
                    .classNames("form-label")
                    .toAttrs(),
                forId = id
            )
            {
                label?.let { Text(value = it) }
            }
        }
        TextArea(
            attrs = modifier
                .id(id)
                .thenIf(
                    condition = size != InputSize.Default,
                    other = Modifier.classNames(size.value)
                )
                .thenIf(
                    condition = validation.isValid,
                    other = Modifier.classNames("is-valid")
                )
                .thenIf(
                    condition = validation.isInvalid,
                    other = Modifier.classNames("is-invalid")
                )
                .classNames("form-control")
                .toAttrs {
                    value(value)
                    onInput { onValueChange(it.value) }
                    if (!placeholder.isNullOrEmpty()) attr("placeholder", placeholder)
                    if (readOnly) readOnly()
                    if (disabled) disabled()
                    if (required) required()
                }
        )
        if (validation.isValid) {
            Div(
                attrs = Modifier
                    .classNames("valid-feedback")
                    .toAttrs()
            ) {
                Text(value = validation.validFeedback)
            }
        }
        if (validation.isInvalid) {
            Div(
                attrs = Modifier
                    .classNames("invalid-feedback")
                    .toAttrs()
            ) {
                Text(value = validation.invalidFeedback)
            }
        }
        if (floating) {
            Label(forId = id) {
                label?.let { Text(value = it) }
            }
        }
    }
}