package _3_arrays._1_easy

/**
 * _11_FindSingleElementInArrayWhileOthersAreRepeated.kt
 * Finds the single element in an array where every other element appears twice using Bitwise XOR.
 */
fun main() {
    val array1 = intArrayOf(1, 2, 1, 2, 4, 5, 4)

    println("--- Single Number in Array (XOR Method) ---")
    println("Input Array: ${array1.joinToString(", ")}")

    val singleElement = findSingleElement(array1)
    println("Single Element: $singleElement")
}

fun findSingleElement(array: IntArray): Int {
    var result = 0
    for (num in array) {
        result = result xor num
    }
    return result
}
