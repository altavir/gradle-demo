plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
}

version = "1.0.0"

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    maven("https://repo.kotlin.link")
}

dependencies {
    implementation(npmLib("kmath-core", "0.2.0"))
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/junit/junit
    testImplementation("junit:junit:4.13.2")
}

kotlin.sourceSets.main{
    kotlin.srcDir(file("src/main/gen"))
}

fun org.gradle.kotlin.dsl.DependencyHandlerScope.npmLib(lib: String, version: String) = "space.kscience:$lib:$version"

val createVersionFile by tasks.creating {
    doLast {
        val versionFile = File(buildDir, "version")
        versionFile.writeText(version.toString())
        //versionFile.copyTo(buildDir.resolve("resources/main/version"), overwrite = true)
    }
}

val processResources by tasks.getting {
    dependsOn(createVersionFile)
    doLast {
        copy {
            from(File(buildDir, "version"))
            into(File(buildDir, "resources/main"))
        }
    }
}

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