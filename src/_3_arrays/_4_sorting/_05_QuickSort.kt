package _3_arrays._4_sorting

/**
 * _05_QuickSort.kt
 * Sorts an array using the Quick Sort algorithm (In-Place Divide and Conquer).
 *
 * Beginner Explanation:
 * Picks a pivot element and partitions array such that elements smaller than pivot are on left,
 * and elements greater than pivot are on right. Recursively sorts sub-parts.
 *
 * Time Complexity: O(N log N) Average Case, O(N^2) Worst Case
 * Space Complexity: O(log N) Recursive Call Stack
 */
fun main() {
    val array = intArrayOf(-2, -4, 1, 2, 3, 4, 5, 6, 2, 1, 5, 4)

    println("--- Quick Sort ---")
    println("Original Array: ${array.joinToString(", ")}")

    quickSort(array, 0, array.size - 1)
    println("Sorted Array  : ${array.joinToString(", ")}")
}

fun quickSort(array: IntArray, left: Int, right: Int) {
    if (left >= right) return

    val partitionIndex = partition(array, left, right)

    if (left < partitionIndex - 1) {
        quickSort(array, left, partitionIndex - 1)
    }
    if (partitionIndex < right) {
        quickSort(array, partitionIndex, right)
    }
}

private fun partition(array: IntArray, leftBoundary: Int, rightBoundary: Int): Int {
    var left = leftBoundary
    var right = rightBoundary
    val pivot = array[(left + right) / 2]

    while (left <= right) {
        while (array[left] < pivot) left++
        while (array[right] > pivot) right--

        if (left <= right) {
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
            left++
            right--
        }
    }

    return left
}
