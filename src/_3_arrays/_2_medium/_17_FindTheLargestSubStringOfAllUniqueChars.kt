package _3_arrays._2_medium

/**
 * _17_FindTheLargestSubStringOfAllUniqueChars.kt
 * Finds the length and content of the longest substring with all unique characters (no duplicate characters).
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
fun main() {
    val str1 = "abccdd"
    val str2 = "abcabcbb"

    println("--- Longest Substring With All Unique Characters ---")

    println("Test 1: String = \"$str1\"")
    findLargestSubStringAllUniqueChars(str1)

    println("\nTest 2: String = \"$str2\"")
    findLargestSubStringAllUniqueChars(str2)
}

private fun findLargestSubStringAllUniqueChars(givenString: String) {
    var startIndex = 0
    var endIndex = 0
    var largestSubStringSize = 0
    var startIndexOfLargestSubString = 0
    var endIndexOfLargestSubString = 0
    val charFrequencyMap = HashMap<Char, Int>()

    while (endIndex < givenString.length) {
        val ch = givenString[endIndex]
        charFrequencyMap[ch] = charFrequencyMap.getOrDefault(ch, 0) + 1

        while (charFrequencyMap.size < (endIndex - startIndex + 1)) {
            val startChar = givenString[startIndex]
            val count = charFrequencyMap.getOrDefault(startChar, 0)
            if (count == 1) {
                charFrequencyMap.remove(startChar)
            } else {
                charFrequencyMap[startChar] = count - 1
            }
            startIndex++
        }

        if (charFrequencyMap.size == (endIndex - startIndex + 1)) {
            val currentSize = endIndex - startIndex + 1
            if (largestSubStringSize < currentSize) {
                largestSubStringSize = currentSize
                startIndexOfLargestSubString = startIndex
                endIndexOfLargestSubString = endIndex
            }
        }
        endIndex++
    }

    val substring = if (largestSubStringSize > 0) givenString.substring(startIndexOfLargestSubString, endIndexOfLargestSubString + 1) else ""
    println("Largest unique substring size: $largestSubStringSize | Indices: $startIndexOfLargestSubString to $endIndexOfLargestSubString | Substring: \"$substring\"")
}
