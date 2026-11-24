package _3_arrays._2_medium

/**
 * _01_PairOfNumbersOfGivenSum.kt
 * Finds pairs of numbers in an array that add up to a target sum (Two Sum - LeetCode #1).
 *
 * Beginner Explanation:
 * - HashMap Approach: For each number `x`, check if `target - x` exists in the map.
 * - Two-Pointer Approach (for sorted array): Use `left` and `right` pointers moving inward based on comparison with target.
 *
 * Time Complexity:
 * - HashMap: O(N) Time, O(N) Space
 * - Two Pointers: O(N) Time, O(1) Space (if sorted)
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5, 7, 8, 9)
    val targetSum = 10

    println("--- Pair of Numbers for Given Sum ($targetSum) ---")
    println("Using HashMap:")
    pairUsingHash(array, targetSum)

    println("\nUsing Two Pointers (Sorted Array):")
    pairUsingTwoPointers(array, targetSum)
}

fun pairUsingHash(array: IntArray, sum: Int) {
    val map = HashMap<Int, Int>() // value -> index
    for ((index, num) in array.withIndex()) {
        val complement = sum - num
        if (map.containsKey(complement)) {
            val complementIndex = map[complement]!!
            println("Found Pair: ${array[complementIndex]} + $num = $sum (Indices $complementIndex and $index)")
            return
        }
        map[num] = index
    }
    println("No matching pair found.")
}

fun pairUsingTwoPointers(array: IntArray, sum: Int): Boolean {
    var left = 0
    var right = array.size - 1

    while (left < right) {
        val currentSum = array[left] + array[right]
        when {
            currentSum == sum -> {
                println("Found Pair: ${array[left]} + ${array[right]} = $sum (Indices $left and $right)")
                return true
            }
            currentSum < sum -> left++
            else -> right--
        }
    }
    println("No matching pair found.")
    return false
}
