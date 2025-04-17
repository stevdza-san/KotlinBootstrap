package com.stevdza.san.kotlinbs

import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.layer.SilkLayer
import com.varabyte.kobweb.silk.style.layer.add

@InitSilk
fun initBuildScriptLayers(ctx: InitSilkContext) {
    // Layer(s) referenced in build.gradle.kts
    ctx.stylesheet.cssLayers.add(
        "kotlin-bootstrap",
        after = SilkLayer.BASE
    )
}