pluginManagement {
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

rootProject.name = "Reto Tecnico Bancom"
include(":app")
include(":onboarding")
include(":onboarding:presentation")
include(":onboarding:domain")
include(":home")
include(":home:presentation")
include(":home:domain")
include(":onboarding:data")
include(":home:data")
include(":core")
include(":core-ui")
