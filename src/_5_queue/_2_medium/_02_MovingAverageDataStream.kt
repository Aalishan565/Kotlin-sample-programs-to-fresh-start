package _5_queue._2_medium

import java.util.ArrayDeque

/**
 * _02_MovingAverageDataStream.kt
 * Calculates moving average of last `windowSize` numbers from a data stream (LeetCode #346).
 *
 * Beginner Explanation:
 * Maintain a Queue of size `windowSize` and running `windowSum`.
 * When stream exceeds `windowSize`, pop oldest element and subtract from `windowSum`.
 *
 * Time Complexity: O(1) per stream element
 * Space Complexity: O(K) where K is windowSize
 */
fun main() {
    println("--- Moving Average from Data Stream ---")
    val movingAverage = MovingAverage(windowSize = 3)

    println("next(1)  -> Average: ${movingAverage.next(1)}")  // 1.0
    println("next(10) -> Average: ${movingAverage.next(10)}") // (1 + 10) / 2 = 5.5
    println("next(3)  -> Average: ${movingAverage.next(3)}")  // (1 + 10 + 3) / 3 = 4.666
    println("next(5)  -> Average: ${movingAverage.next(5)}")  // (10 + 3 + 5) / 3 = 6.0
}

class MovingAverage(private val windowSize: Int) {
    private val queue = ArrayDeque<Int>()
    private var windowSum = 0.0

    fun next(valNum: Int): Double {
        queue.addLast(valNum)
        windowSum += valNum

        if (queue.size > windowSize) {
            windowSum -= queue.removeFirst()
        }

        return windowSum / queue.size
    }
}
