package _3_arrays._3_hard

import java.util.Collections
import java.util.PriorityQueue

/**
 * _02_MaxNumberOfSubArrayOfSizeK.kt
 * Finds the maximum element in every contiguous subarray of fixed size K (Sliding Window Maximum - LeetCode #239).
 */
fun main() {
    val array = intArrayOf(1, 3, -1, 4, 0, 5, -4, 9, 8)

    println("--- Max Element in Every Subarray of Size K ---")
    println("Input Array: ${array.joinToString(", ")}")

    println("\nTest 1 (K = 3):")
    maxNumberSubArray(array, 3)

    println("\nTest 2 (K = 2):")
    maxNumberSubArray(array, 2)
}

private fun maxNumberSubArray(array: IntArray, k: Int) {
    if (array.size < k || k <= 0) return

    var startIndex = 0
    var endIndex = 0
    val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())

    while (endIndex < array.size) {
        maxHeap.offer(array[endIndex])

        if (endIndex - startIndex + 1 == k) {
            println("Window [$startIndex..$endIndex] -> Max Number is : ${maxHeap.peek()}")
            maxHeap.remove(array[startIndex])
            startIndex++
        }
        endIndex++
    }
}
