package _0_patterns._3_hard

/**
 * _01_HollowSquarePattern.kt
 * Prints a hollow N x N square pattern of stars.
 *
 * Pattern for N = 5:
 *   *****
 *   *   *
 *   *   *
 *   *   *
 *   *****
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 5
    println("--- 1. Hollow Square Pattern (N = $n) ---")
    printHollowSquare(n)
}

fun printHollowSquare(n: Int) {
    for (i in 1..n) {
        for (j in 1..n) {
            if (i == 1 || i == n || j == 1 || j == n) {
                print("*")
            } else {
                print(" ")
            }
        }
        println()
    }
}
