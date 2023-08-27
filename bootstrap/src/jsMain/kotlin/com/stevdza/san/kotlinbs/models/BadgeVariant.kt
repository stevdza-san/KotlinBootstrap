package com.stevdza.san.kotlinbs.models

enum class BadgeVariant(val classes: List<String>? = null) {
    Regular,
    Straight,
    Rounded(listOf("rounded-pill")),
    Empty(listOf("border", "border-light", "rounded-circle", "p-2"))
}