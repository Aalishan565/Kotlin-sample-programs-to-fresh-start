package _3_arrays._2_medium

/**
 * _03_ArraySortingZeroOne.kt
 * Sorts a binary array containing only 0s and 1s in a single pass.
 *
 * Beginner Explanation:
 * Uses two pointers starting from opposite ends (`start` = 0, `end` = size-1) to swap 1s to the right and 0s to the left.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val inputArray = arrayOf(1, 0, 1, 0, 0, 1, 0, 1, 0)
    println("Original Binary Array: ${inputArray.joinToString(", ")}")

    sortArrayUsingPointers(inputArray)
    println("Sorted Binary Array  : ${inputArray.joinToString(", ")}")
}

private fun sortArrayUsingPointers(inputArray: Array<Int>): Array<Int> {
    var start = 0
    var end = inputArray.size - 1
    while (start < end) {
        if (inputArray[start] == 0 && inputArray[end] == 1) {
            start++
            end--
        } else if (inputArray[start] == 0) {
            start++
        } else if (inputArray[end] == 1) {
            end--
        } else {
            val temp = inputArray[start]
            inputArray[start] = inputArray[end]
            inputArray[end] = temp
            start++
            end--
        }
    }
    return inputArray
}
