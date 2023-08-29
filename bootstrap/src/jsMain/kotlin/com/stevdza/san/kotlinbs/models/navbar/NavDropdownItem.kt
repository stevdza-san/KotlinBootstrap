package com.stevdza.san.kotlinbs.models.navbar

data class NavDropdown(
    val placeholder: String,
    val items: List<NavDropdownItem>
): NavItem

data class NavDropdownItem(
    val id: String,
    val title: String,
    val onClick: (Int) -> Unit
)
