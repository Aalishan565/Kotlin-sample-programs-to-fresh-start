package _1_general._1_easy

/**
 * _04_PalindromeNumber.kt
 * Checks whether an integer is a Palindrome Number (reads same forward and backward).
 *
 * Examples:
 *   - 121   -> Palindrome  (121 reversed is 121)
 *   - 123   -> Not Palindrome (123 reversed is 321)
 *   - -121  -> Not Palindrome (Negative sign makes it -121 vs 121-)
 *
 * Time Complexity: O(log10 N)
 * Space Complexity: O(1) for Math, O(log10 N) for String
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

fun isNumberPalindromeString(input: Int): Boolean {
    if (input < 0) return false
    val text = input.toString()
    return text == text.reversed()
}

fun isNumberPalindrome(input: Int): Boolean {
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
