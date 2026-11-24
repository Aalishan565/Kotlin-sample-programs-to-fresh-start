package _2_strings._1_easy

/**
 * _02_StringPalindrome.kt
 * Checks if a string is a palindrome (reads the same forward and backward).
 */
fun main() {
    val testStrings = listOf("aba", "racecar", "hello", "Aba")

    println("--- String Palindrome Check ---")
    for (str in testStrings) {
        val isPalindromeTwoPointer = isStringPalindrome(str)
        val isPalindromeBuiltIn = str.equals(str.reversed(), ignoreCase = true)
        println("String: \"$str\" -> Palindrome (Exact): $isPalindromeTwoPointer | (IgnoreCase): $isPalindromeBuiltIn")
    }
}

fun isStringPalindrome(inputString: String): Boolean {
    var startIndex = 0
    var endIndex = inputString.length - 1

    while (startIndex <= endIndex) {
        if (inputString[startIndex] != inputString[endIndex]) {
            return false
        }
        startIndex++
        endIndex--
    }

    return true
}
