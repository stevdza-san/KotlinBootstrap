package com.stevdza.san.kotlinbs.models.button

import com.stevdza.san.kotlinbs.models.BSBorderRadius
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.functions.Gradient
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

data class ButtonCustomization(
    val color: CSSColorValue? = null,
    val backgroundColor: CSSColorValue? = null,
    val borderColor: CSSColorValue? = null,
    val hoverColor: CSSColorValue? = null,
    val hoverBackgroundColor: CSSColorValue? = null,
    val hoverBorderColor: CSSColorValue? = null,
    val activeColor: CSSColorValue? = null,
    val activeBackgroundColor: CSSColorValue? = null,
    val activeBorderColor: CSSColorValue? = null,
    val disabledColor: CSSColorValue? = null,
    val disabledBackgroundColor: CSSColorValue? = null,
    val disabledBorderColor: CSSColorValue? = null,

    val borderRadius: BSBorderRadius = BSBorderRadius(all = 0.px),
    val horizontalPadding: CSSNumeric = 0.75.cssRem,
    val verticalPadding: CSSNumeric = 0.375.cssRem,

    val fontFamily: String? = null,
    val fontSize: CSSNumeric = 1.cssRem,
    val fontWeight: FontWeight = FontWeight.Normal,
    val lineHeight: CSSNumeric = 1.5.cssRem,

    val gradient: Gradient? = null
)
