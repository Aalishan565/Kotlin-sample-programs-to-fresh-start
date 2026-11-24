package _3_arrays._2_medium

/**
 * _14_ContinuesSubArrayToFindGivenSum.kt
 * Finds a contiguous subarray whose elements add up to a given target sum.
 *
 * Beginner Explanation:
 * - Two Pointers / Sliding Window: Expand right pointer to add, shrink left pointer when sum > target.
 * - Prefix Sum + Map: Handles negative numbers using running prefix sum lookup.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1) for Sliding Window, O(N) for Prefix Sum Map
 */
fun main() {
    val array1 = intArrayOf(1, 4, 20, 3, 10, 5)
    val target1 = 33

    val array2 = intArrayOf(1, 2, 3, 7, 5)
    val target2 = 12

    println("--- Continuous Subarray for Target Sum ---")

    println("Test 1 (Sliding Window For Loop): Array = ${array1.joinToString(", ")}, Target = $target1")
    val range1 = findSubarraySlidingWindow(array1, target1)
    printSubarrayResult(array1, range1)

    println("\nTest 2 (Sliding Window While Loop): Array = ${array1.joinToString(", ")}, Target = $target1")
    subArraySumWhileLoop(array1, target1)

    println("\nTest 3 (Sliding Window While Loop): Array = ${array2.joinToString(", ")}, Target = $target2")
    subArraySumWhileLoop(array2, target2)

    println("\nTest 4 (Prefix Sum Map): Array = ${array2.joinToString(", ")}, Target = $target2")
    val range2 = findSubarrayPrefixSum(array2, target2)
    printSubarrayResult(array2, range2)
}

fun findSubarraySlidingWindow(array: IntArray, targetSum: Int): IntRange? {
    var currentSum = 0
    var start = 0

    for (end in array.indices) {
        currentSum += array[end]

        while (currentSum > targetSum && start < end) {
            currentSum -= array[start]
            start++
        }

        if (currentSum == targetSum) {
            return start..end
        }
    }

    return null
}

private fun subArraySumWhileLoop(arr: IntArray, sum: Int) {
    var start = 0
    var end = 0
    var currentSum = 0
    while (end < arr.size) {
        currentSum += arr[end]
        while (currentSum > sum && start < end) {
            currentSum -= arr[start]
            start++
        }
        if (currentSum == sum) {
            println("Sub array found from index : $start to $end")
            return
        }
        end++
    }
    println("No sum found in the given array.")
}

fun findSubarrayPrefixSum(array: IntArray, targetSum: Int): IntRange? {
    var currentSum = 0
    val prefixSumMap = HashMap<Int, Int>()

    for (i in array.indices) {
        currentSum += array[i]

        if (currentSum == targetSum) {
            return 0..i
        }

        if (prefixSumMap.containsKey(currentSum - targetSum)) {
            val startIndex = prefixSumMap[currentSum - targetSum]!! + 1
            return startIndex..i
        }

        prefixSumMap[currentSum] = i
    }

    return null
}

private fun printSubarrayResult(array: IntArray, range: IntRange?) {
    if (range != null) {
        val subarray = array.sliceArray(range)
        println("  -> Subarray found from Index ${range.first} to ${range.last}: [${subarray.joinToString(", ")}]")
    } else {
        println("  -> No contiguous subarray found for target sum.")
    }
}
