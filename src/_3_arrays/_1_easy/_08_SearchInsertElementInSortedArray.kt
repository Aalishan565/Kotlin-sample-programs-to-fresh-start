package _3_arrays._1_easy

/**
 * _08_SearchInsertElementInSortedArray.kt
 * Finds the index of a target element in a sorted array using Binary Search,
 * or returns index where it should be inserted (LeetCode #35).
 *
 * Beginner Explanation:
 * Uses Binary Search O(log N) to repeatedly divide search space in half.
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 5)

    println("--- Search Insert Position ---")
    println("Sorted Array: ${array.joinToString(", ")}")

    for (target in listOf(5, 2, 4, 0, 6)) {
        val position = searchInsertPosition(array, target)
        println("Target $target -> Insert Position: $position")
    }
}

fun searchInsertPosition(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            array[mid] == target -> return mid
            array[mid] < target -> low = mid + 1
            else -> high = mid - 1
        }
    }
    // `low` represents the correct insertion index when not found
    return low
}
