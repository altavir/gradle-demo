fun main() {
    val version = object{}.javaClass.getResourceAsStream("version").readAllBytes().decodeToString()

    println("Hello MIPT! Version $version")
}