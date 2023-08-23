package com.stevdza.san.kotlinbs.models

data class NavLink(
    val id: String,
    val title: String,
    val href: String,
    val active: Boolean = false,
    val disabled: Boolean = false
): NavItem