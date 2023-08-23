package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.BreadcrumbItem
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.*

/**
 * This component is used to create a navigation trail that indicates the user's current
 * location within a website's hierarchy. It consists of a series of links or text elements
 * separated by a separator character (typically a forward slash ("/")).
 *
 * The purpose of the breadcrumb component is to provide users with a way to understand
 * their current position within the website's structure and easily navigate back
 * to previous pages or sections.
 * @param items One or multiple [BreadcrumbItem]'s that allows you to specify a text
 * along with the link(href) which is used for navigation.
 * @param currentItem An item that is marked as selected.
 * @param separator A symbol which is used to separate [BreadcrumbItem]'s.
 * */
@Composable
fun BSBreadcrumb(
    modifier: Modifier = Modifier,
    items: List<BreadcrumbItem>,
    currentItem: String = items.first().text,
    separator: String = "/"
) {
    Nav(attrs = modifier
        .toAttrs {
            attr("aria-label", "breadcrumb")
            attr("style", "--bs-breadcrumb-divider: '$separator';")
        }
    ) {
        Ol(
            attrs = Modifier
                .classNames("breadcrumb")
                .toAttrs()
        ) {
            items.forEach {
                Li(
                    attrs = Modifier
                        .classNames("breadcrumb-item")
                        .thenIf(
                            condition = currentItem == it.text,
                            other = Modifier.classNames("active")
                        )
                        .toAttrs {
                            if (currentItem == it.text) attr("aria-current", "page")
                        }
                ) {
                    if (currentItem != it.text) {
                        A(href = it.href) {
                            Text(value = it.text)
                        }
                    } else {
                        Text(value = it.text)
                    }
                }
            }
        }
    }
}