package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSButton
import com.stevdza.san.kotlinbs.components.BSModal
import com.stevdza.san.kotlinbs.components.showModalOnClick
import com.stevdza.san.kotlinbs.forms.BSInput
import com.stevdza.san.kotlinbs.forms.BSTextArea
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    BSModal(
        id = "contactModal",
        title = "Contact us",
        body = {
            Column {
                BSInput(
                    modifier = Modifier.fillMaxWidth().margin(bottom = 14.px),
                    value = "",
                    label = "Email Address",
                    placeholder = "Type here...",
                    onValueChange = {}
                )
                BSTextArea(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    label = "Message",
                    placeholder = "Type here...",
                    onValueChange = {}
                )
            }
        },
        positiveButtonText = "Send Message",
        negativeButtonText = "Close",
        onPositiveButtonClick = {},
        onNegativeButtonClick = {}
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BSButton(
            modifier = Modifier.showModalOnClick(id = "contactModal"),
            text = "Trigger",
            onClick = {}
        )
    }
}