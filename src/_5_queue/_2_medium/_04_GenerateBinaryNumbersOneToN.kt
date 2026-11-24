package _5_queue._2_medium

import java.util.ArrayDeque

/**
 * _04_GenerateBinaryNumbersOneToN.kt
 * Generates binary numbers from 1 to N using BFS Queue traversal.
 *
 * Beginner Explanation:
 * Start with queue containing `"1"`.
 * For each iteration:
 * - Pop front binary string `curr`.
 * - Append `curr + "0"` and `curr + "1"` back into queue.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
fun main() {
    val n = 10

    println("--- Generate Binary Numbers 1 to $n ---")
    val binaryNumbers = generateBinaryNumbers(n)
    println("Binary Numbers: ${binaryNumbers.joinToString(", ")}")
}

fun generateBinaryNumbers(n: Int): List<String> {
    if (n <= 0) return emptyList()

    val result = mutableListOf<String>()
    val queue = ArrayDeque<String>()

    queue.addLast("1")

    repeat(n) {
        val current = queue.removeFirst()
        result.add(current)

        queue.addLast(current + "0")
        queue.addLast(current + "1")
    }

    return result
}
