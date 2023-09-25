package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.*
import com.stevdza.san.kotlinbs.models.NextButton
import com.stevdza.san.kotlinbs.models.PaginationSize
import com.stevdza.san.kotlinbs.models.PreviousButton
import com.stevdza.san.kotlinbs.util.UniqueIdGenerator
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Ul

/**
 * Pagination component is used to divide long lists or tables into multiple pages,
 * making it easier for users to navigate through the content.
 * @param id A unique identifier of the button.
 * @param pages A total number of pages. The minimum number of pages is 2.
 * @param currentPage Currently selected page. This will apply an active state to the page.
 * @param maxVisiblePages How many pages should be visible on the screen.
 * @param size The size of the [BSPagination] component.
 * @param previousButton Preview button when pressed, should decrement the [currentPage] value.
 * @param nextButton Next button when pressed, should increment the [currentPage] value.
 * @param onPageClick Lambda which is triggered when you click on a page. It holds the Int value
 * of the clicked page.
 * */
@Composable
fun BSPagination(
    modifier: Modifier = Modifier,
    id: String? = null,
    pages: Int,
    currentPage: Int = 1,
    maxVisiblePages: Int = 3,
    size: PaginationSize = PaginationSize.Default,
    previousButton: PreviousButton? = null,
    nextButton: NextButton? = null,
    onPageClick: (Int) -> Unit
) {
    val randomId = remember {
        id ?: UniqueIdGenerator.generateUniqueId("pagination")
    }
    val numberOfPages = remember(pages) { if (pages > 1) 1..pages else 1..2 }
    val numberOfMaxVisiblePages = remember(maxVisiblePages) { if (maxVisiblePages < 2) 2 else maxVisiblePages }
    val currentPageInternal = remember(currentPage) {
        if (currentPage <= numberOfPages.last
            && currentPage >= numberOfPages.first
        ) currentPage
        else if (currentPage < 1) 1
        else numberOfPages.last
    }

    var previousButtonDisabled by remember(previousButton?.disabled) { mutableStateOf(previousButton?.disabled) }
    var nextButtonDisabled by remember(nextButton?.disabled) { mutableStateOf(nextButton?.disabled) }

    val currentPageIndex = remember(currentPageInternal) { numberOfPages.indexOf(currentPageInternal) }
    val endIndex = remember(currentPageIndex) { (currentPageIndex + numberOfMaxVisiblePages).coerceAtMost(numberOfPages.count()) }
    val visiblePages = remember(currentPageIndex) {
        numberOfPages.toList().subList(
            if ((endIndex - currentPageIndex) < numberOfMaxVisiblePages)
                currentPageIndex - (numberOfMaxVisiblePages - (endIndex - currentPageIndex))
            else currentPageIndex,
            endIndex
        )
    }

    LaunchedEffect(currentPageInternal) {
        previousButtonDisabled = currentPageInternal <= numberOfPages.first
        nextButtonDisabled = currentPageInternal >= numberOfPages.last
    }

    Nav(
        attrs = modifier
            .id(randomId)
            .toAttrs {
                attr("aria-label", "Pagination")
            }
    ) {
        Ul(
            attrs = Modifier
                .classNames(*size.classes.toTypedArray())
                .toAttrs()
        ) {
            if (previousButton != null) {
                Li(
                    attrs = Modifier
                        .classNames("page-item")
                        .thenIf(
                            condition = previousButtonDisabled == true,
                            other = Modifier.classNames("disabled")
                        )
                        .onClick {
                            if (currentPageInternal > numberOfPages.first) {
                                previousButton.onClick(currentPageInternal - 1)
                            }
                        }
                        .cursor(Cursor.Pointer)
                        .toAttrs()
                ) {
                    A(
                        attrs = Modifier
                            .classNames("page-link")
                            .toAttrs {
                                if (previousButtonDisabled == true) attr("tabindex", "-1")
                            }
                    ) {
                        SpanText(
                            modifier = Modifier.userSelect(UserSelect.None),
                            text = previousButton.text
                        )
                    }
                }
            }
            visiblePages.forEach { page ->
                Li(
                    attrs = Modifier
                        .classNames("page-item")
                        .thenIf(
                            condition = currentPageInternal == page,
                            other = Modifier.classNames("active")
                        )
                        .onClick { onPageClick(page) }
                        .cursor(Cursor.Pointer)
                        .toAttrs()
                ) {
                    A(
                        attrs = Modifier
                            .classNames("page-link")
                            .toAttrs()
                    ) {
                        SpanText(
                            modifier = Modifier.userSelect(UserSelect.None),
                            text = "$page"
                        )
                    }
                }
            }
            if (nextButton != null) {
                Li(
                    attrs = Modifier
                        .classNames("page-item")
                        .thenIf(
                            condition = nextButtonDisabled == true,
                            other = Modifier.classNames("disabled")
                        )
                        .onClick {
                            if (currentPageInternal < numberOfPages.last) {
                                nextButton.onClick(currentPageInternal + 1)
                            }
                        }
                        .cursor(Cursor.Pointer)
                        .toAttrs()
                ) {
                    A(
                        attrs = Modifier
                            .classNames("page-link")
                            .toAttrs {
                                if (nextButtonDisabled == true) attr("tabindex", "-1")
                            }
                    ) {
                        SpanText(
                            modifier = Modifier.userSelect(UserSelect.None),
                            text = nextButton.text
                        )
                    }
                }
            }
        }
    }
}