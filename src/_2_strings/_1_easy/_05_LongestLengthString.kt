package _2_strings._1_easy

/**
 * _05_LongestLengthString.kt
 * Finds the longest word in a given sentence.
 */
fun main() {
    val sentence = "Hi I am a developer"

    println("--- Longest Word in Sentence ---")
    println("Sentence: \"$sentence\"")

    val longestWord = findLongestWord(sentence)
    println("Longest Word: \"$longestWord\" (Length: ${longestWord.length})")
}

fun findLongestWord(sentence: String): String {
    val words = sentence.trim().split("\\s+".toRegex())
    var longest = ""

    for (word in words) {
        if (word.length > longest.length) {
            longest = word
        }
    }

    return longest
}
