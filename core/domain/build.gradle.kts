plugins {
    id("simplenews.android.library")
    id("simplenews.android.hilt")
    kotlin("kapt")
}

android {
    namespace = "nl.jaysh.simplenews.core.domain"

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(project(":core:model"))

    val arrowBom = platform(libs.arrow.bom)
    implementation(arrowBom)
    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)

    implementation(libs.logcat)

    testImplementation(project(":core:testing"))
}