package _3_arrays._5_searching

/**
 * _07_BinarySearchFindElementInSortedAndRotatedArray.kt
 * Searches for a target in a sorted and rotated array in O(log N) time (LeetCode #33).
 *
 * Beginner Explanation:
 * At least one half of the rotated array is always sorted.
 * Determine which half is sorted and check if target lies within that sorted range.
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(5, 6, 7, 1, 2, 3, 4)
    val target = 2

    println("--- Search in Rotated Sorted Array ---")
    println("Rotated Array: ${array.joinToString(", ")}")

    val index = searchRotatedSortedArray(array, target)
    println("Target $target found at Index: $index")
}

fun searchRotatedSortedArray(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2

        if (array[mid] == target) return mid

        if (array[low] <= array[mid]) {
            if (target >= array[low] && target < array[mid]) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        } else {
            if (target > array[mid] && target <= array[high]) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
    }

    return -1
}
