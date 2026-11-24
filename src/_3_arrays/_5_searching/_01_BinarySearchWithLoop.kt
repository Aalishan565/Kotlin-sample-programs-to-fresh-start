package _3_arrays._5_searching

/**
 * _01_BinarySearchWithLoop.kt
 * Standard Iterative Binary Search on a sorted array.
 *
 * Beginner Explanation:
 * Repeatedly compares target element with middle element `mid`.
 * If target < mid, narrow search to left half (`high = mid - 1`).
 * If target > mid, narrow search to right half (`low = mid + 1`).
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 4, 6, 8, 9)
    val target = 9

    println("--- Binary Search (Iterative Loop) ---")
    println("Sorted Array: ${array.joinToString(", ")}")

    val index = binarySearchIterative(array, target)
    println("Target $target found at Index: $index")
}

fun binarySearchIterative(array: IntArray, target: Int): Int {
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
    return -1
}
