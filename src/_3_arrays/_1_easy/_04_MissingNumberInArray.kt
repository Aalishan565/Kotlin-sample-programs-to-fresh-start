package _3_arrays._1_easy

/**
 * _04_MissingNumberInArray.kt
 * Demonstrates finding missing and duplicate numbers in integer arrays.
 *
 * Beginner Explanation:
 * - Gauss Formula: Total sum of numbers from 1 to N is `N * (N + 1) / 2`.
 *   Subtracting actual array sum gives the missing number.
 * - Bitwise XOR: `X ^ X = 0` and `X ^ 0 = X`. XORing 1..N with array elements cancels duplicates, leaving missing number.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    println("--- 1. Single Missing Number (Distinct Elements) ---")
    val distinctArray = intArrayOf(1, 2, 4, 5, 6) // Range 1..6, missing 3
    println("Array: ${distinctArray.joinToString(", ")}")
    println("Missing Number (Sum Formula): ${findMissingNumberSumFormula(distinctArray)}")
    println("Missing Number (XOR Method) : ${findMissingNumberXor(distinctArray)}")

    println("\n--- 2. Duplicate & Missing Number ---")
    val arrayWithDuplicate = intArrayOf(1, 2, 3, 4, 5, 6, 6, 7, 8, 8, 10)
    println("Array: ${arrayWithDuplicate.joinToString(", ")}")
    missingNumberWithRepeatedElement(arrayWithDuplicate)
}

fun findMissingNumberSumFormula(array: IntArray): Int {
    val n = array.size + 1
    val expectedSum = (n * (n + 1)) / 2
    val actualSum = array.sum()
    return expectedSum - actualSum
}

fun findMissingNumberXor(array: IntArray): Int {
    val n = array.size + 1
    var xorAll = 0

    // XOR numbers 1 to N
    for (i in 1..n) {
        xorAll = xorAll xor i
    }

    // XOR array elements
    for (num in array) {
        xorAll = xorAll xor num
    }

    return xorAll
}

private fun missingNumberWithRepeatedElement(inputArray: IntArray) {
    val numberMap: HashMap<Int, Boolean> = HashMap()
    val totalNumbers = inputArray.size

    inputArray.forEach { number ->
        if (numberMap[number] == null) {
            numberMap[number] = true
        } else {
            println("Duplicate number found: $number")
        }
    }

    for (i in 1..<totalNumbers) {
        if (numberMap[i] == null) {
            println("Missing number found  : $i")
        }
    }
}
