/*
 * This file was generated by the Gradle 'init' task.
 */

// plugins {
//     // Support convention plugins written in Kotlin. Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
//     `kotlin-dsl`
// }

// repositories {
//     // Use the plugin portal to apply community plugins in convention plugins.
//     gradlePluginPortal()

// }


/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    // Support convention plugins written in Kotlin. Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    `kotlin-dsl`
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()

}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "21"
    }
}
