package _0_patterns._2_medium

/**
 * _03_DiamondPattern.kt
 * Prints a full solid diamond pattern of stars.
 *
 * Pattern for N = 5:
 *       *
 *      ***
 *     *****
 *    *******
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
    println("--- 3. Diamond Pattern (N = $n) ---")
    printDiamond(n)
}

fun printDiamond(n: Int) {
    // Upper Pyramid
    for (i in 1..n) {
        repeat(n - i) { print(" ") }
        repeat(2 * i - 1) { print("*") }
        println()
    }
    // Lower Inverted Pyramid
    for (i in n - 1 downTo 1) {
        repeat(n - i) { print(" ") }
        repeat(2 * i - 1) { print("*") }
        println()
    }
}
