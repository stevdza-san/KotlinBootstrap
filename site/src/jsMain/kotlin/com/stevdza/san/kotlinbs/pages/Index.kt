package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSButton
import com.stevdza.san.kotlinbs.components.BSOffcanvas
import com.stevdza.san.kotlinbs.components.showOffcanvasOnClick
import com.stevdza.san.kotlinbs.models.offcanvas.OffcanvasPlacement
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A

@Page
@Composable
fun HomePage() {
    val links = listOf("Home", "Pricing", "Services", "Contact us")
    BSOffcanvas(
        id = "myOffCanvas",
        title = "Welcome!",
        body = {
            Column {
                links.forEach { name ->
                    A(
                        attrs = Modifier
                            .margin(bottom = 16.px)
                            .textDecorationLine(TextDecorationLine.None)
                            .cursor(Cursor.Pointer)
                            .toAttrs()
                    ) {
                        SpanText(name)
                    }
                }
                BSButton(
                    text = "Sign in",
                    onClick = {}
                )
            }
        },
        placement = OffcanvasPlacement.END
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BSButton(
            modifier = Modifier.showOffcanvasOnClick(id = "myOffCanvas"),
            text = "Show",
            onClick = {}
        )
    }
}