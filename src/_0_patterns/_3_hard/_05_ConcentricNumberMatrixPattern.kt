package _0_patterns._3_hard

import kotlin.math.min

/**
 * _05_ConcentricNumberMatrixPattern.kt
 * Prints a concentric square matrix of numbers decreasing towards the center.
 *
 * Pattern for N = 4:
 *   4 4 4 4 4 4 4
 *   4 3 3 3 3 3 4
 *   4 3 2 2 2 3 4
 *   4 3 2 1 2 3 4
 *   4 3 2 2 2 3 4
 *   4 3 3 3 3 3 4
 *   4 4 4 4 4 4 4
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 4
    println("--- 5. Concentric Number Matrix Pattern (N = $n) ---")
    printConcentricMatrix(n)
}

fun printConcentricMatrix(n: Int) {
    val size = 2 * n - 1
    for (row in 0 until size) {
        for (col in 0 until size) {
            val minDistance = min(min(row, col), min(size - 1 - row, size - 1 - col))
            val value = n - minDistance
            print("$value ")
        }
        println()
    }
}
