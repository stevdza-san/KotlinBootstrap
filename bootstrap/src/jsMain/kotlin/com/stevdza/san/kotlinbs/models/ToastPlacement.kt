package com.stevdza.san.kotlinbs.models

enum class ToastPlacement(val classes: List<String>) {
    TopLeft(classes = listOf("top-0", "start-0")),
    TopCenter(classes = listOf("top-0", "start-50")),
    TopRight(classes = listOf("top-0", "end-0")),
    CenterLeft(classes = listOf("top-50", "start-0", "translate-middle-y")),
    Center(classes = listOf("top-50", "start-50", "translate-middle")),
    CenterRight(classes = listOf("top-50", "end-0", "translate-middle-y")),
    BottomLeft(classes = listOf("bottom-0", "start-0")),
    BottomCenter(classes = listOf("bottom-0", "start-50", "translate-middle-x")),
    BottomRight(classes = listOf("bottom-0", "end-0"))
}