package _1_general._1_easy

/**
 * _05_ReverseInteger.kt
 * Reverses the digits of a 32-bit signed integer (LeetCode #7).
 *
 * Edge Cases Handled:
 * 1. Negative numbers: e.g., -123 becomes -321.
 * 2. 32-bit Integer Overflow: Returns 0 if reversed integer exceeds [Int.MIN_VALUE, Int.MAX_VALUE].
 *
 * Time Complexity: O(log10 N)
 * Space Complexity: O(1)
 */
fun main() {
    val testNumbers = listOf(123, -123, 120, 1534236469)

    println("--- Reverse Integer ---")
    for (number in testNumbers) {
        val reversed = reverseInteger(number)
        println(
            "Input: ${number.toString().padStart(11)} -> Reversed (Math): ${
                reversed.toString().padStart(11)
            }"
        )
    }
}

fun reverseInteger(input: Int): Int {
    var number = input
    var reversedNumber = 0L

    while (number != 0) {
        val reminder = number % 10
        reversedNumber = (reversedNumber * 10) + reminder
        number /= 10
    }

    if (reversedNumber < Int.MIN_VALUE || reversedNumber > Int.MAX_VALUE) {
        return 0
    }

    return reversedNumber.toInt()
}
