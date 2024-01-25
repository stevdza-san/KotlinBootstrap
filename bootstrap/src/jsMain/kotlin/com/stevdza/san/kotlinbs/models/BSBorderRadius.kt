package com.stevdza.san.kotlinbs.models

import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import org.jetbrains.compose.web.css.px

data class BSBorderRadius(
    val topLeft: CSSLengthOrPercentageNumericValue = 0.px,
    val topRight: CSSLengthOrPercentageNumericValue = 0.px,
    val bottomRight: CSSLengthOrPercentageNumericValue = 0.px,
    val bottomLeft: CSSLengthOrPercentageNumericValue = 0.px
) {
    constructor(all: CSSLengthOrPercentageNumericValue = 0.px) : this(
        topLeft = all,
        topRight = all,
        bottomRight = all,
        bottomLeft = all
    )

    val value = "$topLeft $topRight $bottomRight $bottomLeft"
}
