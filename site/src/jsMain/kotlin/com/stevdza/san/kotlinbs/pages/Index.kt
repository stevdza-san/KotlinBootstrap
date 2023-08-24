package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.stevdza.san.kotlinbs.components.*
import com.stevdza.san.kotlinbs.models.BackgroundStyle
import com.stevdza.san.kotlinbs.models.ButtonVariant
import com.stevdza.san.kotlinbs.models.ToastStyle
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BSButton(
            modifier = Modifier.margin(bottom = 14.px),
            text = "Toast",
            onClick = {
                scope.launch {
                    showToast(toastId = "toast1")
                }
            }
        )
        BSButton(
            modifier = Modifier.margin(bottom = 14.px),
            text = "Toast 2",
            onClick = {
                scope.launch {
                    showToast(toastId = "toast2")
                }
            }
        )
        BSButton(
            modifier = Modifier.margin(bottom = 14.px),
            text = "Toast Basic",
            onClick = {
                scope.launch {
                    showToast(toastId = "toastBasic1")
                }
            }
        )
        BSButton(
            modifier = Modifier.margin(bottom = 14.px),
            text = "Toast Basic 2",
            onClick = {
                scope.launch {
                    showToast(toastId = "toastBasic2")
                }
            }
        )
        BSButton(
            modifier = Modifier.margin(bottom = 14.px),
            text = "Toast Action",
            onClick = {
                scope.launch {
                    showToast(toastId = "toastAction1")
                }
            }
        )
        BSButton(
            modifier = Modifier.margin(bottom = 14.px),
            text = "Toast Action 2",
            onClick = {
                scope.launch {
                    showToast(toastId = "toastAction2")
                }
            }
        )
    }

    BSToastGroup {
        BSToast(
            id = "toast1",
            title = "Welcome",
            body = "Browse our website for more interesting products!",
            onCloseClick = {}
        )
        BSToast(
            id = "toast2",
            title = "Success!",
            body = "Thank you for purchasing a book!",
            autoHide = false,
            indicatorStyle = BackgroundStyle.Success,
            onCloseClick = {}
        )
        BSToastBasic(
            id = "toastBasic1",
            text = "Our website uses cookies.",
            closeButtonDark = false,
            onCloseClick = {}
        )
        BSToastBasic(
            id = "toastBasic2",
            text = "Thank you for your feedback!",
            style = ToastStyle.Dark,
            autoHide = false,
            closeButtonDark = false,
            onCloseClick = {}
        )
        BSToastAction(
            id = "toastAction1",
            text = "Are you sure you want to delete 24 items?",
            positiveButtonText = "Yes",
            negativeButtonText = "Cancel",
            onPositiveButtonClick = {},
            onNegativeButtonClick = {}
        )
        BSToastAction(
            id = "toastAction2",
            text = "Are you sure you want to delete 24 items?",
            positiveButtonText = "Yes",
            positiveButtonVariant = ButtonVariant.Primary,
            negativeButtonVariant = ButtonVariant.Danger,
            negativeButtonText = "Cancel",
            style = ToastStyle.Dark,
            onPositiveButtonClick = {},
            onNegativeButtonClick = {}
        )
    }
}