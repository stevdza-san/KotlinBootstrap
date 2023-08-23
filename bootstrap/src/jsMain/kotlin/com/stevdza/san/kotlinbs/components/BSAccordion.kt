package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.AccordionItem
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
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
 * */
@Composable
fun BSAccordion(
    modifier: Modifier = Modifier,
    id: String,
    items: List<AccordionItem>
) {
    Div(
        attrs = modifier
            .id(id)
            .classNames("accordion")
            .toAttrs()
    ) {
        items.forEach { accordionItem ->
            Div(attrs = Modifier.classNames("accordion-item").toAttrs()) {
                H2(
                    attrs = Modifier
                        .id("header${accordionItem.body.hashCode()}")
                        .classNames("accordion-header")
                        .toAttrs()
                ) {
                    Button(attrs = Modifier
                        .classNames("accordion-button", "collapsed")
                        .toAttrs {
                            attr("type", "button")
                            attr("data-bs-toggle", "collapse")
                            attr("data-bs-target", "#collapse${accordionItem.hashCode()}")
                            attr("aria-expanded", "true")
                            attr("aria-controls", "collapse${accordionItem.hashCode()}")
                        }
                    ) {
                        SpanText(text = accordionItem.title)
                    }
                }
                Div(
                    attrs = Modifier
                        .id("collapse${accordionItem.hashCode()}")
                        .classNames("accordion-collapse", "collapse")
                        .toAttrs {
                            attr("aria-labelledby", "header${accordionItem.body.hashCode()}")
                            attr("data-bs-parent", id)
                        }
                ) {
                    Div(attrs = Modifier.classNames("accordion-body").toAttrs()) {
                        SpanText(accordionItem.body)
                    }
                }
            }
        }
    }
}