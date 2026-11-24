package _0_patterns._1_easy

/**
 * _02_RightHalfPyramidPattern.kt
 * Prints a right-angled triangle (Right Half Pyramid) of stars.
 *
 * Pattern for N = 5:
 *   *
 *   **
 *   ***
 *   ****
 *   *****
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 5
    println("--- 2. Right Half Pyramid Pattern (N = $n) ---")
    printRightHalfPyramid(n)
}

fun printRightHalfPyramid(n: Int) {
    for (i in 1..n) {
        repeat(i) {
            print("*")
        }
        println()
    }
}
