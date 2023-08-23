package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.forms.BSInput
import com.stevdza.san.kotlinbs.models.*
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.*
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

/**
 * UI element that helps create responsive navigation menus for websites or web applications.
 * The NavBar provides a consistent and user-friendly way to navigate between different
 * sections or pages of a website.
 *
 * The NavBar typically appears at the top of the web page and contains various navigation
 * elements such as links, buttons, dropdown menus, and branding elements like logos or
 * site names. It adapts to different screen sizes and devices, making it ideal for
 * responsive web design.
 * @param brand A [NavBarBrand] that allows you to specify a brand text, and optional
 * brand image as well.
 * @param items Currently there are two different [NavItem]'s that you can use. [NavLink]
 * that represents a simple link within this component, usually used to navigate between
 * different pages on your website. And the second one [NavDropdown] used to display a
 * dropdown menu item within this component.
 * @param inputField Use this parameter if you want to display an input field with an
 * optional button inside your component.
 * @param navText A simple text element that appears on this component.
 * @param expand This parameter allows you to specify when should your component
 * display a collapsed state.
 * @param backgroundStyle A background style of this component.
 * @param onNavLinkClick Lambda that is triggered when you click on one of the [NavLink]'s.
 * It provides two values, the first one is an index position of the [NavLink], and the
 * second one is it's title.
 * @param onNavDropdownItemClick Lambda that is triggered when you click on one of the
 * [NavDropdownItem]'s. It provides two values, the first one is an index position of
 * the [NavDropdownItem], and the second one is it's title.
 * */
@Composable
fun BSNavBar(
    modifier: Modifier = Modifier,
    brand: NavBarBrand,
    items: List<NavItem>,
    inputField: NavBarInputField? = null,
    navText: String? = null,
    expand: NavBarExpand = NavBarExpand.LG,
    backgroundStyle: BackgroundStyle = BackgroundStyle.Light,
    onNavLinkClick: (Int, NavLink) -> Unit,
    onNavDropdownItemClick: (Int, NavDropdownItem) -> Unit
) {
    Nav(
        attrs = modifier
            .classNames(
                "navbar",
                expand.value,
                backgroundStyle.value,
                if (backgroundStyle == BackgroundStyle.Light ||
                    backgroundStyle == BackgroundStyle.Info ||
                    backgroundStyle == BackgroundStyle.Warning
                ) "navbar-light"
                else "navbar-dark"
            )
            .toAttrs()
    ) {
        Div(
            attrs = Modifier.classNames("container-fluid").toAttrs()
        ) {
            A(
                attrs = Modifier.classNames("navbar-brand").toAttrs(),
                href = brand.href
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (brand.image != null) {
                        Image(
                            modifier = Modifier
                                .size(brand.imageSize)
                                .classNames("d-inline-block", "align-text-top")
                                .attrsModifier {
                                    attr("alt", "logo")
                                },
                            src = brand.image,
                            desc = "Brand Logo"
                        )
                    }
                    SpanText(brand.title)
                }
            }
            Button(
                attrs = Modifier
                    .classNames("navbar-toggler")
                    .toAttrs {
                        attr("data-bs-toggle", "collapse")
                        attr("data-bs-target", "#navbarSupportedContent")
                        attr("aria-controls", "navbarSupportedContent")
                        attr("aria-expanded", "false")
                        attr("aria-label", "Toggle Navigation")
                    }
            ) {
                Span(attrs = Modifier.classNames("navbar-toggler-icon").toAttrs())
            }
            Div(
                attrs = Modifier
                    .id("navbarSupportedContent")
                    .classNames("collapse", "navbar-collapse")
                    .toAttrs()
            ) {
                Ul(
                    attrs = Modifier
                        .classNames("navbar-nav", "me-auto", "mb-2", "mb-lg-0")
                        .toAttrs()
                ) {
                    items.forEachIndexed { index, navItem ->
                        if (navItem is NavDropdown) {
                            Li(
                                attrs = Modifier
                                    .classNames("nav-item", "dropdown")
                                    .toAttrs()
                            ) {
                                A(
                                    attrs = Modifier
                                        .classNames("nav-link", "dropdown-toggle")
                                        .toAttrs {
                                            attr("role", "button")
                                            attr("data-bs-toggle", "dropdown")
                                            attr("aria-expanded", "false")
                                        }
                                ) {
                                    Text(value = navItem.placeholder)
                                }
                                Ul(
                                    attrs = Modifier.classNames("dropdown-menu").toAttrs()
                                ) {
                                    navItem.items.forEachIndexed { index, dropdownItem ->
                                        Li(
                                            attrs = Modifier
                                                .id(dropdownItem.id)
                                                .onClick {
                                                    onNavDropdownItemClick(index, dropdownItem)
                                                }
                                                .toAttrs()
                                        ) {
                                            A(
                                                attrs = Modifier
                                                    .classNames("dropdown-item")
                                                    .toAttrs(),
                                                href = dropdownItem.href
                                            ) { Text(value = dropdownItem.title) }
                                        }
                                    }
                                }
                            }
                        } else if (navItem is NavLink) {
                            Li(
                                attrs = Modifier
                                    .id(navItem.id)
                                    .classNames("nav-item")
                                    .onClick { onNavLinkClick(index, navItem) }
                                    .toAttrs()
                            ) {
                                A(
                                    attrs = Modifier
                                        .classNames("nav-link")
                                        .thenIf(
                                            condition = navItem.active,
                                            other = Modifier.classNames("active")
                                        )
                                        .thenIf(
                                            condition = navItem.disabled,
                                            other = Modifier.classNames("disabled")
                                        )
                                        .toAttrs {
                                            if (navItem.active) attr("aria-current", "page")
                                        },
                                    href = navItem.href
                                ) {
                                    Text(value = navItem.title)
                                }
                            }
                        }
                    }
                }
                if (navText != null) {
                    Span(
                        attrs = Modifier
                            .margin(right = if (inputField != null) 8.px else 0.px)
                            .classNames("navbar-text")
                            .toAttrs()
                    ) {
                        Text(value = navText)
                    }
                }
                if (inputField != null) {
                    Form(
                        attrs = Modifier
                            .classNames("d-flex")
                            .toAttrs {
                                attr("role", "search")
                            }
                    ) {
                        BSInput(
                            id = inputField.id,
                            placeholder = inputField.placeholder,
                            value = inputField.value,
                            onValueChange = inputField.onValueChange,
                            onEnterClick = inputField.onEnterClick
                        )
                        if (inputField.button != null) {
                            BSButton(
                                modifier = Modifier.margin(left = 8.px),
                                id = inputField.button.id,
                                text = inputField.button.text,
                                style = inputField.button.style,
                                type = inputField.button.type,
                                onClick = inputField.button.onClick
                            )
                        }
                    }
                }
            }
        }
    }
}