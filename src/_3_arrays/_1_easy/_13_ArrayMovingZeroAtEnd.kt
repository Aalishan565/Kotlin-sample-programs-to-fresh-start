package _3_arrays._1_easy

/**
 * _13_ArrayMovingZeroAtEnd.kt
 * Moves all zeroes to the end of the array while maintaining the relative order of non-zero elements (LeetCode #283).
 *
 * Beginner Explanation:
 * Use a read pointer `i` and write pointer `j`.
 * Whenever a non-zero element is encountered at `i`, swap it with position `j` and increment `j`.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val inputArray = arrayOf(1, 0, 1, 0, 0, 1, 0, 1, 0)
    println("Original Array: ${inputArray.joinToString(", ")}")

    moveAllZerosToEnd(inputArray)
    println("Moved Zeroes To End: ${inputArray.joinToString(", ")}")
}

private fun moveAllZerosToEnd(inputArray: Array<Int>): Array<Int> {
    var j = 0
    for (i in inputArray.indices) {
        if (inputArray[i] != 0 && inputArray[j] == 0) {
            val temp = inputArray[i]
            inputArray[i] = inputArray[j]
            inputArray[j] = temp
        }
        if (inputArray[j] != 0) {
            j++
        }
    }
    return inputArray
}
