package _0_patterns._2_medium

/**
 * _05_NumberTrianglePattern.kt
 * Prints a right-angled number triangle pattern.
 *
 * Pattern for N = 5:
 *   1
 *   12
 *   123
 *   1234
 *   12345
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 5
    println("--- 5. Number Triangle Pattern (N = $n) ---")
    printNumberTriangle(n)
}

fun printNumberTriangle(n: Int) {
    for (i in 1..n) {
        for (j in 1..i) {
            print(j)
        }
        println()
    }
}
