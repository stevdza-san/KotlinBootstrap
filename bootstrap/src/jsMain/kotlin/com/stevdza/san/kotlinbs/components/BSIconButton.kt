package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.stevdza.san.kotlinbs.icons.BSIcons
import com.stevdza.san.kotlinbs.models.ButtonBadge
import com.stevdza.san.kotlinbs.models.ButtonSize
import com.stevdza.san.kotlinbs.models.ButtonVariant
import com.stevdza.san.kotlinbs.util.UniqueIdGenerator
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Button

/**
 * This component is used to display an icon within a button, without any text.
 * @param id A unique identifier of the button.
 * @param icon An object [BSIcons] which is used to specify an icon.
 * @param size The overall size of the button.
 * @param variant This one is used to stylize your button with a different color.
 * @param disabled Whether a button is clickable or not.
 * @param badge Small badge or label, providing additional information or indicating
 * a specific status or count associated with the button.
 * @param onClick Lambda which is triggered everytime a user clicks on a button.
 * */
@Composable
fun BSIconButton(
    modifier: Modifier = Modifier,
    id: String? = null,
    icon: String = BSIcons.CHECK,
    size: ButtonSize = ButtonSize.Default,
    variant: ButtonVariant = ButtonVariant.Primary,
    disabled: Boolean = false,
    badge: ButtonBadge? = null,
    onClick: () -> Unit
) {
    val randomId = remember {
        id ?: UniqueIdGenerator.generateUniqueId("iconButton")
    }
    Button(
        attrs = modifier
            .id(randomId)
            .classNames(*variant.classes.toTypedArray(), size.value)
            .thenIf(
                condition = badge != null,
                other = Modifier.classNames("position-relative")
            )
            .onClick { onClick() }
            .toAttrs {
                attr("type", "button")
                attr("tabindex", "-1")
                if (disabled) disabled()
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
        BSIcon(icon = icon)
    }
}