package _3_arrays._1_easy

import kotlin.math.abs

/**
 * _07_SquareTheSortedArray.kt
 * Squares each element of a sorted array and returns a new array sorted in non-decreasing order (LeetCode #977).
 */
fun main() {
    val array = intArrayOf(-5, -3, -1, 2, 4)

    println("--- Square The Sorted Array ---")
    println("Original Sorted Array: ${array.joinToString(", ")}")

    val squared = sortedSquaresTwoPointer(array)
    println("Squared & Sorted Array: ${squared.joinToString(", ")}")
}

/**
 * Two-Pointer Approach (Optimal: O(N) Time, O(N) Space)
 */
fun sortedSquaresTwoPointer(array: IntArray): IntArray {
    val n = array.size
    val result = IntArray(n)
    var left = 0
    var right = n - 1

    for (index in n - 1 downTo 0) {
        if (abs(array[left]) > abs(array[right])) {
            result[index] = array[left] * array[left]
            left++
        } else {
            result[index] = array[right] * array[right]
            right--
        }
    }

    return result
}
