package _1_general

/**
 * _4_PalindromeNumber.kt
 * Checks whether an integer is a Palindrome Number.
 *
 * Definition:
 * A number is a Palindrome if it reads the same forward and backward.
 *
 * Examples:
 *   - 121   -> Palindrome  (121 reversed is 121)
 *   - 12321 -> Palindrome  (12321 reversed is 12321)
 *   - 123   -> Not Palindrome (123 reversed is 321)
 *   - -121  -> Not Palindrome (Negative sign makes it -121 vs 121-)
 */
fun main() {
    val testNumbers = listOf(121, 12321, 123, -121, 10)

    println("--- Palindrome Number Checker ---")
    for (number in testNumbers) {
        val isPalindromeMath = isNumberPalindrome(number)
        val isPalindromeString = isNumberPalindromeString(number)
        println("Number: ${number.toString().padStart(6)} -> Palindrome? $isPalindromeMath (String check: $isPalindromeString)")
    }
}

/**
 * Approach 1: Idiomatic Kotlin (Most Human-Friendly & Readable)
 * Converts number to String and compares it with its reversed version.
 */
fun isNumberPalindromeString(input: Int): Boolean {
    if (input < 0) return false
    val text = input.toString()
    return text == text.reversed()
}

/**
 * Approach 2: Mathematical Reversal (No String Conversion, O(log10(N)) Time, O(1) Space)
 * Reverses digits mathematically using modulo `% 10` and division `/ 10`.
 */
fun isNumberPalindrome(input: Int): Boolean {
    // Negative numbers and numbers ending with 0 (except 0 itself) are not palindromes
    if (input < 0 || (input % 10 == 0 && input != 0)) return false

    var number = input
    var reversedNumber = 0

    while (number > 0) {
        val reminder = number % 10
        reversedNumber = (reversedNumber * 10) + reminder
        number /= 10
    }

    return input == reversedNumber
}
