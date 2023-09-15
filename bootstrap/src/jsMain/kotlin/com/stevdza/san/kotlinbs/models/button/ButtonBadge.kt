package com.stevdza.san.kotlinbs.models.button

import com.stevdza.san.kotlinbs.models.BackgroundStyle
import com.stevdza.san.kotlinbs.models.BadgeVariant
import com.varabyte.kobweb.compose.ui.Modifier

data class ButtonBadge(
    val modifier: Modifier = Modifier,
    val text: String,
    val style: BackgroundStyle = BackgroundStyle.Danger,
    val variant: BadgeVariant = BadgeVariant.Rounded
)
