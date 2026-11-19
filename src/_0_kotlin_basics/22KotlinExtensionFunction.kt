package _0_kotlin_basics

/**
 * 22KotlinExtensionFunction.kt
 * Demonstrates Extension Functions in Kotlin.
 *
 * Key Concepts:
 * 1. Extension Function: Allows extending a class with new functionality without inheriting or modifying the original class.
 * 2. Receiver Type: The class being extended (e.g. `Animal` or `String`).
 * 3. `this` keyword inside extension function refers to the receiver instance.
 */
fun main() {
    println("--- Kotlin Extension Functions ---")

    val dog = Animal("Dog")
    println("Calling member method:")
    dog.showName()

    println("\nCalling extension method on Animal class:")
    dog.canWalk()

    println("\nCalling extension method on String class:")
    val greeting = "hello kotlin"
    println("Formatted title case: '${greeting.toTitleCase()}'")
}

// Extension function on custom Animal class
fun Animal.canWalk() {
    println("Animal '${this.name}' can walk!")
}

// Extension function on built-in String class
fun String.toTitleCase(): String {
    return this.split(" ").joinToString(" ") { it.replaceFirstChar { char -> char.uppercase() } }
}
