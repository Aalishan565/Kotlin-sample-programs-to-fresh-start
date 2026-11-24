package _3_arrays._1_easy

/**
 * _16_PrintOnlyDuplicateElementOnce.kt
 * Finds and prints only duplicate elements from an array exactly ONCE,
 * even if a duplicate element appears 3 or more times.
 *
 * Examples:
 *   - Input: [1, 2, 3, 2, 4, 3, 5, 2, 1, 6] -> Duplicates: [1, 2, 3]
 */
fun main() {
    val testArrays = listOf(
        intArrayOf(1, 2, 3, 2, 4, 3, 5, 2, 1, 6),
        intArrayOf(5, 5, 5, 5)
    )

    println("--- Print Only Duplicate Elements Once ---")
    for (arr in testArrays) {
        println("\nArray: ${arr.joinToString(", ")}")

        val duplicatesHashSet = findDuplicatesHashSet(arr)
        val duplicatesSorting = findDuplicatesSorting(arr)

        println("  -> HashSet (O(N) Time)   : $duplicatesHashSet")
        println("  -> Sorting (O(N log N))  : $duplicatesSorting")
    }
}

/**
 * Approach 1: Using Two Sets (Optimal: O(N) Time, O(N) Space)
 * Uses a `seen` set to track numbers and a `duplicates` set to store duplicates once.
 */
fun findDuplicatesHashSet(array: IntArray): Set<Int> {
    val seen = HashSet<Int>()
    val duplicates = LinkedHashSet<Int>() // Preserves insertion order

    for (num in array) {
        if (!seen.add(num)) {
            duplicates.add(num)
        }
    }

    return duplicates
}

/**
 * Approach 2: Sorting Approach (O(N log N) Time, O(1) Extra Space)
 * Sorts the array first and checks adjacent elements.
 */
fun findDuplicatesSorting(array: IntArray): List<Int> {
    if (array.size < 2) return emptyList()

    val sorted = array.sortedArray()
    val duplicates = mutableListOf<Int>()

    for (i in 0 until sorted.size - 1) {
        if (sorted[i] == sorted[i + 1]) {
            if (duplicates.isEmpty() || duplicates.last() != sorted[i]) {
                duplicates.add(sorted[i])
            }
        }
    }

    return duplicates
}
