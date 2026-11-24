package _2_strings._1_easy

/**
 * _03_ReverseStringSentence.kt
 * Reverses the order of words in a sentence (e.g. "Hi I am doing practice" -> "practice doing am I Hi").
 */
fun main() {
    val sentence = "Hi I am doing practice"

    println("--- Reverse Words in Sentence ---")
    println("Original Sentence: \"$sentence\"")

    val reversedWords = reverseSentenceWords(sentence)
    println("Reversed Sentence: \"$reversedWords\"")
}

fun reverseSentenceWords(input: String): String {
    val words = input.trim().split("\\s+".toRegex())
    return words.reversed().joinToString(" ")
}
