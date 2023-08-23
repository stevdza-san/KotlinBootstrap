package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.TooltipDirection
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Div

/**
 * Small pop-up box that provides additional information or context when the user hovers
 * over or interacts with an element. Tooltips are commonly used to provide explanations,
 * labels, or short descriptions for elements such as buttons, links, or icons.
 * [initializeTooltips] function must be called if you want to be able to see those
 * same tooltips that you're using.
 * @param text Text which will appear inside the tooltip.
 * @param direction Direction in which a tooltip will appear.
 * @param content Component on top of which you want to add a tooltip.
 * */
@Composable
fun BSTooltip(
    text: String,
    direction: TooltipDirection = TooltipDirection.Top,
    content: @Composable () -> Unit
) {
    Div(
        attrs = Modifier
            .toAttrs {
                attr("data-bs-toggle", "tooltip")
                attr("data-bs-placement", direction.value)
                attr("data-bs-title", text)
            }
    ) {
        content()
    }
}

/**
 * An initialization function which is used with tooltips. If you don't call this function,
 * your tooltips will not show.
 * */
fun initializeTooltips() {
    try {
        val jsCode = """
         var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
         var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
             return new bootstrap.Tooltip(tooltipTriggerEl)
         })
    """.trimIndent()
        js("eval(jsCode)") as Unit
    } catch (e: Exception) {
        println("initializeTooltips: ${e.message}")
    }
}