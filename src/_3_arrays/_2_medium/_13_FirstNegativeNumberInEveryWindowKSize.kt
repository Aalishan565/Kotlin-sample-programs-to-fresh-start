package _3_arrays._2_medium

/**
 * _13_FirstNegativeNumberInEveryWindowKSize.kt
 * Finds the first negative integer in every contiguous sliding window of size K using ArrayDeque Queue.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(K)
 */
fun main() {
    val array = intArrayOf(10, -3, 10, -2, -1, 3, 2, 4, 5, 6)

    println("--- First Negative Integer in Every Window of Size K ---")
    println("Input Array: ${array.joinToString(", ")}")

    println("\nTest 1 (K = 4):")
    findNegativeNumbersInEveryWindowOfKSize(array, 4)

    println("\nTest 2 (K = 3):")
    findNegativeNumbersInEveryWindowOfKSize(array, 3)
}

private fun findNegativeNumbersInEveryWindowOfKSize(array: IntArray, k: Int) {
    if (array.size < k || k <= 0) return

    var startIndex = 0
    var endIndex = 0
    val negativeQueue = ArrayDeque<Int>()

    while (endIndex < array.size) {
        if (array[endIndex] < 0) {
            negativeQueue.addLast(array[endIndex])
        }

        if (endIndex - startIndex + 1 == k) {
            if (negativeQueue.isNotEmpty()) {
                val firstNegative = negativeQueue.first()
                println("Window [$startIndex..$endIndex] -> First negative: $firstNegative")

                if (array[startIndex] == firstNegative) {
                    negativeQueue.removeFirst()
                }
            } else {
                println("Window [$startIndex..$endIndex] -> First negative: 0")
            }
            startIndex++
        }
        endIndex++
    }
}
