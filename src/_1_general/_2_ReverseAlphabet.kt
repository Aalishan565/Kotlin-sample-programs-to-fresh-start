package _1_general

/**
 * _2_ReverseAlphabet.kt
 * Reverses only alphabetic letters in a string while keeping all special characters in their original positions.
 * Example:
 *   Input:  "ab#,oQ,a@b"
 *   Output: "ba#,Qo,b@a"
 */
fun main() {
    val input = "ab#,oQ,a@b"
    println("Original String:    $input")
    println(" Two-Pointer Way:  ${reverseAlphabetTwoPointer(input)}")
}

/**
 *Two-Pointer Approach (Most Efficient: O(N) time, single pass)
 * - Uses left and right pointers moving inward to swap letters in-place.
 */
private fun reverseAlphabetTwoPointer(input: String): String {
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
