package ru.kram.easywords.dependencies

import Dependencies
import org.gradle.api.Plugin
import org.gradle.api.Project

class JetpackComposeDependenciesPlugin : Plugin<Project> {

    override fun apply(project: Project): Unit = with(Dependencies){
        project.dependencies.apply {
            add(DependencyTypes.implementation, "androidx.activity:activity-compose:$activityCompose")
            add(DependencyTypes.implementation,  "androidx.compose.ui:ui:$compose")
            add(DependencyTypes.implementation, "androidx.compose.ui:ui-tooling-preview:$compose")
            add(DependencyTypes.implementation, "androidx.compose.material3:material3:$materialCompose")
            add(DependencyTypes.implementation, "androidx.compose.runtime:runtime-livedata:$compose")
            add(DependencyTypes.implementation, "androidx.constraintlayout:constraintlayout-compose:$constraintLayoutCompose")
            add(DependencyTypes.implementation,"androidx.lifecycle:lifecycle-viewmodel-compose:$viewModel")
            add(DependencyTypes.implementation, "androidx.navigation:navigation-compose:$navigationCompose")

            add(DependencyTypes.debugImplementation, "androidx.compose.ui:ui-tooling:$compose")
            add(DependencyTypes.androidTestmplementation, "androidx.compose.ui:ui-test-junit4:$compose")
            add(DependencyTypes.debugImplementation, "androidx.compose.ui:ui-tooling:$compose")
            add(DependencyTypes.debugImplementation, "androidx.compose.ui:ui-test-manifest:$compose")
        }
    }
}