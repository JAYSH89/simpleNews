plugins {
    id("simplenews.android.library")
    id("simplenews.android.library.compose")
}

android {
    namespace = "nl.jaysh.simplenews.core.designsystem"
}

dependencies {
    implementation(libs.androidx.ktx)

    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.ui)
    debugApi(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.compose.runtime)

    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material.icons.extended)
}