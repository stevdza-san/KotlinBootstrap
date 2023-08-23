package com.stevdza.san.kotlinbs.forms

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.InputSize
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text

/**
 * UI component that allows users to select a color or specify a custom color
 * using a color picker. It is used to capture color preferences or to enable users
 * to choose colors for various purposes, such as styling, theming, or data visualization.
 * @param id Unique identifier of the color picker.
 * @param label Color picker label.
 * @param title Color picker title.
 * @param size Size of a color picker.
 * @param disabled Whether this component is disabled or not.
 * @param onColorSelected Lambda which is triggered when a user selects a color.
 * */
@Composable
fun BSColorPicker(
    modifier: Modifier = Modifier,
    id: String,
    label: String = "Color Picker",
    title: String = "Choose your color",
    size: InputSize = InputSize.Default,
    disabled: Boolean = false,
    onColorSelected: (String) -> Unit
) {
    Div(attrs = modifier.toAttrs()) {
        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = id
        )
        {
            Text(value = label)
        }
        Input(
            attrs = Modifier
                .id(id)
                .classNames("form-control-color", "form-control")
                .thenIf(
                    condition = size != InputSize.Default,
                    other = Modifier.classNames(size.value)
                )
                .toAttrs {
                    onChange { onColorSelected(it.value) }
                    if (disabled) disabled()
                    attr("title", title)
                    attr("value", "#000000")
                },
            type = InputType.Color
        )
    }
}