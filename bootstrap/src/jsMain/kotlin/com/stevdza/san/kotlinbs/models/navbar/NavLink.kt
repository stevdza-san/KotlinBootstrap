package com.stevdza.san.kotlinbs.models.navbar

data class NavLink(
    val id: String,
    val title: String,
    val active: Boolean = false,
    val disabled: Boolean = false,
    val onClick: (Int) -> Unit
): NavItem