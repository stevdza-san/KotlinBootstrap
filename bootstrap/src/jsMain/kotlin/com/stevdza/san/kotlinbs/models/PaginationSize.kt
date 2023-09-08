package com.stevdza.san.kotlinbs.models

enum class PaginationSize(val classes: List<String>) {
    Default(classes = listOf("pagination")),
    Small(classes = listOf("pagination", "pagination-sm")),
    Large(classes = listOf("pagination", "pagination-lg"))
}