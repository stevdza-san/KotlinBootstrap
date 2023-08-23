package com.stevdza.san.kotlinbs.models

enum class BadgeVariant(val classes: List<String>) {
    Empty(listOf("border", "border-light", "rounded-circle", "p-2")),
    Regular(listOf()),
    Rounded(listOf("rounded-pill"))
}