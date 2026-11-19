package _0_kotlin_basics

/**
 * 21KotlinCompanion.kt
 * Demonstrates Companion Objects in Kotlin (replaces Java `static` members).
 *
 * Key Concepts:
 * 1. `companion object`: A singleton object tied to a class whose members can be accessed using `ClassName.memberName`.
 * 2. Kotlin does not have a `static` keyword; companion objects fulfill this design pattern.
 */

class InnovationCenter {
    companion object {
        fun showMessage() {
            println("Hi from Companion Object (Static-like invocation)!")
        }
    }
}

fun main() {
    println("--- Kotlin Companion Objects ---")

    // Invoking method on companion object directly via class name
    InnovationCenter.showMessage()
}
