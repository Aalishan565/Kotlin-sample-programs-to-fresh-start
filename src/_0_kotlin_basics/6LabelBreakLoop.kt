package _0_kotlin_basics

/**
 * 6LabelBreakLoop.kt
 * Demonstrates loop breaking and labeled break expressions in Kotlin.
 *
 * Key Concepts:
 * 1. Standard `break`: Terminates the nearest enclosing loop.
 * 2. Labeled `break@labelName`: Allows terminating an outer loop directly from inside a nested loop.
 */
fun main() {
    println("--- 1. Standard Break in Single Loop ---")
    for (i in 1..5) {
        if (i == 3) {
            println("Breaking loop at i = $i")
            break
        }
        println("i = $i")
    }

    println("\n--- 2. Labeled Break in Nested Loops ---")
    // Defining label `outerLoop@` for the outer loop
    outerLoop@ for (i in 1..3) {
        for (j in 1..3) {
            println("i = $i, j = $j")
            if (i == 2 && j == 1) {
                println("Breaking outerLoop at i = $i, j = $j")
                break@outerLoop // Breaks the outer loop directly
            }
        }
    }
    println("Execution continued after outer loop break.")
}
