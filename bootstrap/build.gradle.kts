import com.varabyte.kobweb.gradle.core.util.importCss
import com.varabyte.kobweb.gradle.library.util.configAsKobwebLibrary
import kotlinx.html.script
import kotlinx.html.style

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kobweb.library)
    alias(libs.plugins.kotlin.compose)
    `maven-publish`
}

group = "com.stevdza.san.bootstrap"
version = "0.1.6"

kotlin {
    configAsKobwebLibrary(includeServer = false)

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
        }

        jsMain.dependencies {
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.compose)
            implementation(libs.kobweb.silk.core)
            implementation(npm("bootstrap", "5.3.5"))
        }
    }
}

kobweb {
    library {
        index {
            head.add {
                script {
                    src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
                }
                style {
                    importCss(
                        url = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css",
                        layerName = "kotlin-bootstrap"
                    )
                }
                style {
                    importCss(
                        url = "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css",
                        layerName = "kotlin-bootstrap"
                    )
                }
            }
        }
    }
}

publishing {
    publications {
        register("mavenJsLibrary", MavenPublication::class) {
            from(components["kotlin"])
            groupId = "com.github.stevdza-san"
            artifactId = "KotlinBootstrap"
            version = version
        }
    }
}
