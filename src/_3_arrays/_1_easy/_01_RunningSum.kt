package _3_arrays._1_easy

/**
 * _01_RunningSum.kt
 * Calculates running sum / prefix sum of a 1D array (LeetCode #1480).
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5)

    println("--- Running Sum of 1D Array ---")
    println("Original Array: ${array.joinToString(", ")}")

    val runningSum = calculateRunningSum(array)
    println("Running Sum   : ${runningSum.joinToString(", ")}")
}

fun calculateRunningSum(array: IntArray): IntArray {
    if (array.isEmpty()) return intArrayOf()

    val result = IntArray(array.size)
    result[0] = array[0]

    for (i in 1 until array.size) {
        result[i] = result[i - 1] + array[i]
    }

    return result
}
