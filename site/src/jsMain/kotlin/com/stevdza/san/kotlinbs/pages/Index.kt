package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSButton
import com.stevdza.san.kotlinbs.components.BSCollapse
import com.stevdza.san.kotlinbs.components.showCollapse
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.width(400.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BSButton(
                modifier = Modifier
                    .alignContent(AlignContent.Center)
                    .showCollapse(id = "collapse1"),
                text = "FAQ",
                onClick = {}
            )
            BSCollapse(id = "collapse1") {
                Column(modifier = Modifier.margin(top = 14.px)) {
                    SpanText(
                        modifier = Modifier
                            .fontSize(18.px)
                            .fontWeight(FontWeight.Bold),
                        text = "1. How long does the course take to complete?"
                    )
                    SpanText(
                        text = "The course is self-paced, so you can complete it at your own speed. On average, most students finish the course in about 3-6 weeks, depending on the time they can dedicate to learning."
                    )
                }
            }
        }
    }
}