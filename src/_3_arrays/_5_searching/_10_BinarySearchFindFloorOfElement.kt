package _3_arrays._5_searching

/**
 * _10_BinarySearchFindFloorOfElement.kt
 * Finds the Floor of an element in a sorted array (largest element <= target).
 *
 * Beginner Explanation:
 * If target exists, return target.
 * Otherwise, the floor is the largest element strictly smaller than target.
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 4, 6, 7, 9)

    println("--- Floor of Element in Sorted Array ---")
    println("Sorted Array: ${array.joinToString(", ")}")

    for (target in listOf(5, 4, 0)) {
        val floorIndex = findFloorIndex(array, target)
        if (floorIndex != -1) {
            println("Target $target -> Floor: ${array[floorIndex]} (Index $floorIndex)")
        } else {
            println("Target $target -> No Floor exists in array.")
        }
    }
}

fun findFloorIndex(array: IntArray, target: Int): Int {
    if (array.isEmpty() || target < array[0]) return -1

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

    return high
}
