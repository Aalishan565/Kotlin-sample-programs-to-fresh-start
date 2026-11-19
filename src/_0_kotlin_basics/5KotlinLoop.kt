package _0_kotlin_basics

/**
 * 5KotlinLoop.kt
 * Demonstrates ranges and iteration loops (`for`, `forEach`) in Kotlin.
 *
 * Key Concepts:
 * 1. Closed Range (`a..b`): Includes both `a` and `b`.
 * 2. Half-open Range (`a until b`): Includes `a` up to `b - 1` (`b` excluded).
 * 3. Reverse Range (`a downTo b`): Decrements from `a` down to `b`.
 * 4. Step Range (`a..b step s`): Increments by step value `s`.
 * 5. `forEach` iteration using Kotlin standard library extensions.
 */
fun main() {
    println("--- 1. Closed Range (1..5) ---")
    for (i in 1..5) {
        print("$i ")
    }
    println()

    println("\n--- 2. Half-Open Range (1 until 5) ---")
    for (i in 1 until 5) {
        print("$i ")
    }
    println()

    println("\n--- 3. Reverse Range (5 downTo 1) ---")
    val reverseNumbers = 5 downTo 1
    for (value in reverseNumbers) {
        print("$value ")
    }
    println()

    println("\n--- 4. Range with Step (1..10 step 2) ---")
    for (i in 1..10 step 2) {
        print("$i ")
    }
    println()

    println("\n--- 5. Iterating using forEach Lambda ---")
    (1..5).forEach { number ->
        print("$number ")
    }
    println()
}
