package gradle.demo

val gradleDemoVersion: String get() = object {}.javaClass.getResourceAsStream("/version").readAllBytes().decodeToString()