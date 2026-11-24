package _5_queue._3_hard

/**
 * _02_TaskScheduler.kt
 * Calculates minimum CPU intervals to execute tasks with cooling period N (LeetCode #621).
 *
 * Beginner Explanation:
 * Max-Heap tracks highest frequency tasks.
 * Queue tracks cooling tasks `(frequency, availableTime)`.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1) (26 alphabet uppercase task letters)
 */
fun main() {
    val tasks = charArrayOf('A', 'A', 'A', 'B', 'B', 'B')
    val n = 2

    println("--- Task Scheduler ---")
    println("Tasks: [${tasks.joinToString(", ")}], Cooling Interval N = $n")

    val leastIntervals = leastInterval(tasks, n)
    println("Minimum CPU Intervals Needed: $leastIntervals")
}

fun leastInterval(tasks: CharArray, n: Int): Int {
    if (n == 0) return tasks.size

    val taskCounts = IntArray(26)
    for (task in tasks) {
        taskCounts[task - 'A']++
    }

    // Sort frequencies in descending order
    taskCounts.sort()
    val maxCount = taskCounts[25]
    var idleSlots = (maxCount - 1) * n

    for (i in 24 downTo 0) {
        if (taskCounts[i] == 0) break
        idleSlots -= minOf(taskCounts[i], maxCount - 1)
    }

    return if (idleSlots > 0) tasks.size + idleSlots else tasks.size
}
