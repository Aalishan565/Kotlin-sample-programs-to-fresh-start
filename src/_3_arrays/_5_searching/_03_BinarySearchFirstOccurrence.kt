package _3_arrays._5_searching

/**
 * _03_BinarySearchFirstOccurrence.kt
 * Finds the first occurrence index of a target element in a sorted array containing duplicates.
 *
 * Beginner Explanation:
 * When `array[mid] == target`, record `result = mid` and continue searching left (`high = mid - 1`).
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 3, 4, 6, 6, 8, 9)
    val target = 6

    println("--- First Occurrence in Sorted Array ---")
    println("Sorted Array: ${array.joinToString(", ")}")

    val index = searchFirstOccurrence(array, target)
    println("First Occurrence of $target at Index: $index")
}

fun searchFirstOccurrence(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1
    var firstOccurrence = -1

    while (low <= high) {
        val mid = low + (high - low) / 2
        if (array[mid] == target) {
            firstOccurrence = mid
            high = mid - 1 // Keep searching left for earlier occurrence
        } else if (array[mid] < target) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return firstOccurrence
}
