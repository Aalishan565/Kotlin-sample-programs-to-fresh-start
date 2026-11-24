package _2_strings._2_medium

/**
 * _02_RemoveDuplicateFromString.kt
 * Removes duplicate characters from a string while maintaining original character order.
 */
fun main() {
    val input = "aalishan"

    println("--- Remove Duplicate Characters ---")
    println("Input String: $input")

    val resultString = removeDuplicateFromString(input)
    val resultKotlin = input.toList().distinct().joinToString("")

    println("1. Unique Chars Result : $resultString")
    println("2. Built-in distinct() : $resultKotlin")
}

fun removeDuplicateFromString(inputString: String): String {
    val sb = StringBuilder()
    val seenSet = HashSet<Char>()

    for (char in inputString) {
        if (seenSet.add(char)) {
            sb.append(char)
        }
    }

    return sb.toString()
}
