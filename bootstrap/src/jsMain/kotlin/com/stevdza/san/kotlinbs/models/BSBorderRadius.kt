package com.stevdza.san.kotlinbs.models

import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.px

data class BSBorderRadius(
    val topLeft: CSSNumeric = 0.px,
    val topRight: CSSNumeric = 0.px,
    val bottomRight: CSSNumeric = 0.px,
    val bottomLeft: CSSNumeric = 0.px
) {
    constructor(all: CSSNumeric = 0.px) : this(
        topLeft = all,
        topRight = all,
        bottomRight = all,
        bottomLeft = all
    )

    val value = "$topLeft $topRight $bottomRight $bottomLeft"
}
