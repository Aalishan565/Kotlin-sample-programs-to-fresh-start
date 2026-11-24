package _4_stack._2_medium

import java.util.ArrayDeque

/**
 * _03_EvaluateReversePolishNotation.kt
 * Evaluates arithmetic expression in Reverse Polish Notation / Postfix (LeetCode #150).
 *
 * Beginner Explanation:
 * Iterate through tokens:
 * - If token is number: push onto stack.
 * - If token is operator (`+`, `-`, `*`, `/`): pop two operands `b` and `a`, compute `a op b`, and push result back.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
fun main() {
    val tokens1 = arrayOf("2", "1", "+", "3", "*") // (2 + 1) * 3 = 9
    val tokens2 = arrayOf("4", "13", "5", "/", "+") // 4 + (13 / 5) = 6

    println("--- Evaluate Reverse Polish Notation ---")
    println("Tokens 1: [${tokens1.joinToString(", ")}] = ${evalRPN(tokens1)}")
    println("Tokens 2: [${tokens2.joinToString(", ")}] = ${evalRPN(tokens2)}")
}

fun evalRPN(tokens: Array<String>): Int {
    val stack = ArrayDeque<Int>()

    for (token in tokens) {
        when (token) {
            "+" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a + b)
            }
            "-" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a - b)
            }
            "*" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a * b)
            }
            "/" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a / b)
            }
            else -> stack.push(token.toInt())
        }
    }

    return stack.pop()
}
