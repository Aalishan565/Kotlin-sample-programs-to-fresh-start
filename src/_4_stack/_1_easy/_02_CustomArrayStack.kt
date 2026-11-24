package _4_stack._1_easy

/**
 * _02_CustomArrayStack.kt
 * Custom fixed-size Stack implementation using an Array.
 *
 * Time Complexity: O(1) for push, pop, peek, isEmpty, isFull
 * Space Complexity: O(N) where N is capacity
 */
fun main() {
    println("--- Custom Array-Based Stack ---")
    val stack = ArrayStack(capacity = 5)

    stack.push(10)
    stack.push(20)
    stack.push(30)

    println("Top element (peek): ${stack.peek()}")
    println("Popped: ${stack.pop()}")
    println("Popped: ${stack.pop()}")

    println("Is Empty? ${stack.isEmpty()}")
    println("Current Size: ${stack.size()}")
}

class ArrayStack(private val capacity: Int) {
    private val array = IntArray(capacity)
    private var topIndex = -1

    fun push(element: Int) {
        if (isFull()) {
            println("Stack Overflow! Cannot push $element")
            return
        }
        topIndex++
        array[topIndex] = element
    }

    fun pop(): Int? {
        if (isEmpty()) {
            println("Stack Underflow! Cannot pop from empty stack")
            return null
        }
        val element = array[topIndex]
        topIndex--
        return element
    }

    fun peek(): Int? {
        if (isEmpty()) return null
        return array[topIndex]
    }

    fun isEmpty(): Boolean = topIndex == -1

    fun isFull(): Boolean = topIndex == capacity - 1

    fun size(): Int = topIndex + 1
}
