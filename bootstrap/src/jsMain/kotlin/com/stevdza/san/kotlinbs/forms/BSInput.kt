package com.stevdza.san.kotlinbs.forms

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.InputSize
import com.stevdza.san.kotlinbs.models.InputValidation
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.readOnly
import org.jetbrains.compose.web.attributes.required
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text

/**
 * UI component used to capture user input or display information. It provides a text field
 * or other types of input fields where users can enter data.
 * @param id Unique identifier of the component.
 * @param label Input field label.
 * @param placeholder Input field placeholder.
 * @param type The type of the input.
 * @param size The size of the input.
 * @param disabled Whether this component should be disabled or not.
 * @param readOnly Whether to enable a read-only state of the component.
 * @param plainText Whether to remove all default styling from the component.
 * @param floating Whether to use a floating variant of the component.
 * @param required This field is particularly used inside a Form to indicate that
 * the form cannot be submitted if this field is empty.
 * @param validation Here you can customize the look of the input component, in two
 * different states: Success and Error.
 * @param value A default value that will be included inside the input.
 * @param onValueChange Lambda that will be triggered when a user types something
 * inside the component.
 * */
@Composable
fun BSInput(
    modifier: Modifier = Modifier,
    id: String,
    label: String? = null,
    placeholder: String? = null,
    type: InputType<String> = InputType.Text,
    size: InputSize = InputSize.Default,
    disabled: Boolean = false,
    readOnly: Boolean = false,
    plainText: Boolean = false,
    floating: Boolean = false,
    required: Boolean = false,
    validation: InputValidation = InputValidation(),
    value: String,
    onValueChange: (String) -> Unit,
    onEnterClick: (() -> Unit)? = null
) {
    Div(
        attrs = modifier
            .thenIf(
                condition = floating,
                other = Modifier.classNames("form-floating")
            )
            .toAttrs()
    ) {
        if (!floating && label != null) {
            Label(
                attrs = Modifier
                    .classNames("form-label")
                    .toAttrs(),
                forId = id
            )
            {
                Text(value = label)
            }
        }
        Input(
            attrs = Modifier
                .id(id)
                .classNames(if (plainText) "form-control-plaintext" else "form-control")
                .thenIf(
                    condition = validation.isValid,
                    other = Modifier.classNames("is-valid")
                )
                .thenIf(
                    condition = validation.isInvalid,
                    other = Modifier.classNames("is-invalid")
                )
                .thenIf(
                    condition = size != InputSize.Default,
                    other = Modifier.classNames(size.value)
                )
                .toAttrs {
                    value(value)
                    onInput { onValueChange(it.value) }
                    onKeyDown {
                        if (onEnterClick != null) {
                            it.preventDefault()
                            if (it.key == "Enter") {
                                onEnterClick()
                            }
                        }
                    }
                    if (!placeholder.isNullOrEmpty()) attr("placeholder", placeholder)
                    if (disabled) disabled()
                    if (readOnly) readOnly()
                    if (required) required()
                },
            type = type
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
        if (floating && label != null) {
            Label(
                attrs = Modifier
                    .classNames("form-label")
                    .toAttrs(),
                forId = id
            )
            {
                Text(value = label)
            }
        }
    }
}