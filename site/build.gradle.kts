import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kotlin.compose)
}

group = "com.stevdza.san.kotlinbs"
version = "1.0.0"

kobweb {
    app {
        index {
            description.set("Powered by Kobweb")
        }
    }
}

kotlin {
    configAsKobwebApplication("kotlinbs")

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
        }

        jsMain.dependencies {
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk.core)
            implementation(libs.kobweb.silk.icons.fa)
            implementation(project(":bootstrap"))
        }
    }
}