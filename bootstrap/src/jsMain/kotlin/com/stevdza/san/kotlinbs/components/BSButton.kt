package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.stevdza.san.kotlinbs.models.BSBorderRadius
import com.stevdza.san.kotlinbs.models.button.*
import com.stevdza.san.kotlinbs.util.UniqueIdGenerator
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

/**
 * Buttons are used to trigger actions or events when clicked or tapped.
 * They are an essential part of any user interface as they provide a way for users
 * to interact with and control the application or website.
 * @param id A unique identifier of the button.
 * @param text Text that will appear on top of the button.
 * @param variant This one is used to stylize your button with a different color.
 * @param type Determine the behavior of the button when clicked or activated.
 * @param size The overall size of the button.
 * @param borderRadius The radius level of the button corners.
 * @param customization This is the place where you customize the button style all by
 * yourself. You will need to add styles of many properties, to handle different states.
 * If you have multiple buttons that will use this same custom style, it's usually
 * a good idea to create a top level variable that will hold the same [ButtonCustomization],
 * properties, so that it can be reused multiple times.
 * NOTE: When this parameter is specified, the [size], [variant] and [borderRadius]
 * parameters wil not work, because you're in full charge of the button customization.
 * @param disabled Whether a button is clickable or not.
 * @param loading When set to true, a loading indicator will appear. It's often used
 * with the other [loadingText] parameter. When loading is equal to 'true' the [onClick]
 * lambda is disabled.
 * @param loadingText Here you specify the text that will be shown, when the loading
 * state of the button changes to true.
 * @param badge Small badge or label, providing additional information or indicating
 * a specific status or count associated with the button.
 * @param onClick Lambda which is triggered everytime a user clicks on a button.
 * */
@Composable
fun BSButton(
    modifier: Modifier = Modifier,
    id: String? = null,
    text: String,
    variant: ButtonVariant = ButtonVariant.Primary,
    type: ButtonType = ButtonType.Button,
    size: ButtonSize = ButtonSize.Default,
    borderRadius: BSBorderRadius? = null,
    customization: ButtonCustomization? = null,
    disabled: Boolean = false,
    loading: Boolean = false,
    loadingText: String? = null,
    badge: ButtonBadge? = null,
    onClick: () -> Unit
) {
    val randomId = remember {
        id ?: UniqueIdGenerator.generateUniqueId("button")
    }
    Button(attrs = Modifier
        .then(modifier)
        .id(randomId)
        .onClick { onClick() }
        .thenIf(
            condition = customization == null && borderRadius != null,
            other = borderRadius?.let {
                Modifier.borderRadius(
                    topLeft = it.topLeft,
                    topRight = borderRadius.topRight,
                    bottomRight = borderRadius.bottomRight,
                    bottomLeft = borderRadius.bottomLeft
                )
            } ?: Modifier
        )
        .thenIf(
            condition = customization == null,
            other = Modifier.classNames(
                *variant.classes.toTypedArray(),
                size.value
            )
        )
        .thenIf(
            condition = customization != null,
            other = Modifier.classNames(ButtonSize.Default.value)
        )
        .classNames(
            "d-flex",
            "align-items-center",
        )
        .thenIf(
            condition = badge != null,
            other = Modifier.classNames("position-relative")
        )
        .styleModifier {
            if (customization != null) {
                customization.color?.let { property(ButtonProperty.COLOR, it) }
                customization.backgroundColor?.let { property(ButtonProperty.BACKGROUND_COLOR, it) }
                customization.borderColor?.let { property(ButtonProperty.BORDER_COLOR, it) }
                customization.hoverColor?.let { property(ButtonProperty.HOVER_COLOR, it) }
                customization.hoverBackgroundColor?.let { property(ButtonProperty.HOVER_BACKGROUND_COLOR, it) }
                customization.hoverBorderColor?.let { property(ButtonProperty.HOVER_BORDER_COLOR, it) }
                customization.activeColor?.let { property(ButtonProperty.ACTIVE_COLOR, it) }
                customization.activeBackgroundColor?.let { property(ButtonProperty.ACTIVE_BACKGROUND_COLOR, it) }
                customization.activeBorderColor?.let { property(ButtonProperty.ACTIVE_BORDER_COLOR, it) }
                customization.disabledColor?.let { property(ButtonProperty.DISABLED_COLOR, it) }
                customization.disabledBackgroundColor?.let {
                    property(
                        ButtonProperty.DISABLED_BACKGROUND_COLOR,
                        it
                    )
                }
                customization.disabledBorderColor?.let { property(ButtonProperty.DISABLED_BORDER_COLOR, it) }

                property(ButtonProperty.BORDER_RADIUS, customization.borderRadius.value)
                property(ButtonProperty.HORIZONTAL_PADDING, customization.horizontalPadding)
                property(ButtonProperty.VERTICAL_PADDING, customization.verticalPadding)

                customization.fontFamily?.let { property(ButtonProperty.FONT_FAMILY, it) }
                property(ButtonProperty.FONT_SIZE, customization.fontSize)
                property(ButtonProperty.FONT_WEIGHT, customization.fontWeight.toString())
                property(ButtonProperty.LINE_HEIGHT, customization.lineHeight.toString())

                property(ButtonProperty.GRADIENT, customization.gradient.toString())
            }
        }
        .toAttrs {
            attr("type", type.value)
            if (disabled || loading) disabled()
        }
    ) {
        if (badge != null) {
            BSBadge(
                modifier = badge.modifier
                    .classNames(
                        "position-absolute",
                        "top-0",
                        "start-100",
                        "translate-middle"
                    ),
                text = badge.text,
                style = badge.style,
                variant = badge.variant,
            )
        }
        if (loading) {
            if (loadingText != null) {
                Span(attrs = Modifier
                    .margin(right = 6.px)
                    .classNames("spinner-border", "spinner-border-sm")
                    .toAttrs {
                        attr("role", "status")
                        attr("aria-hidden", "true")
                    }
                )
                Text(value = loadingText)
            } else {
                Span(attrs = Modifier
                    .classNames("spinner-border", "spinner-border-sm")
                    .toAttrs {
                        attr("role", "status")
                        attr("aria-hidden", "true")
                    }
                )
                Span(
                    attrs = Modifier
                        .classNames("visually-hidden")
                        .toAttrs()
                ) {
                    Text(value = "Loading...")
                }
            }
        } else {
            SpanText(text = text)
        }
    }
}