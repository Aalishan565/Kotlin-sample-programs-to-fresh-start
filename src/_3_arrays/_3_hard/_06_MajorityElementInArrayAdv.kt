package _3_arrays._3_hard

/**
 * _06_MajorityElementInArrayAdv.kt
 * Finds majority element (> N/2 occurrences) using Boyer-Moore Voting Algorithm.
 *
 * Beginner Explanation:
 * Single-pass candidate selection with cancellation, followed by verification count.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val nums = intArrayOf(3, 3, 4, 2, 4, 4, 2, 4, 4)

    println("--- Majority Element (Boyer-Moore Algorithm) ---")
    println("Input Array: ${nums.joinToString(", ")}")

    val result = findMajorityElementBoyerMooreVal(nums)
    if (result != null) {
        println("Majority Element: $result")
    } else {
        println("No majority element found.")
    }
}

fun findMajorityElementBoyerMooreVal(nums: IntArray): Int? {
    if (nums.isEmpty()) return null

    var candidate = nums[0]
    var count = 1

    for (i in 1 until nums.size) {
        if (count == 0) {
            candidate = nums[i]
            count = 1
        } else if (candidate == nums[i]) {
            count++
        } else {
            count--
        }
    }

    val occurrences = nums.count { it == candidate }
    return if (occurrences > nums.size / 2) candidate else null
}
