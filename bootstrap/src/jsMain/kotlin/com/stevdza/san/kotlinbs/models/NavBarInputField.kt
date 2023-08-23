package com.stevdza.san.kotlinbs.models

data class NavBarInputField(
    val placeholder: String,
    val value: String,
    val onValueChange: (String) -> Unit,
    val onEnterClick: (() -> Unit)? = null,
    val button: NavBarButton? = null
)

data class NavBarButton(
    val text: String,
    val variant: ButtonVariant = ButtonVariant.LightOutline,
    val type: ButtonType = ButtonType.Submit,
    val onClick: () -> Unit
)