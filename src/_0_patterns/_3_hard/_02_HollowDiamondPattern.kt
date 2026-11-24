package _0_patterns._3_hard

/**
 * _02_HollowDiamondPattern.kt
 * Prints a hollow diamond pattern of stars.
 *
 * Pattern for N = 5:
 *       *
 *      * *
 *     *   *
 *    *     *
 *   *       *
 *    *     *
 *     *   *
 *      * *
 *       *
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 5
    println("--- 2. Hollow Diamond Pattern (N = $n) ---")
    printHollowDiamond(n)
}

fun printHollowDiamond(n: Int) {
    // Top Half
    for (i in 1..n) {
        repeat(n - i) { print(" ") }
        for (j in 1..(2 * i - 1)) {
            if (j == 1 || j == 2 * i - 1) {
                print("*")
            } else {
                print(" ")
            }
        }
        println()
    }
    // Bottom Half
    for (i in n - 1 downTo 1) {
        repeat(n - i) { print(" ") }
        for (j in 1..(2 * i - 1)) {
            if (j == 1 || j == 2 * i - 1) {
                print("*")
            } else {
                print(" ")
            }
        }
        println()
    }
}
