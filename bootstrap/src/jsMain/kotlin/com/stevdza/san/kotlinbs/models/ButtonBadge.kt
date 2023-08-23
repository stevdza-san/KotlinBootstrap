package com.stevdza.san.kotlinbs.models

import com.varabyte.kobweb.compose.ui.Modifier

data class ButtonBadge(
    val modifier: Modifier = Modifier,
    val text: String,
    val style: BackgroundStyle = BackgroundStyle.Danger,
    val variant: BadgeVariant = BadgeVariant.Rounded
)
