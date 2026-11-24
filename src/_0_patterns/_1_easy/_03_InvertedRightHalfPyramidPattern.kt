package _0_patterns._1_easy

/**
 * _03_InvertedRightHalfPyramidPattern.kt
 * Prints an inverted right-angled triangle of stars.
 *
 * Pattern for N = 5:
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
    println("--- 3. Inverted Right Half Pyramid Pattern (N = $n) ---")
    printInvertedRightHalfPyramid(n)
}

fun printInvertedRightHalfPyramid(n: Int) {
    for (i in n downTo 1) {
        repeat(i) {
            print("*")
        }
        println()
    }
}
