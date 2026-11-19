package _0_kotlin_basics

/**
 * 17KotlinInterface8_1.kt
 * Demonstrates resolving Multiple Interface Inheritance Default Method Conflicts in Kotlin.
 *
 * Key Concepts:
 * 1. When a class implements multiple interfaces with identical default method signatures, the compiler requires an explicit override.
 * 2. Use `super<InterfaceName>.methodName()` to disambiguate and call a specific interface's default implementation.
 */

interface DogInterface {
    fun name() {
        println("Default implementation from DogInterface")
    }
}

interface CatInterface {
    fun name() {
        println("Default implementation from CatInterface")
    }
}

class D1 : DogInterface, CatInterface {
    // Must override name() to resolve conflict between DogInterface and CatInterface
    override fun name() {
        println("Resolving name conflict in class D1:")
        super<DogInterface>.name() // Explicitly calling DogInterface implementation
    }
}

class C1 : CatInterface {
    // Inherits default name() implementation from CatInterface automatically
}

fun main() {
    println("--- Resolving Interface Conflict ---")

    val d1 = D1()
    d1.name()

    println("\n--- Single Interface Default Implementation ---")
    val c1 = C1()
    c1.name()
}
