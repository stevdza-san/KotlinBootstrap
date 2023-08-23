package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSAccordion
import com.stevdza.san.kotlinbs.models.AccordionItem
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BSAccordion(
            modifier = Modifier.width(300.px),
            items = listOf(
                AccordionItem(
                    title = "Welcome",
                    body = "Lorem ipsum lorem ipsum lorem ipsum."
                ),
                AccordionItem(
                    title = "Github",
                    body = "Visit my open source libraries."
                ),
                AccordionItem(
                    title = "YouTube",
                    body = "Check out my YouTube channel to learn more about Android development."
                )
            )
        )
        BSAccordion(
            modifier = Modifier.width(300.px),
            items = listOf(
                AccordionItem(
                    title = "Welcome2",
                    body = "Lorem ipsum lorem ipsum lorem ipsum."
                ),
                AccordionItem(
                    title = "Github2",
                    body = "Visit my open source libraries."
                ),
                AccordionItem(
                    title = "YouTube2",
                    body = "Check out my YouTube channel to learn more about Android development."
                )
            )
        )
    }
}