package com.stevdza.san.kotlinbs.models

import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px

data class NavBarBrand(
    val title: String,
    val image: String? = null,
    val imageSize: CSSSizeValue<CSSUnit.px> = 30.px,
    val href: String = "#"
)
