package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.stevdza.san.kotlinbs.models.CarouselItem
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.dom.*
import kotlin.js.Date

/**
 * An interactive UI element that allows you to showcase a collection of images
 * in a sliding or fading manner. It is commonly used to create visually appealing and
 * dynamic slideshows or image galleries on web pages.
 *
 * The carousel component in Bootstrap provides a responsive and customizable carousel
 * container that can hold multiple slides. Each slide typically consists of an image
 * along with optional captions or additional content. The carousel automatically
 * transitions between slides, creating a smooth and visually engaging experience
 * for the user.
 *
 * @param items Single or multiple [CarouselItem]'s that will be shown into the carousel.
 * Each item contains a mandatory image parameter, and optional title and body.
 * @param width Width of the container.
 * @param height Height of the container.
 * @param showControls Whether to display controls or not.
 * @param showIndicators Whether to display indicators or not.
 * @param crossFade Whether to replace a sliding transition animation with a cross-fade.
 * @param dark If the value is true, controls and indicators will have dark colors.
 * Otherwise, their color will be white.
 * @param objectFit How an image should be resized and positioned within its container.
 * */
@Composable
fun BSCarousel(
    modifier: Modifier = Modifier,
    items: List<CarouselItem>,
    width: CSSNumeric,
    height: CSSNumeric,
    showControls: Boolean = true,
    showIndicators: Boolean = true,
    crossFade: Boolean = false,
    dark: Boolean = false,
    objectFit: ObjectFit = ObjectFit.Fill,
) {
    val carouselId by remember { mutableStateOf(Date.now().toInt()) }
    Div(attrs = modifier
        .id("carousel$carouselId")
        .classNames("carousel", "slide")
        .width(width)
        .height(height)
        .thenIf(
            condition = crossFade,
            other = Modifier.classNames("carousel-fade")
        )
        .thenIf(
            condition = dark,
            other = Modifier.classNames("carousel-dark")
        )
        .toAttrs {
            attr("data-bs-ride", "carousel")
        }
    ) {
        if (showIndicators) {
            Div(
                attrs = Modifier
                    .classNames("carousel-indicators")
                    .toAttrs()
            ) {
                items.forEachIndexed { index, image ->
                    Button(attrs = Modifier
                        .thenIf(
                            condition = image == items.first(),
                            other = Modifier.classNames("active")
                        )
                        .thenIf(
                            condition = image == items.first(),
                            other = Modifier.attrsModifier {
                                attr("aria-current", "true")
                            }
                        )
                        .toAttrs {
                            attr("data-bs-target", "#carouselExampleIndicators")
                            attr("data-bs-slide-to", "$index")
                            attr("data-bs-slide-to", "$index")
                            attr("aria-label", "Slide $index")
                        }
                    )
                }
            }
        }
        Div(
            attrs = Modifier
                .fillMaxSize()
                .classNames("carousel-inner")
                .toAttrs()
        ) {
            items.forEach {
                Div(
                    attrs = Modifier
                        .fillMaxSize()
                        .classNames("carousel-item")
                        .thenIf(
                            condition = it == items.first(),
                            other = Modifier.classNames("active")
                        )
                        .toAttrs()
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .objectFit(objectFit)
                            .classNames("d-block", "w-100"),
                        src = it.image,
                        desc = "Carousel Image"
                    )
                    if (it.title != null || it.body != null) {
                        Div(
                            attrs = Modifier
                                .classNames(
                                    "carousel-caption",
                                    "d-md-block",
                                    "d-none"
                                )
                                .toAttrs()
                        ) {
                            H5 {
                                it.title?.let { title -> Text(value = title) }
                            }
                            P {
                                it.body?.let { body -> Text(value = body) }
                            }
                        }
                    }
                }
            }
            if (showControls) {
                Button(
                    attrs = Modifier
                        .classNames("carousel-control-prev")
                        .toAttrs {
                            attr("type", "button")
                            attr("data-bs-target", "#carousel$carouselId")
                            attr("data-bs-slide", "prev")
                        }
                ) {
                    Span(
                        attrs = Modifier
                            .classNames("carousel-control-prev-icon")
                            .toAttrs {
                                attr("aria-hidden", "true")
                            }
                    )
                    Span(
                        attrs = Modifier
                            .classNames("visually-hidden")
                            .toAttrs()
                    ) {
                        Text(value = "Previous")
                    }
                }
                Button(
                    attrs = Modifier
                        .classNames("carousel-control-next")
                        .toAttrs {
                            attr("type", "button")
                            attr("data-bs-target", "#carousel$carouselId")
                            attr("data-bs-slide", "next")
                        }
                ) {
                    Span(
                        attrs = Modifier
                            .classNames("carousel-control-next-icon")
                            .toAttrs {
                                attr("aria-hidden", "true")
                            }
                    )
                    Span(
                        attrs = Modifier
                            .classNames("visually-hidden")
                            .toAttrs()
                    ) {
                        Text(value = "Next")
                    }
                }
            }
        }
    }
}