package _3_arrays._1_easy

/**
 * _03_SecondLargestInArray.kt
 * Finds the second largest distinct element in an array of integers.
 *
 * Examples:
 *   - [11, 3, 2, 5, 4, 9, 7, 8, 6, 10] -> 10
 *   - [10, 10, 10]                      -> null (no distinct second largest)
 *   - [-10, -5, -2, -8]                 -> -5
 *   - [5]                               -> null (fewer than 2 elements)
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
        println(
            "Array: ${
                arr.joinToString(", ").padStart(32)
            } -> Second Largest (O(N)): $resultOpt | (Functional): $resultKotlin"
        )
    }
}

/**
 * Approach 1: Single-Pass Optimal Algorithm (O(N) Time, O(1) Space)
 * Keeps track of `largest` and `secondLargest` in a single loop.
 * Returns null if no distinct second largest element exists.
 */
fun findSecondLargest(array: IntArray): Int? {
    if (array.size < 2) return null

    var largest: Int? = null
    var secondLargest: Int? = null

    for (num in array) {
        if (largest == null || num > largest) {
            secondLargest = largest
            largest = num
        } else if (num != largest && (secondLargest == null || num > secondLargest)) {
            secondLargest = num
        }
    }
    return secondLargest
}

/**
 * Approach 2: Idiomatic Kotlin Way (Short & Readable)
 * Filters distinct elements, sorts in descending order, and gets element at index 1.
 */
fun findSecondLargestFunctional(array: IntArray): Int? {
    return array.distinct().sortedDescending().getOrNull(1)
}
