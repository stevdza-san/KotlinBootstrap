package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.*
import com.stevdza.san.kotlinbs.components.BSPagination
import com.stevdza.san.kotlinbs.models.NextButton
import com.stevdza.san.kotlinbs.models.PreviousButton
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    var currentPage by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BSPagination(
            pages = 15,
            maxVisiblePages = 3,
            currentPage = currentPage,
            previousButton = PreviousButton(
                onClick = { currentPage = it }
            ),
            nextButton = NextButton(
                onClick = { currentPage = it }
            ),
            onPageClick = { currentPage = it }
        )
    }
}