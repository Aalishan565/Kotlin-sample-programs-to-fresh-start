package _3_arrays._1_easy

/**
 * _06_RemoveAllOccurrenceOfGivenNumberInArray.kt
 * Removes all occurrences of a specific target number from an array.
 *
 * Beginner Explanation:
 * Iterate through the array and copy non-target elements forward into the write index position.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1) Extra Space
 */
fun main() {
    val numberToRemove = 4
    val givenArray = arrayOf(1, 2, 2, 2, 3, 3, 4)

    println("Original Array: ${givenArray.joinToString(", ")}")
    println("Removing target value: $numberToRemove")

    val result = removeNumberReturnArray(givenArray, numberToRemove)
    println("Resulting Array: ${result.joinToString(", ")}")
}

private fun removeNumberReturnArray(array: Array<Int>, number: Int): Array<Int?> {
    var index = 0
    for (i in array.indices) {
        // Copy element only if it does not match target number
        if (array[i] != number) {
            array[index] = array[i]
            index++
        }
    }
    return array.copyOf(index)
}
