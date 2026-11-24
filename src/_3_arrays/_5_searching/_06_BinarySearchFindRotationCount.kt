package _3_arrays._5_searching

/**
 * _06_BinarySearchFindRotationCount.kt
 * Finds the number of times a sorted array has been rotated (Find Minimum in Rotated Sorted Array - LeetCode #153).
 *
 * Beginner Explanation:
 * The rotation count equals the index of the minimum element (the pivot).
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(5, 6, 7, 1, 2, 3, 4)

    println("--- Find Rotation Count in Rotated Sorted Array ---")
    println("Rotated Array: ${array.joinToString(", ")}")

    val count = findRotationCount(array)
    println("Array Rotated Count: $count")
}

fun findRotationCount(array: IntArray): Int {
    var low = 0
    var high = array.size - 1

    while (low <= high) {
        if (array[low] <= array[high]) return low

        val mid = low + (high - low) / 2
        val next = (mid + 1) % array.size
        val prev = (mid - 1 + array.size) % array.size

        if (array[mid] <= array[next] && array[mid] <= array[prev]) {
            return mid
        }

        if (array[low] <= array[mid]) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return 0
}
