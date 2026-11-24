package _3_arrays._1_easy

/**
 * _14_ArrayMovingZeroAtBegning.kt
 * Moves all zeroes to the beginning of the array.
 *
 * Beginner Explanation:
 * Traverse array backwards (right to left) using read pointer `i` and write pointer `j`.
 * Swap non-zero elements toward the right end, pushing zeroes toward the left start.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val inputArray = arrayOf(1, 0, 1, 0, 0, 1, 0, 1, 0)
    println("Original Array: ${inputArray.joinToString(", ")}")

    moveAllZerosToBeginning(inputArray)
    println("Moved Zeroes To Beginning: ${inputArray.joinToString(", ")}")
}

private fun moveAllZerosToBeginning(inputArray: Array<Int>): Array<Int> {
    var j = inputArray.size - 1
    for (i in inputArray.size - 1 downTo 0) {
        if (inputArray[i] != 0 && inputArray[j] == 0) {
            val temp = inputArray[j]
            inputArray[j] = inputArray[i]
            inputArray[i] = temp
        }
        if (inputArray[j] != 0) {
            j--
        }
    }
    return inputArray
}
