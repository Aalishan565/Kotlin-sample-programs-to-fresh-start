package _4_stack._1_easy

/**
 * _01_CustomLinkedListStack.kt
 * Custom Stack implementation using a Singly Linked List (LIFO - Last In First Out).
 *
 * Operations:
 * - push(data): Adds element to top of stack - O(1)
 * - pop(): Removes and returns top element - O(1)
 * - peek(): Returns top element without removing - O(1)
 * - isEmpty(): Checks if stack has no elements - O(1)
 */
fun main() {
    println("--- Custom Linked List Stack ---")
    val stack = LinkedListStack<Int>()

    stack.push(10)
    stack.push(12)
    stack.push(15)
    stack.push(17)

    println("Current Stack:")
    stack.printStack()

    println("\nPopped element: ${stack.pop()}")
    println("Popped element: ${stack.pop()}")

    println("\nCurrent Top Element (peek): ${stack.peek()}")
    println("Stack Size: ${stack.size()}")

    println("\nRemaining Stack:")
    stack.printStack()
}

class LinkedListStack<T> {
    private class Node<T>(val data: T, var next: Node<T>? = null)

    private var top: Node<T>? = null
    private var count = 0

    fun push(data: T) {
        val newNode = Node(data, top)
        top = newNode
        count++
    }

    fun pop(): T? {
        if (isEmpty()) return null
        val poppedData = top?.data
        top = top?.next
        count--
        return poppedData
    }

    fun peek(): T? {
        return top?.data
    }

    fun isEmpty(): Boolean {
        return top == null
    }

    fun size(): Int {
        return count
    }

    fun printStack() {
        if (isEmpty()) {
            println("Stack is empty.")
            return
        }
        var temp = top
        val elements = mutableListOf<T>()
        while (temp != null) {
            elements.add(temp.data)
            temp = temp.next
        }
        println("Top -> [${elements.joinToString(" -> ")}]")
    }
}
