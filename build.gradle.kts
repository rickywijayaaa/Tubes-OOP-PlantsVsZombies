/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("buildlogic.java-application-conventions")
}

dependencies {
    // implementation("org.apache.commons:commons-text")
    // implementation(project(":utilities"))
}

application {
    // Define the main class for the application.
    mainClass = "App"
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}


