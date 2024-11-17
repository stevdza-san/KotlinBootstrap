package com.stevdza.san.kotlinbs.models.container

import com.stevdza.san.kotlinbs.models.Breakpoint

sealed class ContainerBehavior(val className: String) {
    data object Default : ContainerBehavior("container")
    data object Fluid : ContainerBehavior("container-fluid")
    data class Responsive(val breakpoint: Breakpoint) : ContainerBehavior("container-${breakpoint.value}")
}