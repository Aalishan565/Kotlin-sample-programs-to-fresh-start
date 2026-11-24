package _3_arrays._1_easy

/**
 * _02_ReverseArray.kt
 * Demonstrates reversing an array in Kotlin using various approaches.
 *
 * Approaches:
 * 1. Two-Pointer Iterative Loop (In-Place, O(N) Time, O(1) Space).
 * 2. Recursive In-Place Approach (O(N) Time, O(N) Call Stack).
 * 3. Kotlin Standard Library Built-in (`.reverse()` / `.reversedArray()`).
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
 * Swaps elements at `startIndex` and `endIndex` until pointers meet.
 */
fun reverseArrayUsingLoop(array: IntArray) {
    var startIndex = 0
    var endIndex = array.size - 1

    while (startIndex < endIndex) {
        val temp = array[startIndex]
        array[startIndex] = array[endIndex]
        array[endIndex] = temp
        startIndex++
        endIndex--
    }
}

/**
 * Approach 2: Recursive In-Place Reversal
 * Base case: start >= end. Swaps start & end elements and calls recursively.
 */
fun reverseArrayRecursive(array: IntArray, start: Int, end: Int) {
    if (start >= end) return

    val temp = array[start]
    array[start] = array[end]
    array[end] = temp

    reverseArrayRecursive(array, start + 1, end - 1)
}
