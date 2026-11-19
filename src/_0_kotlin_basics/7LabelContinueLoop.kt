package _0_kotlin_basics

/**
 * 7LabelContinueLoop.kt
 * Demonstrates loop continuation and labeled continue expressions in Kotlin.
 *
 * Key Concepts:
 * 1. Standard `continue`: Skips the current iteration of the nearest enclosing loop and proceeds to the next iteration.
 * 2. Labeled `continue@labelName`: Skips the current iteration of a specific labeled outer loop.
 */
fun main() {
    println("--- 1. Standard Continue in Single Loop ---")
    for (i in 1..5) {
        if (i == 3) {
            println("Skipping iteration for i = $i")
            continue
        }
        println("i = $i")
    }

    println("\n--- 2. Labeled Continue in Nested Loops ---")
    // Defining label `outerLoop@` for the outer loop
    outerLoop@ for (i in 1..3) {
        for (j in 1..3) {
            println("i = $i, j = $j")
            if (i == 2 && j == 2) {
                println("Skipping remaining inner iterations and continuing outerLoop at i = $i, j = $j")
                continue@outerLoop
            }
            println("Finished inner iteration for i = $i, j = $j")
        }
    }
}
