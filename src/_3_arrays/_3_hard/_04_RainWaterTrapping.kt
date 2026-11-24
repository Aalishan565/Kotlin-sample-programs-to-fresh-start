package _3_arrays._3_hard

import kotlin.math.max
import kotlin.math.min

/**
 * _04_RainWaterTrapping.kt
 * Trapping Rain Water problem (LeetCode #42).
 */
fun main() {
    val heights = intArrayOf(3, 1, 2, 4, 0, 1, 3, 2)

    println("--- Trapping Rain Water ---")
    println("Heights: ${heights.joinToString(", ")}")

    val trappedWater = trapRainWater(heights)
    println("Total Water Trapped: $trappedWater units")
}

fun trapRainWater(heights: IntArray): Int {
    if (heights.isEmpty()) return 0
    val n = heights.size

    val leftMax = IntArray(n)
    val rightMax = IntArray(n)

    leftMax[0] = heights[0]
    for (i in 1 until n) {
        leftMax[i] = max(leftMax[i - 1], heights[i])
    }

    rightMax[n - 1] = heights[n - 1]
    for (i in n - 2 downTo 0) {
        rightMax[i] = max(rightMax[i + 1], heights[i])
    }

    var totalWater = 0
    for (i in 0 until n) {
        totalWater += min(leftMax[i], rightMax[i]) - heights[i]
    }

    return totalWater
}
