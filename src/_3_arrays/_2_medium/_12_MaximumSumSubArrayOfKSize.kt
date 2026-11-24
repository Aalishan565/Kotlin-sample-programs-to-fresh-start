package _3_arrays._2_medium

/**
 * _12_MaximumSumSubArrayOfKSize.kt
 * Finds the maximum sum of a contiguous subarray of fixed size K using Sliding Window.
 */
fun main() {
    val array = intArrayOf(10, 10, 10, 1, 2, 3, 4, 5, 6)

    println("--- Maximum Sum Subarray of Size K ---")
    println("Input Array: ${array.joinToString(", ")}")

    println("\nTest 1 (K = 4):")
    maxSumSubArray(array, 4)

    println("\nTest 2 (K = 3):")
    maxSumSubArray(array, 3)
}

private fun maxSumSubArray(array: IntArray, k: Int) {
    if (array.size < k || k <= 0) return

    var startIndex = 0
    var endIndex = 0
    var maxSum = Int.MIN_VALUE
    var runningSum = 0
    var bestStart = 0

    while (endIndex < array.size) {
        runningSum += array[endIndex]

        if (endIndex - startIndex + 1 == k) {
            if (runningSum > maxSum) {
                maxSum = runningSum
                bestStart = startIndex
            }
            runningSum -= array[startIndex]
            startIndex++
        }
        endIndex++
    }

    val maxSubarray = array.sliceArray(bestStart until (bestStart + k))
    println("Max sum is : $maxSum")
    println("Subarray of size $k: [${maxSubarray.joinToString(", ")}] (Indices $bestStart to ${bestStart + k - 1})")
}
