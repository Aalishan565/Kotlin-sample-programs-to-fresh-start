package _0_kotlin_basics

/**
 * 18KotlinDataClass.kt
 * Demonstrates Data Classes in Kotlin.
 *
 * Key Concepts:
 * 1. `data class`: Automatically generates `equals()`, `hashCode()`, `toString()`, `copy()`, and `componentN()` functions.
 * 2. Requirements: Primary constructor must have at least one parameter marked `val` or `var`.
 * 3. `copy()` Method: Creates a new object with modified or unmodified properties.
 */

data class Laptop(val brand: String, val price: String)

fun main() {
    println("--- Kotlin Data Classes ---")

    val lap1 = Laptop("Dell", "1000")
    val lap2 = Laptop("Apple", "2000")

    // Automatically generated toString() implementation
    println("lap1 toString(): $lap1")
    println("lap2 toString(): $lap2")

    // equals() structural comparison generated automatically
    val lap1Duplicate = Laptop("Dell", "1000")
    println("lap1 == lap1Duplicate (equals): ${lap1 == lap1Duplicate}")

    // Copying object with modified parameters
    val lap3 = lap2.copy(price = "2500")
    println("lap3 copied from lap2 with updated price: $lap3")

    // Destructuring declarations using generated componentN() functions
    val (brand, price) = lap1
    println("Destructured lap1: brand = $brand, price = $price")
}
