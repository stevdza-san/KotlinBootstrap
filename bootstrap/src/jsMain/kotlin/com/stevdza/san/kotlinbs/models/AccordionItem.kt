package com.stevdza.san.kotlinbs.models

import androidx.compose.runtime.Composable

data class AccordionItem(
    val title: String,
    val content: @Composable () -> Unit,
    val defaultOpened: Boolean = false
)