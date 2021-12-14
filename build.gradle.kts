description = "This is the root gradle project"

allprojects{
    version = "1.0.0"
    repositories{
        mavenCentral()
        maven("https://repo.kotlin.link")
    }
}