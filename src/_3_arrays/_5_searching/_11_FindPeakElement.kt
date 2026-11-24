package _3_arrays._5_searching

/**
 * _11_FindPeakElement.kt
 * Finds a peak element in an array where `array[i] > array[i-1]` and `array[i] > array[i+1]` (LeetCode #162).
 *
 * Beginner Explanation:
 * Compare `array[mid]` with `array[mid + 1]`:
 * - If `array[mid] < array[mid + 1]`: we are on an ascending slope -> peak MUST lie to the right (`low = mid + 1`).
 * - Else: we are on a descending slope -> peak lies at `mid` or to the left (`high = mid`).
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
fun main() {
    val array1 = intArrayOf(1, 2, 3, 1)
    val array2 = intArrayOf(1, 2, 1, 3, 5, 6, 4)

    println("--- Find Peak Element ---")
    println("Test 1: Array = [${array1.joinToString(", ")}] -> Peak Index: ${findPeakElement(array1)}")
    println("Test 2: Array = [${array2.joinToString(", ")}] -> Peak Index: ${findPeakElement(array2)}")
}

fun findPeakElement(array: IntArray): Int {
    var low = 0
    var high = array.size - 1

    while (low < high) {
        val mid = low + (high - low) / 2
        if (array[mid] < array[mid + 1]) {
            low = mid + 1
        } else {
            high = mid
        }
    }

    return low
}
