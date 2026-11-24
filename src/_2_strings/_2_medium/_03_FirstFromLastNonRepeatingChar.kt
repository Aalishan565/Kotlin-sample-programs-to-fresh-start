package _2_strings._2_medium

/**
 * _03_FirstFromLastNonRepeatingChar.kt
 * Finds the first non-repeating character searching from the last/end of a string.
 */
fun main() {
    val input = "aalishan"

    println("--- First Non-Repeating Character From Right (End) ---")
    println("Input String: $input")

    val result = firstFromLastNonRepeatingChar(input)
    if (result != null) {
        println("First non-repeating char from right: '$result'")
    } else {
        println("No non-repeating character found.")
    }
}

fun firstFromLastNonRepeatingChar(inputString: String): Char? {
    val frequencyMap = HashMap<Char, Int>()

    for (char in inputString) {
        frequencyMap[char] = frequencyMap.getOrDefault(char, 0) + 1
    }

    // Traverse from right to left
    for (i in inputString.length - 1 downTo 0) {
        val char = inputString[i]
        if (frequencyMap[char] == 1) {
            return char
        }
    }

    return null
}
