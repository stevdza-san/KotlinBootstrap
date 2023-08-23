package com.stevdza.san.kotlinbs.models

data class InputValidation(
    val isValid: Boolean = false,
    val isInvalid: Boolean = false,
    val validFeedback: String = "Correct!",
    val invalidFeedback: String = "Wrong!"
)
