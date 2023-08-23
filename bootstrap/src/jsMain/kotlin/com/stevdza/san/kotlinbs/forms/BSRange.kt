package com.stevdza.san.kotlinbs.forms

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.toAttrs
import kotlinx.browser.document
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLInputElement

/**
 * This UI component is used to capture a numeric value within a specified range.
 * It provides a slider control that users can interact with, to select a value within
 * the defined range.
 * @param id Unique identifier of the component.
 * @param label Label of this component.
 * @param min The minimum number which is used in this range.
 * @param max The maximum number which is used in this range.
 * @param step A double value that represents the steps that will be counted while
 * interacting with a component.
 * @param disabled Whether this component should be disabled or not.
 * @param onSelect Lambda which is triggered when you select a value on a slider.
 * It provides a double value that represents a selected number from that range.
 * */
@Composable
fun BSRange(
    modifier: Modifier = Modifier,
    id: String,
    label: String? = "Label",
    min: Int = 0,
    max: Int = 100,
    step: Double = 1.0,
    disabled: Boolean = false,
    onSelect: (Double) -> Unit
) {
    Div(attrs = modifier.toAttrs()) {
        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = id
        ) {
            label?.let { Text(value = it) }
        }
        Input(
            attrs = Modifier
                .id(id)
                .classNames("form-range")
                .toAttrs {
                    if (disabled) disabled()
                    min(value = "$min")
                    max(value = "$max")
                    step(value = step)
                    onClick {
                        onSelect((document.getElementById(id) as HTMLInputElement).value.toDouble())
                    }
                },
            type = InputType.Range
        )
    }
}