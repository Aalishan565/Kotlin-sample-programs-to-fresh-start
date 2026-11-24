package _3_arrays._2_medium

import kotlin.math.max
import kotlin.math.min

/**
 * _22_MaxProfitStock.kt
 * Best Time to Buy and Sell Stock (Single transaction & Multiple transactions - LeetCode #121 & #122).
 *
 * Beginner Explanation:
 * - Single Transaction: Track minimum buying price so far and maximum profit if sold today.
 * - Multiple Transactions: Sum all positive price increases (`prices[i] - prices[i-1]`).
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val stockPrices = intArrayOf(5, 2, 6, 1, 4)

    println("--- Stock Buy and Sell Profit ---")
    println("Prices: ${stockPrices.joinToString(", ")}")

    println("Max Profit (1 Transaction) : ${maxProfitSingleTransaction(stockPrices)}")
    println("Max Profit (N Transactions): ${maxProfitMultipleTransactions(stockPrices)}")
}

fun maxProfitSingleTransaction(prices: IntArray): Int {
    if (prices.isEmpty()) return 0

    var minBuyPrice = prices[0]
    var maxProfit = 0

    for (price in prices) {
        minBuyPrice = min(minBuyPrice, price)
        val profitIfSoldToday = price - minBuyPrice
        maxProfit = max(maxProfit, profitIfSoldToday)
    }

    return maxProfit
}

fun maxProfitMultipleTransactions(prices: IntArray): Int {
    var totalProfit = 0
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1]) {
            totalProfit += prices[i] - prices[i - 1]
        }
    }
    return totalProfit
}
