package _6_linked_list._2_medium

import _6_linked_list._1_easy.ListNode
import _6_linked_list._1_easy.printLinkedList

/**
 * _04_FindCycleStartAndRemoveLoop.kt
 * Finds the starting node of a loop and breaks/removes the loop (LeetCode #142).
 *
 * Beginner Explanation:
 * 1. Find meeting point using fast/slow pointers.
 * 2. Reset `slow = head`. Move both `slow` and `fast` 1 step at a time until they meet. The meeting node is the cycle start.
 * 3. Break loop by setting `lastNodeInLoop.next = null`.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val head = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)

    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2 // Cycle to node2

    println("--- Find Cycle Start & Remove Loop ---")
    val cycleStart = findCycleStart(head)
    println("Cycle Starting Node Data: ${cycleStart?.data}")

    removeLoop(head)
    println("List after removing cycle:")
    printLinkedList(head)
}

fun findCycleStart(head: ListNode?): ListNode? {
    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) { // Loop detected
            var temp = head
            while (temp != slow) {
                temp = temp?.next
                slow = slow?.next
            }
            return temp // Cycle starting node
        }
    }

    return null
}

fun removeLoop(head: ListNode?) {
    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) {
            var temp = head
            while (temp?.next != slow?.next) {
                temp = temp?.next
                slow = slow?.next
            }
            slow?.next = null // Break loop link
            return
        }
    }
}
