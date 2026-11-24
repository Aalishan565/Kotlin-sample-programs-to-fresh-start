package _1_general._2_medium

/**
 * _05_ReverseAlphabet.kt
 * Reverses only alphabetic letters in a string while preserving special character positions.
 *
 * Example:
 *   Input:  "ab#,oQ,a@b"
 *   Output: "ba#,Qo,b@a"
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
fun main() {
    val input = "ab#,oQ,a@b"

    println("--- Reverse Alphabets Only ---")
    println("Original String: $input")
    println("Reversed String: ${reverseAlphabetTwoPointer(input)}")
}

fun reverseAlphabetTwoPointer(input: String): String {
    val inputCharArray = input.toCharArray()
    var startIndex = 0
    var endIndex = inputCharArray.size - 1

    while (startIndex < endIndex) {
        if (!inputCharArray[startIndex].isLetter()) {
            startIndex++
        } else if (!inputCharArray[endIndex].isLetter()) {
            endIndex--
        } else {
            val tempChar = inputCharArray[startIndex]
            inputCharArray[startIndex] = inputCharArray[endIndex]
            inputCharArray[endIndex] = tempChar
            startIndex++
            endIndex--
        }
    }
    return String(inputCharArray)
}
