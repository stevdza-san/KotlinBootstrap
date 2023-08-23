package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.*
import com.stevdza.san.kotlinbs.models.ButtonSize
import com.stevdza.san.kotlinbs.models.ButtonStyle
import com.stevdza.san.kotlinbs.models.DropdownDirection
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.dom.*

/**
 * A versatile UI element that allows you to create a menu or a list of options that can be
 * toggled to appear or disappear when triggered by user interaction. It provides a dropdown
 * menu that can contain other interactive elements.
 * @param items List of one or multiple strings that should be displayed within the dropdown.
 * @param disabledItems List of one or multiple string items that should be displayed as
 * disabled within the dropdown.
 * @param style The style of the dropdown button.
 * @param size The size of the dropdown button.
 * @param direction Direction in which the dropdown should appear after it's opened.
 * @param splitToggleButton Whether the dropdown arrow should be presented as a separate
 * button within the dropdown button.
 * @param darkBackground Whether to display a dark background on a dropdown menu, when opened.
 * @param onItemSelect Lambda which is triggered when an item from the dropdown is clicked.
 * */
@Composable
fun BSDropdown(
    modifier: Modifier = Modifier,
    items: List<String>,
    placeholder: String? = null,
    disabledItems: List<String>? = null,
    style: ButtonStyle = ButtonStyle.Primary,
    size: ButtonSize = ButtonSize.Default,
    direction: DropdownDirection = DropdownDirection.Bottom,
    splitToggleButton: Boolean = false,
    darkBackground: Boolean = false,
    onItemSelect: (Int, String) -> Unit
) {
    var selectedItem by remember { mutableStateOf(items.first()) }
    Div(
        attrs = modifier
            .classNames(if (splitToggleButton) "btn-group" else "dropdown")
            .thenIf(
                condition = direction != DropdownDirection.Bottom,
                other = Modifier.classNames(direction.value.toString())
            )
            .toAttrs()
    ) {
        Button(
            attrs = Modifier
                .classNames(
                    *style.classes.toTypedArray(),
                    size.value
                )
                .thenIf(
                    condition = !splitToggleButton,
                    other = Modifier.classNames("dropdown-toggle")
                )
                .toAttrs {
                    attr("type", "button")
                    attr("data-bs-toggle", "dropdown")
                }
        ) {
            SpanText(placeholder ?: selectedItem)
        }
        if (splitToggleButton) {
            Button(
                attrs = Modifier
                    .classNames(
                        *style.classes.toTypedArray(),
                        size.value,
                        "dropdown-toggle",
                        "dropdown-toggle-split"
                    )
                    .toAttrs {
                        attr("type", "button")
                        attr("data-bs-toggle", "dropdown")
                    }
            ) {
                Span(attrs = Modifier.classNames("visually-hidden").toAttrs()) {
                    Text(value = "Toggle Dropdown")
                }
            }
        }
        Ul(
            attrs = Modifier
                .classNames("dropdown-menu")
                .thenIf(
                    condition = darkBackground,
                    other = Modifier.classNames("dropdown-menu-dark")
                )
                .toAttrs()
        ) {
            repeat(items.size) { index ->
                val isDisabled = disabledItems?.contains(items[index]) ?: false
                Li(
                    attrs = Modifier
                        .onClick {
                            if (!isDisabled) {
                                selectedItem = items[index]
                                onItemSelect(index, items[index])
                            }
                        }
                        .cursor(if (isDisabled) Cursor.NotAllowed else Cursor.Pointer)
                        .toAttrs()
                ) {
                    A(
                        attrs = Modifier
                            .classNames("dropdown-item")
                            .thenIf(
                                condition = selectedItem == items[index],
                                other = Modifier.classNames("active")
                            )
                            .thenIf(
                                condition = isDisabled,
                                other = Modifier.classNames("disabled")
                            )
                            .toAttrs {
                                if (isDisabled) {
                                    attr("tabindex", "-1")
                                    attr("aria-disabled", "true")
                                }
                            }
                    ) {
                        SpanText(text = items[index])
                    }
                }
            }
        }
    }
}