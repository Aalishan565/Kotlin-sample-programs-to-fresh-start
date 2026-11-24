package _4_stack._3_hard

import java.util.ArrayDeque
import kotlin.math.max

/**
 * _01_LargestRectangleInHistogram.kt
 * Finds the largest rectangle area in a histogram (LeetCode #84).
 *
 * Beginner Explanation:
 * Monotonic Increasing Stack storing bar indices.
 * When current height < height at stack top, pop index `i` and calculate rectangle area with `heights[i]` as the shortest bar:
 * `width = current_index - stack.peek() - 1`.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
fun main() {
    val heights1 = intArrayOf(2, 1, 5, 6, 2, 3)
    val heights2 = intArrayOf(2, 4)

    println("--- Largest Rectangle in Histogram ---")
    println("Heights 1: [${heights1.joinToString(", ")}] -> Max Area: ${largestRectangleArea(heights1)}")
    println("Heights 2: [${heights2.joinToString(", ")}] -> Max Area: ${largestRectangleArea(heights2)}")
}

fun largestRectangleArea(heights: IntArray): Int {
    val stack = ArrayDeque<Int>()
    var maxArea = 0
    val n = heights.size

    for (i in 0..n) {
        val currentHeight = if (i == n) 0 else heights[i]

        while (stack.isNotEmpty() && currentHeight < heights[stack.peek()!!]) {
            val h = heights[stack.pop()]
            val w = if (stack.isEmpty()) i else i - stack.peek()!! - 1
            maxArea = max(maxArea, h * w)
        }

        stack.push(i)
    }

    return maxArea
}
