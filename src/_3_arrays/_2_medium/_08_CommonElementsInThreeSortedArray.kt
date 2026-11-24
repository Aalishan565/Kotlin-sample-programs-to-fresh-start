package _3_arrays._2_medium

/**
 * _08_CommonElementsInThreeSortedArray.kt
 * Finds common elements across three sorted arrays in O(N1 + N2 + N3) time.
 */
fun main() {
    val array1 = intArrayOf(1, 3, 3, 5, 8, 9)
    val array2 = intArrayOf(1, 2, 3, 3, 4, 4, 5, 8)
    val array3 = intArrayOf(1, 3, 8, 9)

    println("--- Common Elements in Three Sorted Arrays ---")
    val common = findCommonElementsInThreeSortedArrays(array1, array2, array3)
    println("Common Elements: $common")
}

fun findCommonElementsInThreeSortedArrays(array1: IntArray, array2: IntArray, array3: IntArray): List<Int> {
    val result = mutableListOf<Int>()
    var i = 0
    var j = 0
    var k = 0

    while (i < array1.size && j < array2.size && k < array3.size) {
        if (array1[i] == array2[j] && array2[j] == array3[k]) {
            if (result.isEmpty() || result.last() != array1[i]) {
                result.add(array1[i])
            }
            i++
            j++
            k++
        } else if (array1[i] < array2[j]) {
            i++
        } else if (array2[j] < array3[k]) {
            j++
        } else {
            k++
        }
    }

    return result
}
