package _0_patterns._2_medium

/**
 * _01_FullPyramidPattern.kt
 * Prints a full centered pyramid of stars.
 *
 * Pattern for N = 5:
 *       *
 *      ***
 *     *****
 *    *******
 *   *********
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 5
    println("--- 1. Full Pyramid Pattern (N = $n) ---")
    printFullPyramid(n)
}

fun printFullPyramid(n: Int) {
    for (i in 1..n) {
        repeat(n - i) {
            print(" ")
        }
        repeat(2 * i - 1) {
            print("*")
        }
        println()
    }
}
