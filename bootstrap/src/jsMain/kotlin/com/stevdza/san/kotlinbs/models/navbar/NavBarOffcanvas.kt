package com.stevdza.san.kotlinbs.models.navbar

import com.stevdza.san.kotlinbs.models.offcanvas.OffcanvasPlacement

data class NavBarOffcanvas(
    val id: String,
    val title: String,
    val dark: Boolean = false,
    val allowScrolling: Boolean = false,
    val disableBackdrop: Boolean = false,
    val closableOutside: Boolean = true,
    val placement: OffcanvasPlacement = OffcanvasPlacement.END
)
