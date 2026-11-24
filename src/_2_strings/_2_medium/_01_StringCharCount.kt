package _2_strings._2_medium

/**
 * _01_StringCharCount.kt
 * Counts the frequency of each character in a string using HashMap.
 */
fun main() {
    val input = "aalishan"

    println("--- Character Frequency Count ---")
    println("Input String: $input")

    val frequencyMap = stringCharCount(input)
    println("Character Frequencies:")
    frequencyMap.forEach { (char, count) ->
        println("  '$char' -> $count")
    }
}

fun stringCharCount(inputString: String): Map<Char, Int> {
    val hashMap = LinkedHashMap<Char, Int>()
    for (char in inputString) {
        hashMap[char] = hashMap.getOrDefault(char, 0) + 1
    }
    return hashMap
}
