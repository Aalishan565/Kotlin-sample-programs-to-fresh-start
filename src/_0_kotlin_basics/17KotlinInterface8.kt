package _0_kotlin_basics

/**
 * 17KotlinInterface8.kt
 * Demonstrates Default Method Implementations in Kotlin Interfaces (similar to Java 8 default interface methods).
 *
 * Key Concepts:
 * 1. Interface methods in Kotlin can provide a default implementation body.
 * 2. Implementing classes can inherit the default method as-is or optionally override it.
 */

interface City {
    fun name()

    // Default interface implementation
    fun cityBus() {
        println("This city has public city bus services available.")
    }
}

class Bangalore : City {
    override fun name() {
        println("City Name: Bangalore")
    }
}

class Chennai : City {
    override fun name() {
        println("City Name: Chennai")
    }

    // Optionally overriding default interface method
    override fun cityBus() {
        println("Chennai has MTC city bus service network.")
    }
}

fun main() {
    println("--- Default Interface Methods ---")

    val bangalore = Bangalore()
    bangalore.name()
    bangalore.cityBus()

    println()
    val chennai = Chennai()
    chennai.name()
    chennai.cityBus()
}
