package com.stevdza.san.kotlinbs.forms

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import com.stevdza.san.kotlinbs.models.ButtonStyle
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.attributes.AutoComplete
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.autoComplete
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text

private val radioGroupScopeImpl = BSRadioGroupScope()

/**
 * Component used for allowing users to make a single selection from a predefined
 * set of options. This component is used within the [BSRadioButtonGroup].
 * @param id Unique identifier of the component.
 * @param label Label of the radio button.
 * @param disabled Whether this component should be disabled or not.
 * @param onClick Lambda that is triggered when a user makes a selection.
 * */
@Composable
fun BSRadioGroupScope.BSRadioButton(
    modifier: Modifier = Modifier,
    id: String,
    label: String,
    disabled: Boolean = false,
    onClick: () -> Unit
) {
    val name = getCompositionLocalGroupName()
    val checkedValue = getCompositionLocalCheckedValue()
    val inline = getCompositionLocalInlineValue()
    val reverse = getCompositionLocalReverseValue()
    val toggleButton = getCompositionLocalToggleButton()
    val toggleButtonStyle = getCompositionLocalToggleButtonStyle()

    Div(
        attrs = modifier
            .classNames("form-check")
            .thenIf(
                condition = inline,
                other = Modifier.classNames("form-check-inline")
            )
            .thenIf(
                condition = reverse,
                other = Modifier.classNames("form-check-reverse")
            )
            .toAttrs()
    ) {
        Input(
            attrs = Modifier
                .id(id)
                .thenIf(
                    condition = toggleButton,
                    other = Modifier.classNames("btn-check")
                )
                .thenIf(
                    condition = !toggleButton,
                    other = Modifier.classNames("form-check-input")
                )
                .toAttrs {
                    if (checkedValue == label) defaultChecked()
                    if (disabled) disabled()
                    if (toggleButton) autoComplete(AutoComplete.off)
                    attr("name", name)
                    onClick { onClick() }
                },
            type = InputType.Radio
        )
        Label(
            attrs = Modifier
                .thenIf(
                    condition = toggleButton,
                    other = Modifier.classNames(*toggleButtonStyle.toTypedArray())
                )
                .thenIf(
                    condition = !toggleButton,
                    other = Modifier.classNames("form-check-label")
                )
                .toAttrs(),
            forId = id
        ) {
            Text(value = label)
        }
    }
}

/**
 * Component used for allowing users to make a single selection from a predefined
 *  * set of options. This component is used to wrap multiple different [BSRadioButton]'s
 *  where only a single selection is allowed.
 *  @param name The name of this group (It should be unique).
 *  @param checkedValue A string value that represents a radio button that should be
 *  selected by default. This value needs to be the same as the name of the [BSRadioButton]'s
 *  label.
 *  @param inline Whether this group should be inlined, instead of placed within a column.
 *  @param reverse Whether to reverse the order of the radio button and a label.
 *  @param toggleButton Whether to change the style of the radio buttons to toggle buttons.
 *  @param toggleButtonStyle The style of the toggle button.
 *  @param content Here, inside the lambda we can call one or multiple [BSRadioButton]'s.
 * */
@Composable
fun BSRadioButtonGroup(
    modifier: Modifier = Modifier,
    name: String? = null,
    checkedValue: String?,
    inline: Boolean = false,
    reverse: Boolean = false,
    toggleButton: Boolean = false,
    toggleButtonStyle: ButtonStyle = ButtonStyle.PrimaryOutline,
    content: @Composable BSRadioGroupScope.() -> Unit
) {
    val radioGroupName = remember { name ?: radioGroupScopeImpl.generateNextRadioGroupName() }

    CompositionLocalProvider(
        radioGroupScopeImpl.checkedValueCompositionLocal provides checkedValue,
        radioGroupScopeImpl.groupNameCompositionLocal provides radioGroupName,
        radioGroupScopeImpl.inlineCompositionLocal provides inline,
        radioGroupScopeImpl.reverseCompositionLocal provides reverse,
        radioGroupScopeImpl.toggleButtonCompositionLocal provides toggleButton,
        radioGroupScopeImpl.toggleButtonStyleCompositionLocal provides toggleButtonStyle.classes,
        content = {
            Div(attrs = modifier.toAttrs()) {
                content(radioGroupScopeImpl)
            }
        }
    )
}

class BSRadioGroupScope {
    private var radioGroupNamesCounter = 0

    internal val checkedValueCompositionLocal = compositionLocalOf<String?> {
        error("No radio group checked value provided")
    }

    internal val groupNameCompositionLocal = compositionLocalOf<String> {
        error("No radio group name provided")
    }

    internal val inlineCompositionLocal = compositionLocalOf<Boolean> {
        error("No inline value provided")
    }

    internal val reverseCompositionLocal = compositionLocalOf<Boolean> {
        error("No reverse value provided")
    }

    internal val toggleButtonCompositionLocal = compositionLocalOf<Boolean> {
        error("No toggle button provided")
    }

    internal val toggleButtonStyleCompositionLocal = compositionLocalOf<List<String>> {
        error("No toggle button style provided")
    }

    internal fun generateNextRadioGroupName(): String {
        return "\$compose\$generated\$radio\$group-${radioGroupNamesCounter++}"
    }
}

@Composable
internal fun BSRadioGroupScope.getCompositionLocalCheckedValue(): String? {
    return checkedValueCompositionLocal.current
}

@Composable
internal fun BSRadioGroupScope.getCompositionLocalGroupName(): String {
    return groupNameCompositionLocal.current
}

@Composable
internal fun BSRadioGroupScope.getCompositionLocalInlineValue(): Boolean {
    return inlineCompositionLocal.current
}

@Composable
internal fun BSRadioGroupScope.getCompositionLocalReverseValue(): Boolean {
    return reverseCompositionLocal.current
}

@Composable
internal fun BSRadioGroupScope.getCompositionLocalToggleButton(): Boolean {
    return toggleButtonCompositionLocal.current
}

@Composable
internal fun BSRadioGroupScope.getCompositionLocalToggleButtonStyle(): List<String> {
    return toggleButtonStyleCompositionLocal.current
}