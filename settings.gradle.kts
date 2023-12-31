pluginManagement {
	repositories {
		google()
		mavenCentral()
		gradlePluginPortal()
	}
}
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
	repositories {
		google()
		mavenCentral()
		maven { url  = uri("https://jitpack.io") }
	}
}
rootProject.name = "EasyWords"
include(":app")
include(":translator")
include(":exampler")
include(":carder")

apply(from = "common/common-settings.gradle.kts")
