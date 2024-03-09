package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSCarousel
import com.stevdza.san.kotlinbs.models.CarouselItem
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    Box {
        BSCarousel(
            items = listOf(
                CarouselItem(
                    image = "https://images.pexels.com/photos/2662116/pexels-photo-2662116.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    title = "Moraine Lake"
                ),
                CarouselItem(
                    image = "https://images.pexels.com/photos/147411/italy-mountains-dawn-daybreak-147411.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    title = "Italy"
                ),
                CarouselItem(
                    image = "https://images.pexels.com/photos/1166209/pexels-photo-1166209.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    title = "Lavender"
                ),
            ),
            width = 900.px,
            height = 500.px
        )
    }
}