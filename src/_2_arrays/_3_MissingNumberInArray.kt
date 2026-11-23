package _2_arrays

/**
 * _3_MissingNumberInArray.kt
 * Demonstrates finding missing and duplicate numbers in integer arrays.
 *
 * Problems Covered:
 * 1. Find Single Missing Number in range [1, N] (Distinct elements).
 * 2. Find Duplicate and Missing Number in range [1, N] (Contains 1 repeated & 1 missing).
 */
fun main() {
    println("--- 1. Single Missing Number (Distinct Elements) ---")
    val distinctArray = intArrayOf(1, 2, 4, 5, 6) // Range 1..6, missing 3
    println("Array: ${distinctArray.joinToString(", ")}")
    println("Missing Number (Sum Formula): ${findMissingNumberSumFormula(distinctArray)}")
    println("Missing Number (XOR Method) : ${findMissingNumberXor(distinctArray)}")

    println("\n--- 2. Duplicate & Missing Number ---")
    val arrayWithDuplicate =
        intArrayOf(1, 2, 3, 4, 5, 6, 6, 7, 8, 8, 10) // Size 10, duplicate 8, missing 9
    println("Array: ${arrayWithDuplicate.joinToString(", ")}")
    missingNumberWithRepeatedElement(arrayWithDuplicate)
}

/**
 * Problem 1 (Approach A): Gauss Sum Formula O(N) Time, O(1) Space
 * Sum of numbers 1 to N is: N * (N + 1) / 2
 * Missing = ExpectedSum - ActualSum
 */
fun findMissingNumberSumFormula(array: IntArray): Int {
    val n = array.size + 1
    val expectedSum = (n * (n + 1)) / 2
    val actualSum = array.sum()
    return expectedSum - actualSum
}

/**
 * Problem 1 (Approach B): Bitwise XOR O(N) Time, O(1) Space
 * Property: X ^ X = 0, X ^ 0 = X
 * Avoids potential integer overflow from large sums.
 */
fun findMissingNumberXor(array: IntArray): Int {
    val n = array.size + 1
    var xorAll = 0

    // XOR all numbers from 1 to N
    for (i in 1..n) {
        xorAll = xorAll xor i
    }

    // XOR all elements in the array
    for (num in array) {
        xorAll = xorAll xor num
    }

    return xorAll
}

/**
 * Problem 2: Find Duplicate and Missing Number
 * Finds the repeated element and missing element in range 1..N.
 * Uses HashMap/Frequency set O(N) Time, O(N) Space.
 */
private fun missingNumberWithRepeatedElement(inputArray: IntArray) {
    val numberMap: HashMap<Int, Boolean> = HashMap()
    val totalNumbers = inputArray.size
    inputArray.forEach { number ->
        if (numberMap[number] == null) {
            numberMap[number] = true
        } else {
            println("$number is duplicate")
        }
    }

    for (i in 1..<totalNumbers) {
        if (numberMap[i] == null) {
            println("$i is missing number")
        }
    }

}