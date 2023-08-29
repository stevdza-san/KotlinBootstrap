package com.stevdza.san.kotlinbs.models.navbar

data class NavBarInputField(
    val id: String? = null,
    val placeholder: String,
    val value: String,
    val onValueChange: (String) -> Unit,
    val onEnterClick: (() -> Unit)? = null,
)