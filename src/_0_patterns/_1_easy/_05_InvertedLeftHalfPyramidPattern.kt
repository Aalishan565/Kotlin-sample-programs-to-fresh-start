package _0_patterns._1_easy

/**
 * _05_InvertedLeftHalfPyramidPattern.kt
 * Prints an inverted left-aligned triangle with leading spaces.
 *
 * Pattern for N = 5:
 *   *****
 *    ****
 *     ***
 *      **
 *       *
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 5
    println("--- 5. Inverted Left Half Pyramid Pattern (N = $n) ---")
    printInvertedLeftHalfPyramid(n)
}

fun printInvertedLeftHalfPyramid(n: Int) {
    for (i in n downTo 1) {
        repeat(n - i) {
            print(" ")
        }
        repeat(i) {
            print("*")
        }
        println()
    }
}
