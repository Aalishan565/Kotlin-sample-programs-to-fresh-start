package _3_arrays._3_hard

/**
 * _01_MaximumSumSubArray.kt
 * Finds the contiguous subarray with the largest sum using Kadane's Algorithm (LeetCode #53).
 */
fun main() {
    val testArrays = listOf(
        intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4),
        intArrayOf(5, 4, -1, 7, 8),
        intArrayOf(-1, -2, -3, -4)
    )

    println("--- Maximum Sum Subarray (Kadane's Algorithm) ---")
    for (arr in testArrays) {
        println("\nArray: ${arr.joinToString(", ")}")

        println("1. Using For-Loop:")
        maxSumSubArrayForLoop(arr)

        println("\n2. Using While-Loop:")
        maxSumSubArrayUsingWhileLoop(arr)
    }
}

private fun maxSumSubArrayForLoop(array: IntArray) {
    var maxSum = Int.MIN_VALUE
    var maxSumSoFar = 0
    var startIndex = 0
    var endIndex = 0
    var searchStartingOfSubArray = 0

    for (i in array.indices) {
        maxSumSoFar += array[i]
        if (maxSum < maxSumSoFar) {
            maxSum = maxSumSoFar
            startIndex = searchStartingOfSubArray
            endIndex = i
        }
        if (maxSumSoFar < 0) {
            maxSumSoFar = 0
            searchStartingOfSubArray = i + 1
        }
    }

    val subarray = array.sliceArray(startIndex..endIndex)
    println("  Max Sum: $maxSum | Indices: $startIndex to $endIndex | Subarray: [${subarray.joinToString(", ")}]")
}

private fun maxSumSubArrayUsingWhileLoop(array: IntArray) {
    var maxSum = Int.MIN_VALUE
    var maxSumSoFar = 0
    var startIndex = 0
    var endIndex = 0
    var startIndexOfSubArray = 0
    var endIndexOfSubArray = 0

    while (endIndex < array.size) {
        maxSumSoFar += array[endIndex]
        if (maxSum < maxSumSoFar) {
            maxSum = maxSumSoFar
            startIndexOfSubArray = startIndex
            endIndexOfSubArray = endIndex
        }
        if (maxSumSoFar < 0) {
            maxSumSoFar = 0
            startIndex = endIndex + 1
        }
        endIndex++
    }

    val subarray = array.sliceArray(startIndexOfSubArray..endIndexOfSubArray)
    println("  Max Sum: $maxSum | Indices: $startIndexOfSubArray to $endIndexOfSubArray | Subarray: [${subarray.joinToString(", ")}]")
}
