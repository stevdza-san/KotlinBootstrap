plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kobweb.application) apply false
    alias(libs.plugins.kobweb.library) apply false
    alias(libs.plugins.kobwebx.markdown) apply false
    alias(libs.plugins.kotlin.compose) apply false
}

subprojects {
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
    }
}
