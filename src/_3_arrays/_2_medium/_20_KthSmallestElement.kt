package _3_arrays._2_medium

import java.util.Collections
import java.util.PriorityQueue

/**
 * _20_KthSmallestElement.kt
 * Finds the K-th smallest element in an unsorted array using a Max-Heap.
 *
 * Beginner Explanation:
 * Maintain a Max-Heap of size K.
 * If incoming element is smaller than `maxHeap.peek()`, pop maximum and insert smaller element.
 *
 * Time Complexity: O(N log K)
 * Space Complexity: O(K)
 */
fun main() {
    val nums = intArrayOf(3, 2, 1, 5, 6, 7, 4)
    val k = 3

    println("--- K-th Smallest Element ($k-th) ---")
    println("Array: ${nums.joinToString(", ")}")

    val kthSmallest = findKthSmallestUsingHeap(nums, k)
    println("$k-th Smallest Element: $kthSmallest")
}

fun findKthSmallestUsingHeap(nums: IntArray, k: Int): Int {
    val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())

    for (i in 0 until k) {
        maxHeap.offer(nums[i])
    }

    for (i in k until nums.size) {
        if (nums[i] < maxHeap.peek()!!) {
            maxHeap.poll()
            maxHeap.offer(nums[i])
        }
    }

    return maxHeap.peek()!!
}
