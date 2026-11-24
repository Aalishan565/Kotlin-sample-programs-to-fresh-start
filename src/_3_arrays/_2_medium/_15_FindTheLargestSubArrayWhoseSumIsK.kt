package _3_arrays._2_medium

/**
 * _15_FindTheLargestSubArrayWhoseSumIsK.kt
 * Finds the length and indices of the largest contiguous subarray whose elements sum up to K.
 */
fun main() {
    val array1 = intArrayOf(4, 1, 1, 1, 3, 5)
    val array2 = intArrayOf(1, 2, 3, 4, 5)

    println("--- Largest Subarray Whose Sum is K ---")

    println("Test 1: Array = ${array1.joinToString(", ")}, K = 5")
    findLargestSubArrayWithSumK(array1, 5)

    println("\nTest 2: Array = ${array2.joinToString(", ")}, K = 9")
    findLargestSubArrayWithSumK(array2, 9)
}

private fun findLargestSubArrayWithSumK(array: IntArray, k: Int) {
    var startIndex = 0
    var endIndex = 0
    var currentSum = 0
    var largestSubArraySize = 0
    var startIndexOfLargestSum = 0
    var endIndexOfLargestSum = 0

    while (endIndex < array.size) {
        currentSum += array[endIndex]

        while (currentSum > k && startIndex <= endIndex) {
            currentSum -= array[startIndex]
            startIndex++
        }

        if (currentSum == k) {
            val currentSize = endIndex - startIndex + 1
            if (largestSubArraySize < currentSize) {
                largestSubArraySize = currentSize
                startIndexOfLargestSum = startIndex
                endIndexOfLargestSum = endIndex
            }
        }
        endIndex++
    }

    val subarray = if (largestSubArraySize > 0) array.sliceArray(startIndexOfLargestSum..endIndexOfLargestSum) else intArrayOf()
    println("Largest subarray size: $largestSubArraySize | Indices: $startIndexOfLargestSum to $endIndexOfLargestSum | Subarray: [${subarray.joinToString(", ")}]")
}
