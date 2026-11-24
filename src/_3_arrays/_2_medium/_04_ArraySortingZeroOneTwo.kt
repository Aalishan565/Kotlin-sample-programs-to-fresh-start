package _3_arrays._2_medium

/**
 * _04_ArraySortingZeroOneTwo.kt
 * Sorts an array of 0s, 1s, and 2s in a single pass using the Dutch National Flag Algorithm (LeetCode #75).
 *
 * Beginner Explanation:
 * Maintains 3 pointers: `firstPointer` (boundary for 0s), `mid` (current element), and `lastPointer` (boundary for 2s).
 * - If element is 0: swap with `firstPointer`, increment both `firstPointer` and `mid`.
 * - If element is 1: increment `mid`.
 * - If element is 2: swap with `lastPointer`, decrement `lastPointer`.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val inputArray = arrayOf(1, 2, 0, 1, 0, 2, 0, 1, 2, 0, 1, 2, 0)
    println("Original Array: ${inputArray.joinToString(", ")}")

    sortArrayUsingDutchNationalFlagApproach(inputArray)
    println("Sorted Array  : ${inputArray.joinToString(", ")}")
}

private fun sortArrayUsingDutchNationalFlagApproach(inputArray: Array<Int>): Array<Int> {
    var firstPointer = 0
    var lastPointer = inputArray.size - 1
    var mid = firstPointer
    while (mid <= lastPointer) {
        when (inputArray[mid]) {
            0 -> {
                if (inputArray[mid] != inputArray[firstPointer]) {
                    val temp = inputArray[mid]
                    inputArray[mid] = inputArray[firstPointer]
                    inputArray[firstPointer] = temp
                }
                firstPointer++
                mid++
            }
            1 -> {
                mid++
            }
            2 -> {
                if (inputArray[mid] != inputArray[lastPointer]) {
                    val temp = inputArray[mid]
                    inputArray[mid] = inputArray[lastPointer]
                    inputArray[lastPointer] = temp
                }
                lastPointer--
            }
        }
    }
    return inputArray
}
