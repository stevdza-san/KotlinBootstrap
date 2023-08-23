package com.stevdza.san.kotlinbs.models

enum class AlertStyle(val classes: List<String>) {
    Primary(classes = listOf("alert", "alert-primary")),
    Secondary(classes = listOf("alert", "alert-secondary")),
    Success(classes = listOf("alert", "alert-success")),
    Danger(classes = listOf("alert", "alert-danger")),
    Warning(classes = listOf("alert", "alert-warning")),
    Info(classes = listOf("alert", "alert-info")),
    Light(classes = listOf("alert", "alert-light")),
    Dark(classes = listOf("alert", "alert-dark"))
}