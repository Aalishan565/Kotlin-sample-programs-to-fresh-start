package _1_general._1_easy

/**
 * _01_AlphabetTest.kt
 * Checks if a given character is an alphabetic letter ('a'..'z' or 'A'..'Z').
 *
 * Beginner Explanation:
 * In Kotlin, ranges like `'a'..'z'` check ASCII / Unicode code points.
 * `Char.isLetter()` is the idiomatic standard library way to check if a char is a letter.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
fun main() {
    val testChars = listOf('A', 'z', '1', '#', 'g')

    println("--- Alphabet Character Test ---")
    for (char in testChars) {
        val resultRange = isAlphabetRange(char)
        val resultBuiltIn = char.isLetter()
        println("Char: '$char' -> Is Alphabet? (Range Check): $resultRange | (isLetter()): $resultBuiltIn")
    }
}

fun isAlphabetRange(char: Char): Boolean {
    return char in 'a'..'z' || char in 'A'..'Z'
}
