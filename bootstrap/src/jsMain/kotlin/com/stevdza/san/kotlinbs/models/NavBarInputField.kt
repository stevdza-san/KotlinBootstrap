package com.stevdza.san.kotlinbs.models

data class NavBarInputField(
    val id: String,
    val placeholder: String,
    val value: String,
    val onValueChange: (String) -> Unit,
    val onEnterClick: (() -> Unit)? = null,
    val button: NavBarButton? = null
)

data class NavBarButton(
    val id: String,
    val text: String,
    val style: ButtonStyle = ButtonStyle.LightOutline,
    val type: ButtonType = ButtonType.Submit,
    val onClick: () -> Unit
)