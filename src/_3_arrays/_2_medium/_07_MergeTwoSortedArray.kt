package _3_arrays._2_medium

/**
 * _07_MergeTwoSortedArray.kt
 * Merges two sorted arrays into a single sorted array in O(N + M) time.
 */
fun main() {
    val array1 = intArrayOf(1, 2, 3, 4, 5, 6)
    val array2 = intArrayOf(2, 2, 3, 4, 5, 7)

    println("--- Merge Two Sorted Arrays ---")
    println("Array 1: ${array1.joinToString(", ")}")
    println("Array 2: ${array2.joinToString(", ")}")

    val merged = mergeArrays(array1, array2)
    println("Merged Array: ${merged.joinToString(", ")}")
}

fun mergeArrays(array1: IntArray, array2: IntArray): IntArray {
    val merged = IntArray(array1.size + array2.size)
    var left = 0
    var right = 0
    var k = 0

    while (left < array1.size && right < array2.size) {
        if (array1[left] <= array2[right]) {
            merged[k++] = array1[left++]
        } else {
            merged[k++] = array2[right++]
        }
    }

    while (left < array1.size) {
        merged[k++] = array1[left++]
    }

    while (right < array2.size) {
        merged[k++] = array2[right++]
    }

    return merged
}
