package _3_arrays._1_easy

/**
 * _08_SearchInsertElementInSortedArray.kt
 * Finds the index of a target element in a sorted array, or the index where it would be inserted (LeetCode #35).
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
    return low
}
