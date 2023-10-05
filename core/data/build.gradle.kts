plugins {
    id("simplenews.android.library")
    id("simplenews.android.hilt")
}

android {
    namespace = "nl.jaysh.simplenews.core.data"

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:domain"))
    implementation(project(":core:model"))

    implementation(project(":core:network"))

    testImplementation(project(":core:testing"))

    implementation(libs.androidx.ktx)

    val arrowBom = platform(libs.arrow.bom)
    implementation(arrowBom)
    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)

    implementation(libs.logcat)
}