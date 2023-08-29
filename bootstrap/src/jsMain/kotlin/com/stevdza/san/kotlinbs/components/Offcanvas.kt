package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.offcanvas.OffcanvasPlacement
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H5

/**
 * Offcanvas is used to create sidebar or panel that can slide in and out of the viewport.
 * This component is often used to display additional content, navigation menus,
 * or options without taking up the entire screen space.
 *
 * @param id Unique identifier of the component. You will need this in order to
 * trigger/show the [BSOffcanvas] component. To do that, specify a [showOffcanvasOnClick]
 * modifier on a clickable component, that you want to trigger a [BSOffcanvas] with.
 * There's also a [hideOffcanvasOnClick] modifier that is applied on a clickable
 * component that you want to use for closing the [BSOffcanvas].
 * @param title The title which is displayed on the top of the component, along with
 * a [BSCloseButton].
 * @param body This is where you place a custom components inside the body of this
 * component.
 * @param dark Whether this component should have a dark background or not.
 * @param allowScrolling Whether to allow scrolling on the page, while [BSOffcanvas]
 * is active.
 * @param disableBackdrop Whether to remove a black overlay behind the component.
 * @param closableOutside Whether to allow users to close this component by clicking
 * anywhere on the outside.
 * @param placement Side on which you want this component to appear.
 * */
@Composable
fun BSOffcanvas(
    modifier: Modifier = Modifier,
    id: String,
    title: String,
    body: @Composable () -> Unit,
    dark: Boolean = false,
    allowScrolling: Boolean = false,
    disableBackdrop: Boolean = false,
    closableOutside: Boolean = true,
    placement: OffcanvasPlacement = OffcanvasPlacement.END
) {
    Div(
        attrs = modifier
            .id(id)
            .classNames("offcanvas",placement.value)
            .toAttrs {
                attr("tabindex", "-1")
                attr("aria-labelledby", "offcanvasLabel")
                attr("aria-controls", "#$id")
                if (allowScrolling) attr("data-bs-scroll", "true")
                if (disableBackdrop) attr("data-bs-backdrop", "false")
                if (!closableOutside) attr("data-bs-backdrop", "static")
                if (dark) attr("data-bs-theme", "dark")
            }
    ) {
        Div(
            attrs = Modifier
                .classNames("offcanvas-header")
                .toAttrs()
        ) {
            H5(
                attrs = Modifier
                    .id("offcanvasLabel")
                    .classNames("offcanvas-title")
                    .toAttrs()
            ) {
                SpanText(text = title)
            }
            BSCloseButton(modifier = Modifier.hideOffcanvasOnClick())
        }
        Div(
            attrs = Modifier
                .classNames("offcanvas-body")
                .toAttrs()
        ) {
            body()
        }
    }
}

/**
 * Util function which is used to trigger/show [BSOffcanvas] component.
 * */
fun Modifier.showOffcanvasOnClick(id: String): Modifier = attrsModifier {
    attr("data-bs-toggle", "offcanvas")
    attr("data-bs-target", "#$id")
}

/**
 * Util function which is used to hide [BSOffcanvas] component.
 * */
fun Modifier.hideOffcanvasOnClick(): Modifier = attrsModifier {
    attr("data-bs-dismiss", "offcanvas")
}