package _3_arrays._2_medium

/**
 * _10_DifferenceBetweenGoodAndBadNumber.kt
 * Calculates difference between sum of "good" (matching) and "bad" (mismatched) elements after sorting.
 *
 * Time Complexity: O(N log N) due to sorting
 * Space Complexity: O(N)
 */
fun main() {
    val array = intArrayOf(0, 4, 0, 0, 1, 3, 4, 1, 0, 2)

    println("--- Difference Between Good and Bad Numbers ---")
    println("Original Array: ${array.joinToString(", ")}")

    val diff = calculateGoodBadDifference(array)
    println("Good Sum - Bad Sum = $diff")
}

fun calculateGoodBadDifference(array: IntArray): Int {
    val original = array.clone()
    val sorted = array.clone().apply { sort() }

    var goodSum = 0
    var badSum = 0

    for (i in original.indices) {
        if (original[i] == sorted[i]) {
            goodSum += original[i]
        } else {
            badSum += original[i]
        }
    }

    return goodSum - badSum
}
