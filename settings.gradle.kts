pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "simpleNews"
include(":app")
include(":core")
include(":features")
include(":core:common")
include(":core:data")
include(":core:model")
include(":core:domain")
include(":core:network")
include(":core:testing")
include(":core:designsystem")
include(":features:overview")
