package _0_patterns._3_hard

/**
 * _03_ButterflyPattern.kt
 * Prints a symmetric butterfly pattern of stars.
 *
 * Pattern for N = 5:
 *   *        *
 *   **      **
 *   ***    ***
 *   ****  ****
 *   **********
 *   ****  ****
 *   ***    ***
 *   **      **
 *   *        *
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 5
    println("--- 3. Butterfly Pattern (N = $n) ---")
    printButterfly(n)
}

fun printButterfly(n: Int) {
    // Upper Half
    for (i in 1..n) {
        repeat(i) { print("*") }
        repeat(2 * (n - i)) { print(" ") }
        repeat(i) { print("*") }
        println()
    }
    // Lower Half
    for (i in n - 1 downTo 1) {
        repeat(i) { print("*") }
        repeat(2 * (n - i)) { print(" ") }
        repeat(i) { print("*") }
        println()
    }
}
