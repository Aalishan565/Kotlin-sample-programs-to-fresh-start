package _3_arrays._4_sorting

/**
 * _03_InsertionSort.kt
 * Sorts an array using the Insertion Sort algorithm.
 *
 * Beginner Explanation:
 * Builds sorted array one element at a time, similar to sorting playing cards in hand.
 * Takes current element `key` and shifts larger elements one position to the right.
 *
 * Time Complexity: O(N^2) Worst/Average, O(N) Best Case
 * Space Complexity: O(1) Auxiliary Space
 */
fun main() {
    val array = intArrayOf(5, 3, 4, 2, 1)

    println("--- Insertion Sort ---")
    println("Original Array: ${array.joinToString(", ")}")

    insertionSort(array)
    println("Sorted Array  : ${array.joinToString(", ")}")
}

fun insertionSort(array: IntArray) {
    val n = array.size

    for (i in 1 until n) {
        val key = array[i]
        var j = i - 1

        // Move elements greater than key one position ahead
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j]
            j--
        }
        array[j + 1] = key
    }
}
