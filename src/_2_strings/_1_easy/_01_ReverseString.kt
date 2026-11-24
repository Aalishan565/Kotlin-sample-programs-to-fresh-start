package _2_strings._1_easy

/**
 * _01_ReverseString.kt
 * Demonstrates various ways to reverse a string in Kotlin.
 *
 * Approaches:
 * 1. Two-Pointer In-Place Swap on CharArray (Optimal: O(N) Time, O(N) Space).
 * 2. Kotlin Standard Library Built-in (`.reversed()`).
 */
fun main() {
    val input = "aalishan"

    println("--- Reverse String ---")
    println("Original String: $input")

    val reversedSwap = reverseStringTwoPointer(input)
    val reversedBuiltIn = input.reversed()

    println("1. Two-Pointer Swap: $reversedSwap")
    println("2. Built-in reversed(): $reversedBuiltIn")
}

fun reverseStringTwoPointer(inputString: String): String {
    val chars = inputString.toCharArray()
    var startIndex = 0
    var endIndex = chars.size - 1

    while (startIndex < endIndex) {
        val temp = chars[startIndex]
        chars[startIndex] = chars[endIndex]
        chars[endIndex] = temp
        startIndex++
        endIndex--
    }

    return String(chars)
}
