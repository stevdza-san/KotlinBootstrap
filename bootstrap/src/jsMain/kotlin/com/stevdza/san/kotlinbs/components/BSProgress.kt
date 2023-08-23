package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.models.BackgroundStyle
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

/**
 * A visual element used to display the progress or completion of a task or process.
 * It provides a horizontal bar that visually represents the current status or percentage
 * of completion for a particular operation.
 * @param label Progress label.
 * @param percentage Progress completion in percentage. From 0% to 100%.
 * @param height Progress height.
 * @param style Background style of progress.
 * @param striped Whether to use a stripped style.
 * @param stripedAnimated Whether to animate a striped style.
 * */
@Composable
fun BSProgress(
    modifier: Modifier = Modifier.fillMaxWidth(),
    label: String? = null,
    percentage: CSSSizeValue<CSSUnit.percent> = 50.percent,
    height: CSSNumeric = 20.px,
    style: BackgroundStyle = BackgroundStyle.Primary,
    striped: Boolean = false,
    stripedAnimated: Boolean = false
) {
    Div(
        attrs = modifier
            .height(height)
            .classNames("progress")
            .toAttrs()
    ) {
        Div(
            attrs = Modifier
                .classNames("progress-bar", style.value)
                .thenIf(
                    condition = striped,
                    other = Modifier.classNames("progress-bar-striped")
                )
                .thenIf(
                    condition = stripedAnimated,
                    other = Modifier.classNames("progress-bar-striped", "progress-bar-animated")
                )
                .width(percentage)
                .toAttrs {
                    attr("role", "progressbar")
                    attr("aria-label", "Progress Bar")
                    attr("aria-valuenow", "${percentage.value}")
                    attr("aria-valuemin", "0")
                    attr("aria-valuemax", "100")
                }
        ) {
            label?.let { Text(value = it) }
        }
    }
}