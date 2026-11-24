package _3_arrays._3_hard

import java.util.PriorityQueue

/**
 * _05_ConnectNRopesMinCostArray.kt
 * Connects N ropes with minimum cost using Min-Heap / PriorityQueue.
 */
fun main() {
    val ropeLengths = intArrayOf(2, 5, 4, 8, 6, 9)

    println("--- Connect N Ropes With Minimum Cost ---")
    println("Rope Lengths: ${ropeLengths.joinToString(", ")}")

    val minCost = findMinCostToConnectRopes(ropeLengths)
    println("Minimum Total Cost: $minCost")
}

fun findMinCostToConnectRopes(nums: IntArray): Int {
    val minHeap = PriorityQueue<Int>()
    for (num in nums) {
        minHeap.offer(num)
    }

    var totalCost = 0
    while (minHeap.size > 1) {
        val firstMin = minHeap.poll()!!
        val secondMin = minHeap.poll()!!
        val sum = firstMin + secondMin
        totalCost += sum
        minHeap.offer(sum)
    }

    return totalCost
}
