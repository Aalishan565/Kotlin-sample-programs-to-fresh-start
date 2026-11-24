package _3_arrays._5_searching

/**
 * _04_BinarySearchLastOccurrence.kt
 * Finds the last occurrence index of a target element in a sorted array containing duplicates.
 *
 * Beginner Explanation:
 * When `array[mid] == target`, record `result = mid` and continue searching right (`low = mid + 1`).
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 3, 3, 4, 6, 8, 9)
    val target = 3

    println("--- Last Occurrence in Sorted Array ---")
    println("Sorted Array: ${array.joinToString(", ")}")

    val index = searchLastOccurrence(array, target)
    println("Last Occurrence of $target at Index: $index")
}

fun searchLastOccurrence(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1
    var lastOccurrence = -1

    while (low <= high) {
        val mid = low + (high - low) / 2
        if (array[mid] == target) {
            lastOccurrence = mid
            low = mid + 1 // Keep searching right for later occurrence
        } else if (array[mid] < target) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return lastOccurrence
}
