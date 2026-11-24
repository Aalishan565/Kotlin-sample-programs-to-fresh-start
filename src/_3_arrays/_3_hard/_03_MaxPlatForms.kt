package _3_arrays._3_hard

import kotlin.math.max

/**
 * _03_MaxPlatForms.kt
 * Finds the minimum number of railway platforms required for trains based on arrival and departure times.
 */
fun main() {
    val arrival = intArrayOf(1, 3, 4, 7, 8)
    val departure = intArrayOf(2, 5, 6, 7, 9)

    println("--- Minimum Railway Platforms Needed ---")
    val minPlatforms = findMinPlatforms(arrival, departure)
    println("Minimum Platforms Needed: $minPlatforms")
}

fun findMinPlatforms(arrival: IntArray, departure: IntArray): Int {
    val arr = arrival.sortedArray()
    val dep = departure.sortedArray()

    var count = 0
    var maxCount = 0
    var i = 0
    var j = 0

    while (i < arr.size) {
        if (arr[i] < dep[j]) {
            count++
            i++
            maxCount = max(maxCount, count)
        } else {
            count--
            j++
        }
    }

    return maxCount
}
