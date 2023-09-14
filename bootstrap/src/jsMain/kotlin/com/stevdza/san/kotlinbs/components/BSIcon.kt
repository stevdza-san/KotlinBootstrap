package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.stevdza.san.kotlinbs.icons.BSIcons
import com.stevdza.san.kotlinbs.util.UniqueIdGenerator
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.dom.I

/**
 * A simple composable function used to represent an icon.
 * @param id A unique identifier of the button.
 * @param icon An object [BSIcons] which is used to specify an icon.
 * @param size The overall size of the icon, usually a default value is '1.cssRem'.
 * @param color The color of the icon.
 * */
@Composable
fun BSIcon(
    modifier: Modifier = Modifier,
    id: String? = null,
    icon: String = BSIcons.CHECK,
    size: CSSNumeric? = null,
    color: CSSColorValue? = null
) {
    val randomId = remember {
        id ?: UniqueIdGenerator.generateUniqueId("icon")
    }
    I(
        attrs = modifier
            .id(randomId)
            .classNames(*icon.split(" ").toList().toTypedArray())
            .thenIf(
                condition = size != null,
                other = size?.let { Modifier.fontSize(it) } ?: Modifier
            )
            .thenIf(
                condition = color != null,
                other = color?.let { Modifier.color(it) } ?: Modifier
            )
            .toAttrs()
    )
}