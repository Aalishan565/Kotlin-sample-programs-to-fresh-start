package _3_arrays._4_sorting

/**
 * _02_SelectionSort.kt
 * Sorts an array using the Selection Sort algorithm.
 *
 * Beginner Explanation:
 * Divides array into sorted and unsorted parts.
 * Repeatedly finds the minimum element from the unsorted part and swaps it to the front.
 *
 * Time Complexity: O(N^2) All Cases
 * Space Complexity: O(1) Auxiliary Space
 */
fun main() {
    val array = intArrayOf(5, 3, 4, 2, 1)

    println("--- Selection Sort ---")
    println("Original Array: ${array.joinToString(", ")}")

    selectionSort(array)
    println("Sorted Array  : ${array.joinToString(", ")}")
}

fun selectionSort(array: IntArray) {
    val n = array.size

    for (i in 0 until n - 1) {
        var minIndex = i

        // Find the minimum element in unsorted subarray
        for (j in i + 1 until n) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }

        // Swap the found minimum element with element at index i
        if (minIndex != i) {
            val temp = array[i]
            array[i] = array[minIndex]
            array[minIndex] = temp
        }
    }
}
