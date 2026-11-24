package _0_patterns._1_easy

/**
 * _04_LeftHalfPyramidPattern.kt
 * Prints a left-aligned right-angled triangle (Left Half Pyramid) with leading spaces.
 *
 * Pattern for N = 5:
 *       *
 *      **
 *     ***
 *    ****
 *   *****
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 5
    println("--- 4. Left Half Pyramid Pattern (N = $n) ---")
    printLeftHalfPyramid(n)
}

fun printLeftHalfPyramid(n: Int) {
    for (i in 1..n) {
        repeat(n - i) {
            print(" ")
        }
        repeat(i) {
            print("*")
        }
        println()
    }
}
