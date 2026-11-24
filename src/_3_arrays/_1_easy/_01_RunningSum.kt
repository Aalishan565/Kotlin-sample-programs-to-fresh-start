package _3_arrays._1_easy

/**
 * _01_RunningSum.kt
 * Calculates running sum / prefix sum of a 1D array (LeetCode #1480).
 *
 * Beginner Explanation:
 * - A "running sum" means each element at index `i` in the output array becomes the sum of all elements
 *   from index 0 up to index `i` in the original array.
 * - Example: Input [1, 2, 3, 4] -> Output [1, 1+2, 1+2+3, 1+2+3+4] = [1, 3, 6, 10].
 *
 * Time Complexity: O(N) - We loop through the array once.
 * Space Complexity: O(N) - We create an output array of size N to store running sums.
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5)

    println("--- Running Sum of 1D Array ---")
    println("Original Array: ${array.joinToString(", ")}")

    val runningSum = calculateRunningSum(array)
    println("Running Sum   : ${runningSum.joinToString(", ")}")
}

fun calculateRunningSum(array: IntArray): IntArray {
    // Edge case: if input array is empty, return an empty array
    if (array.isEmpty()) return intArrayOf()

    val result = IntArray(array.size)
    // The first element of running sum is always the first element of input array
    result[0] = array[0]

    // Iterate starting from index 1 to the end of array
    for (i in 1 until array.size) {
        // Current running sum = previous running sum + current array element
        result[i] = result[i - 1] + array[i]
    }

    return result
}
