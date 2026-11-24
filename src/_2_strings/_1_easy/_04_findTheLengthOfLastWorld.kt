package _2_strings._1_easy

/**
 * _04_findTheLengthOfLastWorld.kt
 * Finds the length of the last word in a string (LeetCode #58).
 */
fun main() {
    val testCases = listOf("Hello world", "   fly me   to   the moon  ", "luffy is still joyboy")

    println("--- Length of Last Word ---")
    for (text in testCases) {
        val length = findTheLengthOfLastWord(text)
        println("Text: \"$text\" -> Length of last word: $length")
    }
}

fun findTheLengthOfLastWord(s: String): Int {
    val trimmed = s.trim()
    if (trimmed.isEmpty()) return 0

    var count = 0
    for (i in trimmed.length - 1 downTo 0) {
        if (trimmed[i] == ' ') {
            break
        }
        count++
    }

    return count
}
