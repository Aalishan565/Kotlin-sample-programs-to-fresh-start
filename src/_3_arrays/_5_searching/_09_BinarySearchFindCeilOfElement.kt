package _3_arrays._5_searching

/**
 * _09_BinarySearchFindCeilOfElement.kt
 * Finds the Ceiling of an element in a sorted array (smallest element >= target).
 *
 * Beginner Explanation:
 * If target exists, return target.
 * Otherwise, the ceiling is the smallest element strictly greater than target.
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 4, 6, 7, 9)

    println("--- Ceiling of Element in Sorted Array ---")
    println("Sorted Array: ${array.joinToString(", ")}")

    for (target in listOf(5, 4, 10)) {
        val ceilIndex = findCeilIndex(array, target)
        if (ceilIndex != -1) {
            println("Target $target -> Ceiling: ${array[ceilIndex]} (Index $ceilIndex)")
        } else {
            println("Target $target -> No Ceiling exists in array.")
        }
    }
}

fun findCeilIndex(array: IntArray, target: Int): Int {
    if (array.isEmpty() || target > array[array.size - 1]) return -1

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

    return low
}
