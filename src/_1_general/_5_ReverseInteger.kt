package _1_general

/**
 * _5_ReverseInteger.kt
 * Reverses the digits of a 32-bit signed integer.
 *
 * Edge Cases Handled:
 * 1. Negative numbers: e.g., -123 becomes -321.
 * 2. Trailing zeros: e.g., 120 becomes 21.
 * 3. 32-bit Integer Overflow: If reversing the integer causes overflow beyond [Int.MIN_VALUE, Int.MAX_VALUE], return 0.
 *
 * Examples:
 *   - Input: 123        -> Output: 321
 *   - Input: -123       -> Output: -321
 *   - Input: 120        -> Output: 21
 *   - Input: 1534236469 -> Output: 0 (Overflows 32-bit Int)
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

/**
 * Approach 1: Mathematical Loop (O(log10 N) Time, O(1) Space)
 * Uses `number != 0` so it works for both positive and negative numbers.
 * Accumulates result into a 64-bit `Long` to detect 32-bit `Int` overflow cleanly.
 */
fun reverseInteger(input: Int): Int {
    var number = input
    var reversedNumber = 0L

    while (number != 0) {
        val reminder = number % 10
        reversedNumber = (reversedNumber * 10) + reminder
        number /= 10
    }
    // Return 0 if the reversed number overflows 32-bit signed Int range
    if (reversedNumber < Int.MIN_VALUE || reversedNumber > Int.MAX_VALUE) {
        return 0
    }
    return reversedNumber.toInt()
}