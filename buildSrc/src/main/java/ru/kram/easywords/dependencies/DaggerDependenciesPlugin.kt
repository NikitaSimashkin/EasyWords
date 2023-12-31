package ru.kram.easywords.dependencies

import Dependencies
import org.gradle.api.Plugin
import org.gradle.api.Project

class DaggerDependenciesPlugin : Plugin<Project> {

    override fun apply(project: Project): Unit = with(Dependencies){
        project.dependencies.apply {
            add(DependencyTypes.implementation, "com.google.dagger:dagger:$dagger")
            add(DependencyTypes.kapt, "com.google.dagger:dagger-compiler:$dagger")
            add(DependencyTypes.kapt, "com.google.dagger:dagger-android-processor:$dagger")
        }
    }
}