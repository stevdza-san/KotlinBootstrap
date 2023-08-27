package com.stevdza.san.kotlinbs.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSAccordion
import com.stevdza.san.kotlinbs.models.AccordionItem
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BSAccordion(
            modifier = Modifier.width(500.px),
            items = listOf(
                AccordionItem(
                    title = "Step 01: Identify your goals",
                    content = {
                        SpanText(text = "In this initial step, you need to clearly define and understand what you want to achieve. This can be in various aspects of your life, such as personal, professional, or academic.\n" +
                                "It involves self-reflection and introspection to determine your priorities and aspirations.\n" +
                                "Identifying your goals sets the direction for your actions and decisions.")
                    },
                    defaultOpened = true
                ),
                AccordionItem(
                    title = "Step 02: Write your goals",
                    content = {
                        SpanText(text = "Once you've identified your goals, the next step is to put them in writing. This makes them concrete and easier to track.\n" +
                                "Writing down your goals helps you commit to them and provides a reference point for future planning.\n" +
                                "Goals should be specific, measurable, achievable, relevant, and time-bound (SMART) for greater effectiveness.")
                    }
                ),
                AccordionItem(
                    title = "Step 03: Analysis",
                    content = {
                        SpanText(text = "After setting your goals, it's important to assess your current situation or starting point. This involves analyzing your strengths, weaknesses, opportunities, and threats (SWOT analysis).\n" +
                                "You may also need to evaluate the resources and constraints that could impact your ability to achieve your goals.\n" +
                                "Analysis helps you develop a clear understanding of the challenges and opportunities ahead.")
                    }
                ),
                AccordionItem(
                    title = "Step 04: Objectives",
                    content = {
                        SpanText(text = "Objectives are specific, actionable steps you need to take to move closer to your goals.\n" +
                                "These are the practical tasks or milestones that help you make progress.\n" +
                                "Objectives should be aligned with your goals and should have clear deadlines and metrics for measurement")
                    }
                )
            )
        )
    }
}