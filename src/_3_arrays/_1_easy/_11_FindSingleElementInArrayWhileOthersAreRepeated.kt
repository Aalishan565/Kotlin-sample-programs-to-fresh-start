package _3_arrays._1_easy

/**
 * _11_FindSingleElementInArrayWhileOthersAreRepeated.kt
 * Finds the single non-repeated element in an array where every other element appears twice (LeetCode #136).
 *
 * Beginner Explanation:
 * Uses Bitwise XOR (`xor`).
 * Properties of XOR:
 * - `X ^ X = 0` (Two identical numbers cancel each other out to 0).
 * - `X ^ 0 = X` (XORing any number with 0 leaves the number unchanged).
 * Therefore, XORing all array elements cancels all paired numbers, leaving only the single unique number!
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val array1 = intArrayOf(1, 2, 1, 2, 4, 5, 4)

    println("--- Single Number in Array (XOR Method) ---")
    println("Input Array: ${array1.joinToString(", ")}")

    val singleElement = findSingleElement(array1)
    println("Single Element: $singleElement")
}

fun findSingleElement(array: IntArray): Int {
    var result = 0
    for (num in array) {
        result = result xor num
    }
    return result
}
