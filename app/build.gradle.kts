plugins {
    id("simplenews.android.application")
    id("simplenews.android.application.compose")
    id("simplenews.android.hilt")
    alias(libs.plugins.ksp)
    kotlin("kapt")
}

android {
    defaultConfig {
        applicationId = "nl.jaysh.simplenews"
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    packaging {
        resources {
            excludes.add("META-INF/*")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }

    namespace = "nl.jaysh.simplenews"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:network"))

    implementation(project(":features:overview"))

    implementation(libs.androidx.ktx)
    implementation(platform(libs.kotlin.bom))
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(libs.bundles.lifecycle)

    implementation(libs.androidx.core.splashscreen)

    implementation(libs.logcat)

    androidTestImplementation(project(":core:testing"))

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.testManifest)
}
