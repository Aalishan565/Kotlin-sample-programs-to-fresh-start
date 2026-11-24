package _4_stack._1_easy

import java.util.ArrayDeque

/**
 * _03_ValidParentheses.kt
 * Validates if a string containing brackets `()`, `{}`, `[]` is balanced (LeetCode #20).
 *
 * Beginner Explanation:
 * Push opening brackets onto stack.
 * When encountering a closing bracket, pop from stack and check if it matches the corresponding opening bracket.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
fun main() {
    val testCases = listOf("()", "()[]{}", "(]", "([{}])", "(((")

    println("--- Valid Parentheses ---")
    for (s in testCases) {
        println("String: \"$s\" -> Valid? ${isValidParentheses(s)}")
    }
}

fun isValidParentheses(s: String): Boolean {
    val stack = ArrayDeque<Char>()

    for (ch in s) {
        when (ch) {
            '(', '{', '[' -> stack.push(ch)
            ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
            '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
            ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
        }
    }

    return stack.isEmpty()
}
