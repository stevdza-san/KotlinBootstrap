package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSBreadcrumb
import com.stevdza.san.kotlinbs.models.BreadcrumbItem
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BSBreadcrumb(
            items = listOf(
                BreadcrumbItem(
                    text = "Home",
                    href = "https://google.com"
                ),
                BreadcrumbItem(
                    text = "Pricing",
                    href = "https://google.com"
                ),
                BreadcrumbItem(
                    text = "Services",
                    href = "https://google.com"
                ),
                BreadcrumbItem(
                    text = "About",
                    href = "https://google.com"
                ),
                BreadcrumbItem(
                    text = "Contact us",
                    href = "https://google.com"
                )
            )
        )
    }
}