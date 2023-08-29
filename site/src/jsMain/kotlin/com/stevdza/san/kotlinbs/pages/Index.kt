package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSNavBar
import com.stevdza.san.kotlinbs.models.BackgroundStyle
import com.stevdza.san.kotlinbs.models.navbar.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BSNavBar(
            modifier = Modifier.fillMaxWidth(),
//            stickyTop = true,
//            itemsAlignment = Alignment.CenterHorizontally,
            brand = NavBarBrand(
                title = "KotlinBootstrap",
                image = "https://getbootstrap.com/docs/5.3/assets/brand/bootstrap-logo.svg",
                href = "#"
            ),
            expand = NavBarExpand.LG,
            backgroundStyle = BackgroundStyle.Dark,
            items = listOf(
                NavLink(
                    id = "homeLink",
                    title = "Home",
                    onClick = {
                        println("Index: $it Title: Home")
                    }
                ),
                NavLink(
                    id = "servicesLink",
                    title = "Services",
                    onClick = {}
                ),
                NavLink(
                    id = "pricingLink",
                    title = "Pricing",
                    onClick = {}
                ),
                NavLink(
                    id = "aboutLink",
                    title = "About us",
                    onClick = {}
                ),
                NavDropdown(
                    placeholder = "Language",
                    items = listOf(
                        NavDropdownItem(
                            id = "kotlinLanguage",
                            title = "Kotlin",
                            onClick = {
                                println("Index: $it Title: Kotlin")
                            }
                        ),
                        NavDropdownItem(
                            id = "javaLanguage",
                            title = "Java",
                            onClick = {}
                        )
                    )
                )
            ),
            inputField = NavBarInputField(
                placeholder = "Search",
                value = "",
                onValueChange = {}
            ),
            button = NavBarButton(
                text = "Search",
                onClick = {}
            )
        )
    }
}