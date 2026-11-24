package _3_arrays._1_easy

/**
 * _05_RemoveDuplicateFromSortedArray.kt
 * Removes duplicate elements from a sorted integer array in-place (LeetCode #26).
 *
 * Beginner Explanation:
 * - Since array is sorted, duplicates are adjacent to each other.
 * - Use two pointers: `readIndex` scans every element, `writeIndex` keeps track of unique elements.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1) Auxiliary Space
 */
fun main() {
    val givenArray = arrayOf(1, 1, 1, 2, 2, 2, 3, 3, 4)
    println("Original Array: ${givenArray.joinToString(", ")}")

    val result = removeDuplicatesFromSortedArray(givenArray)
    println("Unique Elements: ${result.joinToString(", ")}")
}

private fun removeDuplicatesFromSortedArray(inputArray: Array<Int>): Array<out Int?> {
    if (inputArray.size <= 1) return inputArray

    var readIndex = 1
    var writeIndex = 0

    while (readIndex < inputArray.size) {
        // When a new distinct value is found
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
