package _5_queue._2_medium

import java.util.ArrayDeque

/**
 * _03_FirstNonRepeatingCharInStream.kt
 * Finds the first non-repeating character in a continuous character stream.
 *
 * Beginner Explanation:
 * Use a Queue to maintain order of character arrival and a frequency HashMap/IntArray.
 * If `frequency[queue.first()] > 1`, pop from queue until first non-repeating char is at queue front.
 *
 * Time Complexity: O(N) total across stream
 * Space Complexity: O(1) (26 alphabet characters)
 */
fun main() {
    val stream = "aabc"

    println("--- First Non-Repeating Character in Stream ---")
    println("Stream: $stream\n")

    val result = findFirstNonRepeatingInStream(stream)
    println("Resulting Stream First Unique Chars: \"$result\"")
}

fun findFirstNonRepeatingInStream(stream: String): String {
    val charCount = IntArray(26)
    val queue = ArrayDeque<Char>()
    val result = StringBuilder()

    for (ch in stream) {
        val index = ch - 'a'
        charCount[index]++
        queue.addLast(ch)

        // Pop elements from queue while they are repeating (count > 1)
        while (queue.isNotEmpty() && charCount[queue.first() - 'a'] > 1) {
            queue.removeFirst()
        }

        if (queue.isNotEmpty()) {
            result.append(queue.first())
        } else {
            result.append('#') // '#' indicates no non-repeating character available
        }
    }

    return result.toString()
}
