plugins {
    id("simplenews.android.feature")
    id("simplenews.android.library.compose")
}

android {
    namespace = "nl.jaysh.simplenews.feature.overview"
}

dependencies {
    implementation(libs.logcat)
}
