package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.stevdza.san.kotlinbs.models.AccordionItem
import com.stevdza.san.kotlinbs.util.UniqueIdGenerator
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2

/**
 * UI element that allows you to create collapsible and expandable sections of content.
 * It is often used to display information in a compact and organized manner,
 * especially when you have a lot of content to present in a limited space.
 * @param id A unique identifier for the parent.
 * @param items One or multiple [AccordionItem]'s that represents the content that
 * you want to make expandable.
 * @param flush If set to true, it will remove some borders and rounded corners
 * to render accordions edge-to-edge with their parent container.
 * @param alwaysOpen If set to true, it will make accordion items stay open
 * when another item is opened.
 * */
@Composable
fun BSAccordion(
    modifier: Modifier = Modifier,
    id: String? = null,
    items: List<AccordionItem>,
    flush: Boolean = false,
    alwaysOpen: Boolean = false
) {
    val randomId = remember {
        id ?: UniqueIdGenerator.generateUniqueId("accordion")
    }
    Div(
        attrs = modifier
            .id(randomId)
            .classNames("accordion")
            .thenIf(
                condition = flush,
                other = Modifier.classNames("accordion-flush")
            )
            .toAttrs()
    ) {
        items.forEachIndexed { index, accordionItem ->
            val newRandomId = UniqueIdGenerator.generateUniqueId("$index-accordion")
            Div(attrs = Modifier.classNames("accordion-item").toAttrs()) {
                H2(
                    attrs = Modifier
                        .id("header-${randomId}")
                        .classNames("accordion-header")
                        .toAttrs()
                ) {
                    Button(attrs = Modifier
                        .classNames("accordion-button")
                        .thenIf(
                            condition = !accordionItem.defaultOpened,
                            other = Modifier.classNames("collapsed")
                        )
                        .toAttrs {
                            attr("type", "button")
                            attr("data-bs-toggle", "collapse")
                            attr("data-bs-target", "#collapse-${newRandomId}")
                            attr("aria-expanded", "true")
                            attr("aria-controls", "collapse-${newRandomId}")
                        }
                    ) {
                        SpanText(text = accordionItem.title)
                    }
                }
                Div(
                    attrs = Modifier
                        .id("collapse-${newRandomId}")
                        .classNames("accordion-collapse", "collapse")
                        .thenIf(
                            condition = accordionItem.defaultOpened,
                            other = Modifier.classNames("show")
                        )
                        .toAttrs {
                            attr("aria-labelledby", "header-${randomId}")
                            if (!alwaysOpen) attr("data-bs-parent", "#${randomId}")
                        }
                ) {
                    Div(attrs = Modifier.classNames("accordion-body").toAttrs()) {
                        accordionItem.content()
                    }
                }
            }
        }
    }
}