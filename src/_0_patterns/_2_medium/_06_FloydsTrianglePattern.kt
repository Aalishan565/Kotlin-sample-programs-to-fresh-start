package _0_patterns._2_medium

/**
 * _06_FloydsTrianglePattern.kt
 * Prints Floyd's Triangle with sequential numbers.
 *
 * Pattern for N = 5:
 *   1
 *   2 3
 *   4 5 6
 *   7 8 9 10
 *   11 12 13 14 15
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 5
    println("--- 6. Floyd's Triangle Pattern (N = $n) ---")
    printFloydsTriangle(n)
}

fun printFloydsTriangle(n: Int) {
    var count = 1
    for (i in 1..n) {
        repeat(i) {
            print("$count ")
            count++
        }
        println()
    }
}
