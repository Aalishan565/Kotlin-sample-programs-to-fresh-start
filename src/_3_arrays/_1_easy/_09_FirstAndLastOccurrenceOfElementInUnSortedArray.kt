package _3_arrays._1_easy

/**
 * _09_FirstAndLastOccurrenceOfElementInUnSortedArray.kt
 * Finds the first and last occurrence index of a target element in an unsorted array.
 */
fun main() {
    val array = intArrayOf(1, 2, 2, 2, 2, 6, 7, 8, 9, 10)
    val target = 2

    println("--- First and Last Occurrence of Target ($target) ---")
    println("Array: ${array.joinToString(", ")}")
    findFirstAndLastOccurrence(array, target)
}

fun findFirstAndLastOccurrence(array: IntArray, target: Int) {
    var first = -1
    var last = -1

    for ((index, num) in array.withIndex()) {
        if (num == target) {
            if (first == -1) {
                first = index
            }
            last = index
        }
    }

    if (first != -1) {
        println("First Occurrence = Index $first")
        println("Last Occurrence  = Index $last")
    } else {
        println("Target $target Not Found in Array")
    }
}
