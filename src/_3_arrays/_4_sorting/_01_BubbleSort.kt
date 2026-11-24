package _3_arrays._4_sorting

/**
 * _01_BubbleSort.kt
 * Sorts an array using the Bubble Sort algorithm.
 *
 * Beginner Explanation:
 * Repeatedly steps through the array, compares adjacent elements, and swaps them if they are in the wrong order.
 * Larger elements "bubble up" to the end of the array in each outer loop pass.
 *
 * Time Complexity: O(N^2) Average/Worst Case, O(N) Best Case (Optimized with swapped flag)
 * Space Complexity: O(1) Auxiliary Space
 */
fun main() {
    val array = intArrayOf(0, 4, 0, 0, 1, 3, 4, 1, 0, 2, 0)

    println("--- Bubble Sort ---")
    println("Original Array: ${array.joinToString(", ")}")

    bubbleSort(array)
    println("Sorted Array  : ${array.joinToString(", ")}")
}

fun bubbleSort(array: IntArray) {
    val n = array.size

    for (i in 0 until n - 1) {
        var swapped = false

        for (j in 0 until n - 1 - i) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
                swapped = true
            }
        }

        // If no two elements were swapped in inner loop, array is already sorted
        if (!swapped) break
    }
}
