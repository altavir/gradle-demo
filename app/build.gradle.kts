plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
    application
}

fun DependencyHandlerScope.miptNpmLib(lib: String, version: String) = "space.kscience:$lib:$version"

dependencies {
    implementation(project(":lib"))
    implementation(miptNpmLib("kmath-core", "0.2.0"))
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/junit/junit
    testImplementation("junit:junit:4.13.2")
}

kotlin.sourceSets.main{
    kotlin.srcDir(file("src/main/gen"))
}

application.mainClass.set("HelloKt")

val myTask by tasks.creating{
    doLast {
        project.configurations.forEach {
            println(it)
        }
    }
}

val build by tasks.getting {
    dependsOn(myTask)
}