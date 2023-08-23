package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import kotlinx.browser.document
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.Element
import org.w3c.dom.svg.SVGElement
import org.w3c.dom.svg.SVGPathElement

private val Svg: ElementBuilder<SVGElement> = object : ElementBuilder<SVGElement> {
    private val el: Element by lazy { document.createElementNS("http://www.w3.org/2000/svg", "svg") }
    override fun create(): SVGElement = el.cloneNode() as SVGElement
}

private val Path: ElementBuilder<SVGPathElement> = object : ElementBuilder<SVGPathElement> {
    private val el: Element by lazy { document.createElementNS("http://www.w3.org/2000/svg", "path") }
    override fun create(): SVGPathElement = el.cloneNode() as SVGPathElement
}

@Composable
internal fun Svg(
    attrs: AttrBuilderContext<SVGElement>? = null,
    content: ContentBuilder<SVGElement>? = null
) {
    TagElement(
        elementBuilder = Svg,
        applyAttrs = attrs,
        content = content
    )
}

@Composable
internal fun Path(
    attrs: AttrBuilderContext<SVGPathElement>? = null,
    content: ContentBuilder<SVGPathElement>? = null
) {
    TagElement(
        elementBuilder = Path,
        applyAttrs = attrs,
        content = content
    )
}