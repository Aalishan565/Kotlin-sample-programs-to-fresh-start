package _3_arrays._1_easy

/**
 * _03_SecondLargestInArray.kt
 * Finds the second largest distinct element in an array of integers.
 *
 * Beginner Explanation:
 * - We track two variables: `largest` and `secondLargest`.
 * - For every number:
 *   - If number > largest: current largest becomes secondLargest, and number becomes new largest.
 *   - Else if number < largest AND number > secondLargest: number becomes new secondLargest.
 *
 * Time Complexity: O(N) - Single pass loop.
 * Space Complexity: O(1) - Constant auxiliary space.
 */
fun main() {
    val testArrays = listOf(
        intArrayOf(11, 3, 2, 5, 4, 9, 7, 8, 6, 10),
        intArrayOf(10, 10, 10),
        intArrayOf(-10, -5, -2, -8),
        intArrayOf(5)
    )

    println("--- Find Second Largest Element ---")
    for (arr in testArrays) {
        val resultOpt = findSecondLargest(arr)
        val resultKotlin = findSecondLargestFunctional(arr)
        println("Array: ${arr.joinToString(", ").padStart(32)} -> Second Largest: $resultOpt | (Functional): $resultKotlin")
    }
}

/**
 * Single-Pass Optimal Algorithm (O(N) Time, O(1) Space)
 */
fun findSecondLargest(array: IntArray): Int? {
    // Need at least 2 elements to have a second largest
    if (array.size < 2) return null

    var largest: Int? = null
    var secondLargest: Int? = null

    for (num in array) {
        if (largest == null || num > largest) {
            // New largest found; old largest shifts to secondLargest
            secondLargest = largest
            largest = num
        } else if (num != largest && (secondLargest == null || num > secondLargest)) {
            // Number is smaller than largest but greater than current secondLargest
            secondLargest = num
        }
    }
    return secondLargest
}

/**
 * Idiomatic Kotlin Way
 */
fun findSecondLargestFunctional(array: IntArray): Int? {
    return array.distinct().sortedDescending().getOrNull(1)
}
