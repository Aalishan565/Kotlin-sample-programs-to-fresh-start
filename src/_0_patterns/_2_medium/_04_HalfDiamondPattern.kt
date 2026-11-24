package _0_patterns._2_medium

/**
 * _04_HalfDiamondPattern.kt
 * Prints a right-facing half diamond pattern.
 *
 * Pattern for N = 5:
 *   *
 *   **
 *   ***
 *   ****
 *   *****
 *   ****
 *   ***
 *   **
 *   *
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 5
    println("--- 4. Half Diamond Pattern (N = $n) ---")
    printHalfDiamond(n)
}

fun printHalfDiamond(n: Int) {
    for (i in 1..n) {
        repeat(i) { print("*") }
        println()
    }
    for (i in n - 1 downTo 1) {
        repeat(i) { print("*") }
        println()
    }
}
