package com.stevdza.san.kotlinbs.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

// This is a loose fork of SpanText from Kobweb's Silk widget set. However, we don't want to depend on Silk, so
// we just duplicate the subset of it we care about ourselves.

@Composable
internal fun SpanText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Span(modifier.toAttrs()) {
        Text(text)
    }
}
