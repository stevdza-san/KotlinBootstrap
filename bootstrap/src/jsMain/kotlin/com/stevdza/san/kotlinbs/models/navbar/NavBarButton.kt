package com.stevdza.san.kotlinbs.models.navbar

import com.stevdza.san.kotlinbs.models.ButtonBadge
import com.stevdza.san.kotlinbs.models.ButtonVariant

data class NavBarButton(
    val id: String? = null,
    val text: String,
    val variant: ButtonVariant = ButtonVariant.Primary,
    val disabled: Boolean = false,
    val loading: Boolean = false,
    val loadingText: String? = null,
    val badge: ButtonBadge? = null,
    val onClick: () -> Unit
)
