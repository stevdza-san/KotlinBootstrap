package com.stevdza.san.kotlinbs.models

sealed class SpinnerVariant(val classes: List<String> = listOf()) {
    object Default : SpinnerVariant(listOf("spinner-border"))
    object DefaultGrow : SpinnerVariant(listOf("spinner-grow"))

    object Small : SpinnerVariant(listOf("spinner-border", "spinner-border-sm"))
    object SmallGrow : SpinnerVariant(listOf("spinner-grow", "spinner-grow-sm"))

    object Large : SpinnerVariant(listOf("spinner-border", "spinner-border-lg"))
    object LargeGrow : SpinnerVariant(listOf("spinner-grow", "spinner-grow-lg"))
}