package _3_arrays._4_sorting

/**
 * _04_MergeSort.kt
 * Sorts an array using the Merge Sort algorithm (Divide and Conquer).
 *
 * Beginner Explanation:
 * 1. Divide: Recursively split array in half until single-element subarrays remain.
 * 2. Conquer: Recursively sort two halves.
 * 3. Combine: Merge two sorted halves into a single sorted array.
 *
 * Time Complexity: O(N log N) All Cases
 * Space Complexity: O(N) Auxiliary Space for temporary array
 */
fun main() {
    val array = intArrayOf(-2, -4, 1, 2, 3, 4, 5, 6, 2, 1, 5, 4)

    println("--- Merge Sort ---")
    println("Original Array: ${array.joinToString(", ")}")

    mergeSort(array)
    println("Sorted Array  : ${array.joinToString(", ")}")
}

fun mergeSort(array: IntArray) {
    if (array.isEmpty()) return
    divideAndMerge(array, 0, array.size - 1)
}

private fun divideAndMerge(array: IntArray, low: Int, high: Int) {
    if (low < high) {
        val mid = low + (high - low) / 2
        divideAndMerge(array, low, mid)
        divideAndMerge(array, mid + 1, high)
        merge(array, low, mid, high)
    }
}

private fun merge(array: IntArray, low: Int, mid: Int, high: Int) {
    val temp = IntArray(high - low + 1)
    var left = low
    var right = mid + 1
    var k = 0

    while (left <= mid && right <= high) {
        if (array[left] <= array[right]) {
            temp[k++] = array[left++]
        } else {
            temp[k++] = array[right++]
        }
    }

    while (left <= mid) {
        temp[k++] = array[left++]
    }

    while (right <= high) {
        temp[k++] = array[right++]
    }

    for (i in temp.indices) {
        array[low + i] = temp[i]
    }
}
