package _3_arrays._2_medium

/**
 * _16_FindTheLargestSubStringWhoseSizeIsK.kt
 * Finds the largest substring containing exactly K unique characters.
 */
fun main() {
    val str1 = "aabacbebebexyz123"
    val str2 = "eceba"

    println("--- Largest Substring With Exactly K Unique Characters ---")

    println("Test 1: String = \"$str1\", K = 3")
    findLargestSubStringSizeK(str1, 3)

    println("\nTest 2: String = \"$str2\", K = 2")
    findLargestSubStringSizeK(str2, 2)
}

private fun findLargestSubStringSizeK(givenString: String, k: Int) {
    var startIndex = 0
    var endIndex = 0
    var largestSubStringSize = 0
    var startIndexOfLargestSubString = 0
    var endIndexOfLargestSubString = 0
    val charFrequencyMap = HashMap<Char, Int>()

    while (endIndex < givenString.length) {
        val ch = givenString[endIndex]
        charFrequencyMap[ch] = charFrequencyMap.getOrDefault(ch, 0) + 1

        while (charFrequencyMap.size > k) {
            val startChar = givenString[startIndex]
            val count = charFrequencyMap.getOrDefault(startChar, 0)
            if (count == 1) {
                charFrequencyMap.remove(startChar)
            } else {
                charFrequencyMap[startChar] = count - 1
            }
            startIndex++
        }

        if (charFrequencyMap.size == k) {
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
    println("Largest substring size: $largestSubStringSize | Indices: $startIndexOfLargestSubString to $endIndexOfLargestSubString | Substring: \"$substring\"")
}
