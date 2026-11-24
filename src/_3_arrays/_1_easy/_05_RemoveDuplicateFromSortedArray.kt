package _3_arrays._1_easy

/**
 * _05_RemoveDuplicateFromSortedArray.kt
 * Removes duplicate elements from a sorted integer array.
 *
 * Approaches:
 * 1. Two-Pointer In-Place Algorithm (LeetCode #26): O(N) Time, O(1) Space.
 */
fun main() {
    val givenArray = arrayOf(1, 1, 1, 2, 2, 2, 3, 3, 4)
    val result = removeDuplicatesFromSortedArray(givenArray)
    result.forEach {
        println(it)
    }
}

/**
 * Approach 1: Two-Pointer In-Place Algorithm (O(N) Time, O(1) Space)
 */
private fun removeDuplicatesFromSortedArray(inputArray: Array<Int>): Array<out Int?> {
    if (inputArray.size <= 2) {
        return inputArray
    }
    var readIndex = 1
    var writeIndex = 0
    while (readIndex < inputArray.size) {
        if (inputArray[writeIndex] != inputArray[readIndex]) {
            writeIndex++
            inputArray[writeIndex] = inputArray[readIndex]
        }
        readIndex++
    }
    val newArray = arrayOfNulls<Int>(writeIndex + 1)
    repeat(newArray.size) { index ->
        newArray[index] = inputArray[index]
    }
    return newArray
}
