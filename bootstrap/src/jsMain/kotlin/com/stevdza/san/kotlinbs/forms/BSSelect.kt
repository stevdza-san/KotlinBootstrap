package com.stevdza.san.kotlinbs.forms

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.stevdza.san.kotlinbs.models.InputValidation
import com.stevdza.san.kotlinbs.models.SelectSize
import com.stevdza.san.kotlinbs.util.UniqueIdGenerator
import com.varabyte.kobweb.compose.css.disabled
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.attributes.selected
import org.jetbrains.compose.web.dom.*

/**
 * This component allows you to make a single selection from a list of predefined
 * options. Select components are widely used for various purposes, such as selecting
 * a country in a registration form, choosing a product category in an e-commerce site, etc.
 * @param id A unique identifier of the component.
 * @param items Here you define a list of items to be displayed inside this component.
 * @param placeholder Placeholder that that will be displayed by default.
 * @param size The size of the component.
 * @param validation Define the Valid/Invalid style of the component.
 * @param disabled Whether this component should be disabled or not.
 * @param floating Whether to use the floating style of the component.
 * @param floatingLabel The label that will be displayed on top of the component if
 * the [floating] is enabled.
 * @param onItemSelect Lambda which is triggered when you select an option from this
 * component. It provides an index value and the text of the selected option.
 * */
@Composable
fun BSSelect(
    modifier: Modifier = Modifier,
    id: String? = null,
    items: List<String>,
    placeholder: String? = null,
    size: SelectSize = SelectSize.Default,
    validation: InputValidation = InputValidation(),
    disabled: Boolean = false,
    floating: Boolean = false,
    floatingLabel: String = "Select",
    onItemSelect: (Int, String) -> Unit
) {
    val randomId = remember {
        id ?: UniqueIdGenerator.generateUniqueId("select")
    }
    if (floating) {
        Div(
            attrs = modifier
                .classNames("form-floating")
                .toAttrs()
        ) {
            BSSelectInternal(
                id = randomId,
                items = items,
                placeholder = placeholder,
                validation = validation,
                size = size,
                disabled = disabled,
                onItemSelect = onItemSelect
            )
            Label(
                attrs = Modifier
                    .classNames("form-label")
                    .toAttrs(),
                forId = randomId
            ) {
                Text(value = floatingLabel)
            }
        }
    } else {
        Div(attrs = modifier.toAttrs()) {
            BSSelectInternal(
                modifier = modifier,
                id = randomId,
                items = items,
                placeholder = placeholder,
                validation = validation,
                size = size,
                disabled = disabled,
                onItemSelect = onItemSelect
            )
        }
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
    onItemSelect: (Int, String) -> Unit
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
                onChange {
                    it.value?.let { text ->
                        if (text != placeholder) {
                            onItemSelect(items.indexOf(text), text)
                        }
                    }
                }
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
        items.forEach { text ->
            Option(value = text) {
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