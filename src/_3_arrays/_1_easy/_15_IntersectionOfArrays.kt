package _3_arrays._1_easy

/**
 * _15_IntersectionOfArrays.kt
 * Finds the intersection of two integer arrays (elements common to both arrays).
 *
 * Beginner Explanation:
 * Converts arrays to sets and uses set intersection `.intersect()` or HashSet lookup.
 *
 * Time Complexity: O(N + M)
 * Space Complexity: O(N + M)
 */
fun main() {
    val array1 = intArrayOf(1, 3, 3, 5, 7, 9)
    val array2 = intArrayOf(1, 2, 3, 3, 4, 4, 5)

    println("--- Intersection of Two Arrays ---")
    println("Array 1: ${array1.joinToString(", ")}")
    println("Array 2: ${array2.joinToString(", ")}")

    val intersection = getIntersection(array1, array2)
    println("Intersection Elements: $intersection")
}

fun getIntersection(array1: IntArray, array2: IntArray): Set<Int> {
    val set1 = array1.toSet()
    val set2 = array2.toSet()
    return set1.intersect(set2)
}
