buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

subprojects {
    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false

    // https://developer.android.com/jetpack/androidx/releases/hilt
    alias(libs.plugins.hilt) apply false

    // https://github.com/google/secrets-gradle-plugin
    alias(libs.plugins.secrets) apply false
    alias(libs.plugins.com.android.library) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
}