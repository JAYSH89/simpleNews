plugins {
    id("simplenews.android.library")
    id("simplenews.android.hilt")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    kotlin("kapt")
}

android {
    buildFeatures {
        buildConfig = true
    }

    namespace = "nl.jaysh.simplenews.core.network"

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    testImplementation(project(":core:testing"))

    implementation(libs.kotlinx.serialization.json)

    val arrowBom = platform(libs.arrow.bom)
    implementation(arrowBom)
    implementation(libs.bundles.arrow)

    implementation(libs.bundles.ktor)
    implementation(libs.logcat)
}