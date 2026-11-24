package _3_arrays._5_searching

/**
 * _02_BinarySearchWithRecursion.kt
 * Recursive Binary Search on a sorted array.
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(log N) Call Stack
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 4, 6, 8, 9)
    val target = 9

    println("--- Binary Search (Recursive) ---")
    println("Sorted Array: ${array.joinToString(", ")}")

    val index = binarySearchRecursive(array, 0, array.size - 1, target)
    println("Target $target found at Index: $index")
}

fun binarySearchRecursive(array: IntArray, low: Int, high: Int, target: Int): Int {
    if (low > high) return -1

    val mid = low + (high - low) / 2
    return when {
        array[mid] == target -> mid
        array[mid] < target -> binarySearchRecursive(array, mid + 1, high, target)
        else -> binarySearchRecursive(array, low, mid - 1, target)
    }
}
