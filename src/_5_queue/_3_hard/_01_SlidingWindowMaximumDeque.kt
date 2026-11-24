package _5_queue._3_hard

import java.util.ArrayDeque

/**
 * _01_SlidingWindowMaximumDeque.kt
 * Finds the maximum element in every sliding window of size K using a Monotonic Double-Ended Queue (LeetCode #239).
 *
 * Beginner Explanation:
 * Maintain a Monotonic Decreasing Deque storing element indices:
 * - Remove elements out of current window scope (`deque.first() <= i - k`).
 * - Remove elements smaller than current element `nums[i]` from back of deque.
 * - Append `i` to back of deque.
 * - `deque.first()` gives the max element for the current window!
 *
 * Time Complexity: O(N)
 * Space Complexity: O(K)
 */
fun main() {
    val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
    val k = 3

    println("--- Sliding Window Maximum (Monotonic Deque) ---")
    println("Array: [${nums.joinToString(", ")}], Window Size K = $k")

    val maxWindowResult = maxSlidingWindowDeque(nums, k)
    println("Sliding Window Maximums: [${maxWindowResult.joinToString(", ")}]")
}

fun maxSlidingWindowDeque(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty() || k <= 0) return intArrayOf()

    val n = nums.size
    val result = IntArray(n - k + 1)
    val deque = ArrayDeque<Int>() // Stores indices

    for (i in 0 until n) {
        // Remove indices out of current window
        if (deque.isNotEmpty() && deque.first() <= i - k) {
            deque.removeFirst()
        }

        // Remove elements smaller than current from back
        while (deque.isNotEmpty() && nums[deque.last()] <= nums[i]) {
            deque.removeLast()
        }

        deque.addLast(i)

        // Record max element for current window
        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.first()]
        }
    }

    return result
}
