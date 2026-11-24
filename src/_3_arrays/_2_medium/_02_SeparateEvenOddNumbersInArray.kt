package _3_arrays._2_medium

/**
 * _02_SeparateEvenOddNumbersInArray.kt
 * Separates even and odd numbers in an integer array such that all EVEN numbers come first,
 * followed by all ODD numbers (Sort Array By Parity - LeetCode #905).
 */
fun main() {
    val testArrays = listOf(
        intArrayOf(12, 34, 45, 9, 8, 90, 3),
        intArrayOf(1, 3, 5, 2, 4, 6),
        intArrayOf(2, 4, 6, 8)
    )

    println("--- Separate Even and Odd Numbers ---")
    for (arr in testArrays) {
        val original = arr.clone()
        val arrTwoPointer = arr.clone()
        separateEvenOddTwoPointer(arrTwoPointer)
        println("Original Array      : ${original.joinToString(", ")}")
        println("  -> Two-Pointer    : ${arrTwoPointer.joinToString(", ")}")
    }
}

/**
 * Approach 1: Two-Pointer In-Place Swap (Optimal: O(N) Time, O(1) Space)
 */
fun separateEvenOddTwoPointer(array: IntArray) {
    var left = 0
    var right = array.size - 1

    while (left < right) {
        while (left < right && array[left] % 2 == 0) {
            left++
        }
        while (left < right && array[right] % 2 != 0) {
            right--
        }
        if (left < right) {
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
            left++
            right--
        }
    }
}
