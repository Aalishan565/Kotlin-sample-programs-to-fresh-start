package _0_kotlin_basics

/**
 * 13Runner.kt
 * Demonstrates instantiating objects and executing methods across package-level Kotlin files.
 */
fun main() {
    println("--- 1. Instantiating Animal using Primary Constructor ---")
    val dog = Animal("Dog")
    dog.showName()

    println("\n--- 2. Instantiating Animal using Secondary Constructor ---")
    val dog1 = Animal(5, "Puppy")
    dog1.showName()
}
