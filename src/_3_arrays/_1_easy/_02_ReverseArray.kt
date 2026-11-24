package _3_arrays._1_easy

/**
 * _02_ReverseArray.kt
 * Demonstrates reversing an array in Kotlin using various approaches.
 *
 * Beginner Explanation:
 * Reversing an array means swapping elements from outer edges moving inward until pointers meet in the middle.
 * Example: Input [1, 2, 3, 4, 5] -> Output [5, 4, 3, 2, 1].
 *
 * Approaches:
 * 1. Two-Pointer Iterative Loop: O(N) Time, O(1) Auxiliary Space.
 * 2. Recursive In-Place Approach: O(N) Time, O(N) Call Stack Space.
 * 3. Kotlin Standard Library Built-in (`.reversedArray()`).
 */
fun main() {
    val originalArray = intArrayOf(1, 2, 3, 4, 5, 6, 7)

    println("Original Array: ${originalArray.joinToString(", ")}")

    // 1. Iterative Two-Pointer In-Place
    val arr1 = originalArray.clone()
    reverseArrayUsingLoop(arr1)
    println("1. Two-Pointer Loop: ${arr1.joinToString(", ")}")

    // 2. Recursive In-Place
    val arr2 = originalArray.clone()
    reverseArrayRecursive(arr2, 0, arr2.size - 1)
    println("2. Recursive:        ${arr2.joinToString(", ")}")

    // 3. Kotlin Standard Library
    val arr3 = originalArray.reversedArray()
    println("3. Built-in:         ${arr3.joinToString(", ")}")
}

/**
 * Approach 1: Iterative Two-Pointer Loop (In-Place)
 * Swaps elements at `startIndex` and `endIndex` moving towards the center.
 */
fun reverseArrayUsingLoop(array: IntArray) {
    var startIndex = 0
    var endIndex = array.size - 1

    // Keep swapping until left pointer meets or crosses right pointer
    while (startIndex < endIndex) {
        // Swap values using temporary variable
        val temp = array[startIndex]
        array[startIndex] = array[endIndex]
        array[endIndex] = temp

        // Move pointers inward
        startIndex++
        endIndex--
    }
}

/**
 * Approach 2: Recursive In-Place Reversal
 * Base case: start >= end. Swaps start & end elements and calls itself recursively.
 */
fun reverseArrayRecursive(array: IntArray, start: Int, end: Int) {
    // Base condition: stop recursion when pointers meet or cross
    if (start >= end) return

    // Swap elements at start and end
    val temp = array[start]
    array[start] = array[end]
    array[end] = temp

    // Recursive step: process inner subarray
    reverseArrayRecursive(array, start + 1, end - 1)
}
