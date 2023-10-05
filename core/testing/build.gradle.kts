plugins {
    id("simplenews.android.library")
    id("simplenews.android.library.compose")
    id("simplenews.android.hilt")
}

android {
    namespace = "nl.jaysh.simplenews.core.testing"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    api(libs.bundles.testing)

    debugApi(libs.androidx.compose.ui.testManifest)
}