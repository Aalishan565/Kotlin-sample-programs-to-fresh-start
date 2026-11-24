package _3_arrays._2_medium

/**
 * _18_ConsecutiveArrayLength.kt
 * Finds the length of the longest consecutive elements sequence in an unsorted array (LeetCode #128).
 *
 * Beginner Explanation:
 * Store elements in HashSet for O(1) lookup.
 * Only start a sequence length count if `num - 1` is NOT present in the set (ensuring `num` is the start of a sequence).
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
fun main() {
    val array = intArrayOf(2, 1, 5, 4, 7, 9, 8)

    println("--- Longest Consecutive Sequence Length ---")
    println("Input Array: ${array.joinToString(", ")}")

    val length = longestConsecutiveSequence(array)
    println("Longest Consecutive Sequence Length: $length")
}

fun longestConsecutiveSequence(array: IntArray): Int {
    val numSet = array.toHashSet()
    var longestStreak = 0

    for (num in numSet) {
        if (!numSet.contains(num - 1)) {
            var currentNum = num
            var currentStreak = 1

            while (numSet.contains(currentNum + 1)) {
                currentNum++
                currentStreak++
            }

            if (currentStreak > longestStreak) {
                longestStreak = currentStreak
            }
        }
    }

    return longestStreak
}
