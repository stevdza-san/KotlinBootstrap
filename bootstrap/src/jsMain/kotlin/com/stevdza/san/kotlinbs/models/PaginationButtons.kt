package com.stevdza.san.kotlinbs.models

data class PreviousButton(
    val text: String = "Previous",
    val disabled: Boolean = false,
    val onClick: (Int) -> Unit
)

data class NextButton(
    val text: String = "Next",
    val disabled: Boolean = false,
    val onClick: (Int) -> Unit
)