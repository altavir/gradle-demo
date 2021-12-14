plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
}

dependencies {
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/junit/junit
    testImplementation("junit:junit:4.13.2")
}


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
