package _4_stack._2_medium

import java.util.ArrayDeque

/**
 * _04_DailyTemperatures.kt
 * Calculates number of days until a warmer temperature for each day (LeetCode #739).
 *
 * Beginner Explanation:
 * Monotonic Decreasing Stack storing day indices.
 * When today's temp > temp at stack top: pop index and `result[prevDay] = today - prevDay`.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
fun main() {
    val temperatures = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)

    println("--- Daily Temperatures ---")
    println("Temperatures: ${temperatures.joinToString(", ")}")

    val answer = dailyTemperatures(temperatures)
    println("Days to Wait: ${answer.joinToString(", ")}")
}

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val n = temperatures.size
    val result = IntArray(n)
    val stack = ArrayDeque<Int>() // Stores day indices

    for (day in 0 until n) {
        while (stack.isNotEmpty() && temperatures[day] > temperatures[stack.peek()!!]) {
            val prevDay = stack.pop()
            result[prevDay] = day - prevDay
        }
        stack.push(day)
    }

    return result
}
