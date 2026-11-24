package _3_arrays._2_medium

import java.util.PriorityQueue

/**
 * _21_KthLargestElement.kt
 * Finds the K-th largest element in an unsorted array using Min-Heap (LeetCode #215).
 */
fun main() {
    val nums = intArrayOf(3, 2, 1, 5, 6, 7, 4)
    val k = 2

    println("--- K-th Largest Element ($k-th) ---")
    println("Array: ${nums.joinToString(", ")}")

    val kthLargest = findKthLargestUsingHeap(nums, k)
    println("$k-th Largest Element: $kthLargest")
}

fun findKthLargestUsingHeap(nums: IntArray, k: Int): Int {
    val minHeap = PriorityQueue<Int>()

    for (i in 0 until k) {
        minHeap.offer(nums[i])
    }

    for (i in k until nums.size) {
        if (nums[i] > minHeap.peek()!!) {
            minHeap.poll()
            minHeap.offer(nums[i])
        }
    }

    return minHeap.peek()!!
}
