package _0_patterns._2_medium

/**
 * _02_InvertedFullPyramidPattern.kt
 * Prints an inverted full centered pyramid of stars.
 *
 * Pattern for N = 5:
 *   *********
 *    *******
 *     *****
 *      ***
 *       *
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 5
    println("--- 2. Inverted Full Pyramid Pattern (N = $n) ---")
    printInvertedFullPyramid(n)
}

fun printInvertedFullPyramid(n: Int) {
    for (i in n downTo 1) {
        repeat(n - i) {
            print(" ")
        }
        repeat(2 * i - 1) {
            print("*")
        }
        println()
    }
}
