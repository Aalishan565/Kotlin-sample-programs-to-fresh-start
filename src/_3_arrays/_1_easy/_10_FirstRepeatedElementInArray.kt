package _3_arrays._1_easy

/**
 * _10_FirstRepeatedElementInArray.kt
 * Finds the first element in an array that repeats (occurs more than once) at the smallest index.
 */
fun main() {
    val array = intArrayOf(7, 2, 1, 2, 4, 5, 4)

    println("--- First Repeated Element ---")
    println("Input Array: ${array.joinToString(", ")}")

    val firstRepeated = findFirstRepeatedElement(array)
    if (firstRepeated != null) {
        println("First Repeated Element: $firstRepeated")
    } else {
        println("No repeated elements found.")
    }
}

fun findFirstRepeatedElement(array: IntArray): Int? {
    val seenSet = HashSet<Int>()
    var minIndex = -1

    // Traverse from right to left to record the leftmost repeated element index
    for (i in array.size - 1 downTo 0) {
        if (seenSet.contains(array[i])) {
            minIndex = i
        } else {
            seenSet.add(array[i])
        }
    }

    return if (minIndex != -1) array[minIndex] else null
}
