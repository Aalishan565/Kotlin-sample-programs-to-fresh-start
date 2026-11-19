package _0_kotlin_basics

/**
 * 4KotlinSwitchWhen.kt
 * Demonstrates the `when` construct in Kotlin (replaces Java's `switch`).
 *
 * Key Concepts:
 * 1. `when` as a Statement: Executes matching branch based on exact value or range.
 * 2. `when` as an Expression: Returns a value from the matching branch (requires exhaustive `else` branch).
 * 3. Multiple conditions and range checks inside `when`.
 */
fun main() {
    val num = 2

    println("--- 1. When as a Statement ---")
    when (num) {
        1 -> println("The number is One")
        2 -> println("The number is Two")
        3 -> println("The number is Three")
        else -> println("No match found")
    }

    println("\n--- 2. When as an Expression ---")
    val numberName = when (num) {
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        else -> "Unknown Number"
    }
    println("Matched name: $numberName")

    println("\n--- 3. When with Multiple Conditions & Ranges ---")
    val score = 85
    val grade = when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "F"
    }
    println("Score: $score, Grade: $grade")
}
