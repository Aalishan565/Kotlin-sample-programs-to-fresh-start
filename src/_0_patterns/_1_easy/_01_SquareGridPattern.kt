package _0_patterns._1_easy

/**
 * _01_SquareGridPattern.kt
 * Prints a solid N x N square grid of stars.
 *
 * Pattern for N = 5:
 *   *****
 *   *****
 *   *****
 *   *****
 *   *****
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 5
    println("--- 1. Square Grid Pattern (N = $n) ---")
    printSquareGrid(n)
}

fun printSquareGrid(n: Int) {
    repeat(n) {
        repeat(n) {
            print("*")
        }
        println()
    }
}
