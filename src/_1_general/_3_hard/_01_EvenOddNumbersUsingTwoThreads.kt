package _1_general._3_hard

import kotlin.concurrent.thread

/**
 * _01_EvenOddNumbersUsingTwoThreads.kt
 * Demonstrates alternating thread synchronization to print Even and Odd numbers sequentially.
 *
 * Problem Statement:
 * - Odd Thread prints only ODD numbers (1, 3, 5, 7, 9...).
 * - Even Thread prints only EVEN numbers (2, 4, 6, 8, 10...).
 * - Output must be printed strictly in sequence from 1 up to N.
 *
 * Synchronization Logic:
 * - Both threads enter a `synchronized(lock)` monitor block.
 * - If it's not a thread's turn, it calls `lock.wait()`.
 * - After printing and incrementing `counter`, calls `lock.notifyAll()`.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val printer = EvenOddThreadPrinter(maxLimit = 10)
    printer.startPrinting()
}

class EvenOddThreadPrinter(private val maxLimit: Int) {
    private var counter = 1

    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    private val lock = Object()

    fun startPrinting() {
        val oddThread = thread(name = "Odd-Thread", start = false) { printOdd() }
        val evenThread = thread(name = "Even-Thread", start = false) { printEven() }

        // Start both threads
        oddThread.start()
        evenThread.start()

        // Wait for both threads to finish execution
        oddThread.join()
        evenThread.join()

        println("Finished printing numbers 1 to $maxLimit.")
    }

    private fun printOdd() {
        synchronized(lock) {
            while (counter <= maxLimit) {
                while (counter % 2 == 0 && counter <= maxLimit) {
                    try {
                        lock.wait()
                    } catch (e: InterruptedException) {
                        println("Odd thread interrupted: ${e.message}")
                        Thread.currentThread().interrupt()
                    }
                }

                if (counter <= maxLimit) {
                    println("[${Thread.currentThread().name}] -> $counter")
                    counter++
                    lock.notifyAll()
                }
            }
        }
    }

    private fun printEven() {
        synchronized(lock) {
            while (counter <= maxLimit) {
                while (counter % 2 != 0 && counter <= maxLimit) {
                    try {
                        lock.wait()
                    } catch (e: InterruptedException) {
                        println("Even thread interrupted: ${e.message}")
                        Thread.currentThread().interrupt()
                    }
                }

                if (counter <= maxLimit) {
                    println("[${Thread.currentThread().name}] -> $counter")
                    counter++
                    lock.notifyAll()
                }
            }
        }
    }
}
