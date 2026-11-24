package _3_arrays._2_medium

/**
 * _06_ReversalArrayRotation.kt
 * Rotates an array by K positions using the 3-step Array Reversal Algorithm (LeetCode #189).
 *
 * Beginner Explanation:
 * To rotate array by K positions:
 * 1. Reverse the first part of array `0..n-1-k`.
 * 2. Reverse the second part `n-k..n-1`.
 * 3. Reverse the entire array `0..n-1`.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val rotateBy = 5

    println("--- Rotate Array by $rotateBy Positions ---")
    println("Original Array: ${array.joinToString(", ")}")

    rotateArray(array, rotateBy)
    println("Rotated Array : ${array.joinToString(", ")}")
}

fun rotateArray(array: IntArray, k: Int) {
    if (array.isEmpty()) return
    val rotation = k % array.size

    val splitIndex = array.size - 1 - rotation
    reverseRange(array, 0, splitIndex)
    reverseRange(array, splitIndex + 1, array.size - 1)
    reverseRange(array, 0, array.size - 1)
}

private fun reverseRange(array: IntArray, start: Int, end: Int) {
    var left = start
    var right = end
    while (left < right) {
        val temp = array[left]
        array[left] = array[right]
        array[right] = temp
        left++
        right--
    }
}
