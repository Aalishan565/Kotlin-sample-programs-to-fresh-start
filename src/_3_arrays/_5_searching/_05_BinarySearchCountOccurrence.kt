package _3_arrays._5_searching

/**
 * _05_BinarySearchCountOccurrence.kt
 * Counts total occurrences of a target element in a sorted array in O(log N) time.
 *
 * Beginner Explanation:
 * Total Count = `lastOccurrenceIndex - firstOccurrenceIndex + 1`.
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 3, 3, 4, 6, 8, 9)
    val target = 3

    println("--- Count Occurrences in Sorted Array ---")
    println("Sorted Array: ${array.joinToString(", ")}")

    val count = countOccurrences(array, target)
    println("Total Occurrences of $target: $count")
}

fun countOccurrences(array: IntArray, target: Int): Int {
    val first = searchFirstOccurrence(array, target)
    if (first == -1) return 0

    val last = searchLastOccurrence(array, target)
    return last - first + 1
}
