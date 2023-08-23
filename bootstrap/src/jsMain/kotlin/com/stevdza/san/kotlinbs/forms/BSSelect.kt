package com.stevdza.san.kotlinbs.forms

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.InputValidation
import com.stevdza.san.kotlinbs.models.SelectSize
import com.varabyte.kobweb.compose.css.disabled
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.attributes.selected
import org.jetbrains.compose.web.dom.*

@Composable
fun BSSelect(
    modifier: Modifier = Modifier,
    id: String,
    items: List<String>,
    label: String? = "Label",
    placeholder: String? = null,
    size: SelectSize = SelectSize.Default,
    validation: InputValidation = InputValidation(),
    disabled: Boolean = false,
    floating: Boolean = false,
    onItemSelected: (Int, String) -> Unit
) {
    if (floating) {
        Div(
            attrs = modifier
                .classNames("form-floating")
                .toAttrs()
        ) {
            BSSelectInternal(
                id = id,
                items = items,
                placeholder = placeholder,
                validation = validation,
                size = size,
                disabled = disabled,
                onItemSelected = onItemSelected
            )
            Label(
                attrs = Modifier.classNames("form-label").toAttrs(),
                forId = id
            ) {
                label?.let { Text(value = it) }
            }
        }
    } else {
        Label(
            attrs = Modifier.classNames("form-label").toAttrs(),
            forId = id
        ) {
            label?.let { Text(value = it) }
        }
        BSSelectInternal(
            modifier = modifier,
            id = id,
            items = items,
            placeholder = placeholder,
            validation = validation,
            size = size,
            disabled = disabled,
            onItemSelected = onItemSelected
        )
    }
}

@Composable
private fun BSSelectInternal(
    modifier: Modifier? = null,
    id: String,
    items: List<String>,
    placeholder: String?,
    validation: InputValidation,
    size: SelectSize,
    disabled: Boolean,
    onItemSelected: (Int, String) -> Unit
) {
    Select(
        attrs = Modifier
            .then(modifier ?: Modifier)
            .id(id)
            .classNames("form-select")
            .thenIf(
                condition = validation.isValid,
                other = Modifier.classNames("is-valid")
            )
            .thenIf(
                condition = validation.isInvalid,
                other = Modifier.classNames("is-invalid")
            )
            .thenIf(
                condition = size != SelectSize.Default,
                other = Modifier.classNames(size.value)
            )
            .toAttrs {
                if (disabled) disabled()
            }
    ) {
        if (!placeholder.isNullOrEmpty()) {
            Option(
                attrs = Modifier.toAttrs { selected() },
                value = placeholder
            ) {
                Text(placeholder)
            }
        }
        items.forEachIndexed { index, text ->
            Option(
                attrs = Modifier
                    .onClick { onItemSelected(index, text) }
                    .toAttrs(),
                value = text,
            ) {
                Text(value = text)
            }
        }
    }
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
}