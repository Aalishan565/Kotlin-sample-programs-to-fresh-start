package _0_kotlin_basics

/**
 * 23KotlinInfixFunction.kt
 * Demonstrates Infix Notation Functions in Kotlin.
 *
 * Key Concepts:
 * 1. `infix` keyword: Allows calling member/extension functions without using dot and parentheses (e.g. `dog canSound "bark"`).
 * 2. Requirements for `infix` functions:
 *    - Must be member functions or extension functions.
 *    - Must have a single parameter.
 *    - Parameter must NOT accept variable number of arguments (`vararg`) and cannot have default values.
 */
fun main() {
    println("--- Kotlin Infix Functions ---")

    val dog = Animal("Dog")

    // Standard function call syntax
    println("Standard syntax call:")
    dog.canSound("bark")
    println()

    // Infix function call syntax (no dot or parentheses needed)
    println("Infix notation call:")
    dog canSound "bark"
    println()
}

// Infix extension function on Animal class
infix fun Animal.canSound(type: String) {
    println("This Animal (${this.name}) makes sound: $type")
}
