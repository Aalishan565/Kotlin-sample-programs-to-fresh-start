package _4_stack._3_hard

import java.util.ArrayDeque

/**
 * _03_OnlineStockSpan.kt
 * Calculates stock span (consecutive days price <= today's price) using Monotonic Stack (LeetCode #901).
 *
 * Beginner Explanation:
 * Maintain a stack storing pairs of `(price, span)`.
 * When today's price >= `stack.peek().price`, pop and accumulate span:
 * `span += popped.span`.
 *
 * Time Complexity: O(1) Amortized per query
 * Space Complexity: O(N)
 */
fun main() {
    println("--- Online Stock Span ---")
    val stockSpanner = StockSpanner()

    val prices = listOf(100, 80, 60, 70, 60, 75, 85)
    for (price in prices) {
        val span = stockSpanner.next(price)
        println("Price: ${price.toString().padStart(3)} -> Span: $span day(s)")
    }
}

class StockSpanner {
    private data class PriceSpan(val price: Int, val span: Int)
    private val stack = ArrayDeque<PriceSpan>()

    fun next(price: Int): Int {
        var span = 1
        while (stack.isNotEmpty() && stack.peek()!!.price <= price) {
            span += stack.pop().span
        }
        stack.push(PriceSpan(price, span))
        return span
    }
}
