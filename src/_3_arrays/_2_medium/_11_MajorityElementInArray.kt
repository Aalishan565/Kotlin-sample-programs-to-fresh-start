package _3_arrays._2_medium

/**
 * _11_MajorityElementInArray.kt
 * Finds the Majority Element in an array (> N/2 occurrences).
 */
fun main() {
    val testArrays = listOf(
        intArrayOf(3, 2, 3),
        intArrayOf(2, 2, 1, 1, 1, 2, 2),
        intArrayOf(1, 2, 3, 4)
    )

    println("--- Majority Element (> N/2 Times) ---")
    for (arr in testArrays) {
        val majorityBoyerMoore = findMajorityElementBoyerMoore(arr)
        val majorityHashMap = findMajorityElementHashMap(arr)
        val majoritySorting = findMajorityElementSorting(arr)

        println(
            "Array: ${
                arr.joinToString(", ").padStart(22)
            } -> Boyer-Moore: $majorityBoyerMoore | HashMap: $majorityHashMap | Sorting: $majoritySorting"
        )
    }
}

fun findMajorityElementSorting(array: IntArray): Int? {
    if (array.isEmpty()) return null
    val sorted = array.sortedArray()
    val candidate = sorted[sorted.size / 2]
    val count = sorted.count { it == candidate }
    return if (count > sorted.size / 2) candidate else null
}

fun findMajorityElementBoyerMoore(array: IntArray): Int? {
    if (array.isEmpty()) return null
    var candidate: Int? = null
    var count = 0

    for (num in array) {
        if (count == 0) {
            candidate = num
            count = 1
        } else if (num == candidate) {
            count++
        } else {
            count--
        }
    }

    candidate?.let { cand ->
        val occurrences = array.count { it == cand }
        if (occurrences > array.size / 2) return cand
    }

    return null
}

fun findMajorityElementHashMap(array: IntArray): Int? {
    val threshold = array.size / 2
    val frequencyMap = HashMap<Int, Int>()

    for (num in array) {
        val count = frequencyMap.getOrDefault(num, 0) + 1
        if (count > threshold) return num
        frequencyMap[num] = count
    }

    return null
}
