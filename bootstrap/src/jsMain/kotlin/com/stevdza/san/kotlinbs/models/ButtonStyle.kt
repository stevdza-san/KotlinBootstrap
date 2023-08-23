package com.stevdza.san.kotlinbs.models

enum class ButtonStyle(val classes: List<String>) {
    Primary(classes = listOf("btn", "btn-primary")),
    PrimaryOutline(classes = listOf("btn", "btn-outline-primary")),
    Secondary(classes = listOf("btn", "btn-secondary")),
    SecondaryOutline(classes = listOf("btn", "btn-outline-secondary")),
    Success(classes = listOf("btn", "btn-success")),
    SuccessOutline(classes = listOf("btn", "btn-outline-success")),
    Danger(classes = listOf("btn", "btn-danger")),
    DangerOutline(classes = listOf("btn", "btn-outline-danger")),
    Warning(classes = listOf("btn", "btn-warning")),
    WarningOutline(classes = listOf("btn", "btn-outline-warning")),
    Info(classes = listOf("btn", "btn-info")),
    InfoOutline(classes = listOf("btn", "btn-outline-info")),
    Light(classes = listOf("btn", "btn-light")),
    LightOutline(classes = listOf("btn", "btn-outline-light")),
    Dark(classes = listOf("btn", "btn-dark")),
    DarkOutline(classes = listOf("btn", "btn-outline-dark")),
    Link(classes = listOf("btn", "btn-link")),
    LinkOutline(classes = listOf("btn", "btn-outline-link")),
}