package _3_arrays._2_medium

/**
 * _09_EquilibriumPointInArray.kt
 * Finds the equilibrium index in an array where sum of lower indices equals sum of higher indices.
 *
 * Beginner Explanation:
 * Calculate total array sum.
 * Traverse the array keeping a `leftSum`. `rightSum = totalSum - leftSum - currentNum`.
 * If `leftSum == rightSum`, the current index is the equilibrium point!
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val array = intArrayOf(1, 6, 7, 0, 7)

    println("--- Equilibrium Point in Array ---")
    println("Input Array: ${array.joinToString(", ")}")

    val equilibriumIndex = findEquilibriumIndex(array)
    println("Equilibrium Index: $equilibriumIndex")
}

fun findEquilibriumIndex(array: IntArray): Int {
    var totalSum = array.sum()
    var leftSum = 0

    for ((index, num) in array.withIndex()) {
        totalSum -= num

        if (leftSum == totalSum) {
            return index
        }

        leftSum += num
    }

    return -1
}
