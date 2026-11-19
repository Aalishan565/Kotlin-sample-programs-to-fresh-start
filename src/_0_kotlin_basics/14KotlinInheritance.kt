package _0_kotlin_basics

/**
 * 14KotlinInheritance.kt
 * Demonstrates Class Inheritance, `open` Keyword, and Method Overriding in Kotlin.
 *
 * Key Concepts:
 * 1. Default `final`: In Kotlin, all classes and methods are `final` by default (cannot be inherited/overridden).
 * 2. `open` Keyword: Unlocks a class or method to allow inheritance and overriding.
 * 3. `override` Keyword: Explicitly required when overriding a superclass member function.
 */

// Superclass marked `open` to allow inheritance
open class Human {
    // Method marked `open` to allow overriding
    open fun think() {
        println("Human is thinking...")
    }
}

// Child class extending Human superclass
class Programmer : Human() {
    // Overriding superclass function
    override fun think() {
        println("Programmer is thinking in Kotlin & Algorithms...")
    }
}

fun main() {
    println("--- Kotlin Class Inheritance ---")

    val human = Human()
    print("Human object: ")
    human.think()

    val programmer: Human = Programmer()
    print("Programmer object (Polymorphic call): ")
    programmer.think()
}
