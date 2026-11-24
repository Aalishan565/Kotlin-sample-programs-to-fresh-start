package _2_strings._2_medium

/**
 * _05_LongestCommonPrefixInStringArray.kt
 * Finds the longest common prefix among an array of strings (LeetCode #14).
 */
fun main() {
    val testArrays = listOf(
        arrayOf("cloth", "clove", "clock", "clob"),
        arrayOf("flower", "flow", "flight"),
        arrayOf("dog", "racecar", "car")
    )

    println("--- Longest Common Prefix ---")
    for (arr in testArrays) {
        val prefix = findLongestCommonPrefixInStringArray(arr)
        println("Array: [${arr.joinToString(", ")}] -> Common Prefix: \"$prefix\"")
    }
}

fun findLongestCommonPrefixInStringArray(givenStringsArray: Array<String>): String {
    if (givenStringsArray.isEmpty()) return ""
    if (givenStringsArray.size == 1) return givenStringsArray[0]

    // Sort array so that lexicographically smallest and largest strings are at ends
    val sorted = givenStringsArray.copyOf().apply { sort() }

    val first = sorted[0]
    val last = sorted[sorted.size - 1]
    val sb = StringBuilder()

    for (i in 0 until minOf(first.length, last.length)) {
        if (first[i] == last[i]) {
            sb.append(first[i])
        } else {
            break
        }
    }

    return sb.toString()
}
