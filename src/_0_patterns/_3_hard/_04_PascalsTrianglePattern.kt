package _0_patterns._3_hard

/**
 * _04_PascalsTrianglePattern.kt
 * Prints Pascal's Triangle pattern using combination formula C(n, k).
 *
 * Pattern for N = 5:
 *       1
 *      1 1
 *     1 2 1
 *    1 3 3 1
 *   1 4 6 4 1
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
fun main() {
    val n = 5
    println("--- 4. Pascal's Triangle Pattern (N = $n) ---")
    printPascalsTriangle(n)
}

fun printPascalsTriangle(n: Int) {
    for (i in 0 until n) {
        repeat(n - i - 1) { print(" ") }
        var number = 1
        for (j in 0..i) {
            print("$number ")
            number = number * (i - j) / (j + 1)
        }
        println()
    }
}
