plugins {
    id("simplenews.android.library")
    id("simplenews.android.hilt")
}

android {
    namespace = "nl.jaysh.simplenews.core.common"
}

dependencies {
    testImplementation(project(":core:testing"))
}