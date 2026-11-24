package _4_stack._3_hard

import java.util.ArrayDeque
import kotlin.math.min

/**
 * _02_TrappingRainWaterStack.kt
 * Trapping Rain Water problem using a Monotonic Stack (LeetCode #42).
 *
 * Beginner Explanation:
 * Monotonic Decreasing Stack storing bar indices.
 * When encountering a taller bar, pop the middle bar (bottom of water container)
 * and calculate trapped water bounded by `stack.peek()` (left boundary) and `current` (right boundary).
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
fun main() {
    val heights = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)

    println("--- Trapping Rain Water (Stack Approach) ---")
    println("Heights: [${heights.joinToString(", ")}]")

    val trappedWater = trapRainWaterStack(heights)
    println("Total Water Trapped: $trappedWater units")
}

fun trapRainWaterStack(heights: IntArray): Int {
    val stack = ArrayDeque<Int>()
    var totalWater = 0

    for (i in heights.indices) {
        while (stack.isNotEmpty() && heights[i] > heights[stack.peek()!!]) {
            val bottomIndex = stack.pop()
            if (stack.isEmpty()) break

            val leftBoundary = stack.peek()!!
            val distance = i - leftBoundary - 1
            val boundedHeight = min(heights[i], heights[leftBoundary]) - heights[bottomIndex]

            totalWater += distance * boundedHeight
        }
        stack.push(i)
    }

    return totalWater
}
