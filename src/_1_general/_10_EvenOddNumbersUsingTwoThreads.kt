package _1_general

import kotlin.concurrent.thread

/**
 * _10_EvenOddNumbersUsingTwoThreads.kt
 * Demonstrates alternating thread synchronization to print Even and Odd numbers sequentially.
 *
 * Problem Statement:
 * - Odd Thread prints only ODD numbers (1, 3, 5, 7, 9...).
 * - Even Thread prints only EVEN numbers (2, 4, 6, 8, 10...).
 * - The output must be printed strictly in sequence from 1 up to N.
 *
 * Synchronization Logic:
 * - Both threads enter a `synchronized(lock)` monitor block.
 * - If it's not a thread's turn (e.g. Even Thread when counter is odd), it calls `lock.wait()`.
 * - After printing its number and incrementing `counter`, the thread calls `lock.notifyAll()` to wake the waiting thread.
 */
fun main() {
    val threadSample = ThreadSample()
    threadSample.startPrinting()
}

class ThreadSample {
    val number = 10
    private var counter = 1
    private lateinit var evenThread: Thread
    private lateinit var oddThread: Thread
    private val lock = Object()

    fun startPrinting() {
        oddThread = thread(name = "Odd Thread") { printOdd() }
        evenThread = thread(name = "Even Thread") { printEven() }
    }

    private fun printOdd() {
        synchronized(lock) {
            while (counter <= number) {
                println("$counter Current Thread is ${Thread.currentThread().name}")
                counter++
                lock.notify()
                if (counter % 2 == 0) {
                    try {
                        //println("wait(): " + Thread.currentThread().name);
                        lock.wait()
                    } catch (e: InterruptedException) {
                    }
                }
            }
        }
    }

    private fun printEven() {
        synchronized(lock) {
            while (counter <= number) {
                println("$counter Current Thread is ${Thread.currentThread().name}")
                counter++
                lock.notify()
                if (counter % 2 == 1) {
                    try {
                        //  println("wait(): " + Thread.currentThread().name);
                        lock.wait()
                    } catch (e: InterruptedException) {
                    }
                }
            }
        }
    }

}


