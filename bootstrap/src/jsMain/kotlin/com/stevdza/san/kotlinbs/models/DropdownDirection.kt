package com.stevdza.san.kotlinbs.models

enum class DropdownDirection(val value: String? = null) {
    Bottom,
    Top(value = "dropup"),
    Left(value = "dropstart"),
    Right(value = "dropend")
}