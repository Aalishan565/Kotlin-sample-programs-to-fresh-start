package _3_arrays._1_easy

/**
 * _16_PrintOnlyDuplicateElementOnce.kt
 * Finds and prints only duplicate elements from an array exactly ONCE,
 * even if a duplicate element appears 3 or more times.
 *
 * Beginner Explanation:
 * Use a `seen` set to track seen numbers.
 * When `!seen.add(num)` is true (number already seen), add it to `duplicates` set.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
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

fun findDuplicatesHashSet(array: IntArray): Set<Int> {
    val seen = HashSet<Int>()
    val duplicates = LinkedHashSet<Int>()

    for (num in array) {
        if (!seen.add(num)) {
            duplicates.add(num)
        }
    }

    return duplicates
}

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
